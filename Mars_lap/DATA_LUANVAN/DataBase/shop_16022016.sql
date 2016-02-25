-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               10.1.9-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for shoponline
CREATE DATABASE IF NOT EXISTS `shoponline` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `shoponline`;


-- Dumping structure for table shoponline.chitiethoadon
CREATE TABLE IF NOT EXISTS `chitiethoadon` (
  `id_chitiethoadon` int(11) NOT NULL AUTO_INCREMENT,
  `id_hoadon` int(11) NOT NULL,
  `id_sanpham` int(11) NOT NULL,
  `soluong` int(11) NOT NULL DEFAULT '0',
  `dongia` double NOT NULL DEFAULT '0',
  `giamgia` int(11) NOT NULL DEFAULT '0',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_chitiethoadon`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table shoponline.chitiethoadon: ~2 rows (approximately)
DELETE FROM `chitiethoadon`;
/*!40000 ALTER TABLE `chitiethoadon` DISABLE KEYS */;
INSERT INTO `chitiethoadon` (`id_chitiethoadon`, `id_hoadon`, `id_sanpham`, `soluong`, `dongia`, `giamgia`, `created`) VALUES
	(1, 10, 1, 13, 319000, 41, '2016-02-16 23:10:37'),
	(2, 10, 2, 16, 299000, 0, '2016-02-16 23:11:39');
/*!40000 ALTER TABLE `chitiethoadon` ENABLE KEYS */;


-- Dumping structure for table shoponline.danhmuc
CREATE TABLE IF NOT EXISTS `danhmuc` (
  `id_danhmuc` int(11) NOT NULL AUTO_INCREMENT,
  `tendanhmuc` varchar(255) NOT NULL DEFAULT '',
  `danhmuccha` varchar(50) NOT NULL DEFAULT '0',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_danhmuc`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- Dumping data for table shoponline.danhmuc: ~16 rows (approximately)
DELETE FROM `danhmuc`;
/*!40000 ALTER TABLE `danhmuc` DISABLE KEYS */;
INSERT INTO `danhmuc` (`id_danhmuc`, `tendanhmuc`, `danhmuccha`, `created`) VALUES
	(1, 'Thời trang nam', '0', '2016-01-27 15:21:55'),
	(12, 'Đồ vét', '1', '2016-01-27 20:09:26'),
	(13, 'Quần nam', '1', '2016-01-27 20:09:39'),
	(14, 'Áo sơ mi', '1', '2016-01-27 20:24:18'),
	(15, 'Thời trang nữ', '0', '2016-01-27 20:10:03'),
	(16, 'Áo thun nữ', '15', '2016-01-27 20:10:32'),
	(17, 'Chân váy', '15', '2016-01-27 20:10:39'),
	(18, 'Quần nữ', '15', '2016-01-27 20:11:03'),
	(19, 'Bé trai', '0', '2016-01-27 20:11:09'),
	(20, 'Áo', '19', '2016-01-27 20:11:19'),
	(21, 'Quần', '19', '2016-01-27 20:11:24'),
	(22, 'Đồ ngủ', '19', '2016-01-27 20:11:48'),
	(23, 'Bé gái', '0', '2016-01-27 20:11:53'),
	(24, 'Quần', '23', '2016-01-27 20:12:17'),
	(25, 'Đầm', '23', '2016-01-27 20:12:25'),
	(26, 'Áo ấm', '23', '2016-01-27 20:12:31');
/*!40000 ALTER TABLE `danhmuc` ENABLE KEYS */;


-- Dumping structure for function shoponline.func_cthoadon
DELIMITER //
CREATE DEFINER=`luanvan`@`localhost` FUNCTION `func_cthoadon`(`rq_id_hoadon` INT, `rq_id_sanpham` INT, `rq_soluong` INT, `rq_dongia` DOUBLE, `rq_giamgia` INT) RETURNS text CHARSET utf8
BEGIN
	# select func_cthoadon(10,1,1,319000,41);
	DECLARE r_res TEXT;
	DECLARE r_count_idhoadon INT default 0;
	DECLARE r_count_hoadonsp INT default 0;
	DECLARE r_soluong INT default 0;
	DECLARE r_count_sanpham INT default 0;
	
	Select count(hoadon.id_hoadon) into r_count_idhoadon
	from hoadon
	where hoadon.id_hoadon=rq_id_hoadon;
	select count(sanpham.id_sanpham) into r_count_sanpham
	from sanpham
	where sanpham.id_sanpham=rq_id_sanpham;
	if (r_count_idhoadon>0) && (r_count_sanpham>0) then
		begin
			Select COUNT(chitiethoadon.id_chitiethoadon),chitiethoadon.soluong into r_count_hoadonsp,r_soluong
			from chitiethoadon
			where chitiethoadon.id_hoadon=rq_id_hoadon
			and chitiethoadon.id_sanpham=rq_id_sanpham;
			
			if r_count_hoadonsp>0 then 
				begin
					UPDATE chitiethoadon
					SET chitiethoadon.soluong=r_soluong+rq_soluong
					where chitiethoadon.id_hoadon=rq_id_hoadon
					and chitiethoadon.id_sanpham=rq_id_sanpham;
					IF (select ROW_COUNT())>0 then
						# Thành công thì trả về id_hoadon
						SET r_res=(select chitiethoadon.id_chitiethoadon from chitiethoadon where chitiethoadon.id_hoadon=rq_id_hoadon	and chitiethoadon.id_sanpham=rq_id_sanpham);
					ELSE
						#Update thất bại thì trả về lỗi hệ thống
						SET r_res="-2";
					END IF;
				end;
			else
				begin
					INSERT INTO chitiethoadon(chitiethoadon.id_hoadon,chitiethoadon.id_sanpham,chitiethoadon.soluong,chitiethoadon.dongia,chitiethoadon.giamgia)
					VALUES(rq_id_hoadon,rq_id_sanpham,rq_soluong,rq_dongia,rq_giamgia);
					IF (select ROW_COUNT())>0 then
						# Thành công thì trả về id_hoadon
						SET r_res=LAST_INSERT_ID();
					ELSE
						#INSERT thất bại thì trả về lỗi hệ thống
						SET r_res="-3";
					END IF;
				end;
			end if;
		end;
	else
		#Lỗi chưa có id_hoadon này
		SET r_res="-1";
	end if;
	return r_res;
END//
DELIMITER ;


-- Dumping structure for function shoponline.func_hoadon
DELIMITER //
CREATE DEFINER=`luanvan`@`localhost` FUNCTION `func_hoadon`(`rq_id_taikhoan` INT) RETURNS text CHARSET utf8
BEGIN
	# select func_hoadon(10);
	DECLARE r_res TEXT;
	DECLARE r_count_taikhoan INT default 0;
	DECLARE r_count_taikhoan_hoadon INT default 0;
	DECLARE r_count_taikhoan_checkhang INT default 0;
	
	Select COUNT(taikhoan.id_taikhoan) INTO r_count_taikhoan
	from taikhoan
	where taikhoan.id_taikhoan=rq_id_taikhoan;
	select COUNT(hoadon.id_taikhoan) into r_count_taikhoan_hoadon
	from hoadon
	where hoadon.id_taikhoan=rq_id_taikhoan;
	select COUNT(hoadon.id_taikhoan) into r_count_taikhoan_checkhang
	from hoadon
	where hoadon.id_taikhoan=rq_id_taikhoan
	and hoadon.checkhang=0;
	
	IF r_count_taikhoan>0 then
		BEGIN		
			IF (EXISTS(select 1 from hoadon where hoadon.id_taikhoan=rq_id_taikhoan and hoadon.checkhang=1) && r_count_taikhoan_checkhang=0) || (r_count_taikhoan_hoadon=0)   THEN
				BEGIN
					INSERT INTO hoadon(hoadon.id_taikhoan)
					VALUES(rq_id_taikhoan);
					IF (select ROW_COUNT())>0 then
						BEGIN					
							#Thành công
							SET r_res=LAST_INSERT_ID();
						END;				
					ELse
						#Lỗi hệ thống
						SET r_res="-1";
					end if;
				END;
			ELSE
				BEGIN
					Select hoadon.id_hoadon INTO r_res
					from hoadon
					where hoadon.id_taikhoan=rq_id_taikhoan
					and hoadon.checkhang=0;
				END;
			END IF;
			
		END;
	ELSE
		#Không tìm thấy user này
		SET r_res="0";
	END IF;
	
	return r_res;
END//
DELIMITER ;


-- Dumping structure for function shoponline.func_login
DELIMITER //
CREATE DEFINER=`luanvan`@`localhost` FUNCTION `func_login`(`rq_username` VARCHAR(50), `rq_password` VARCHAR(50)) RETURNS tinytext CHARSET utf8
BEGIN
	# select func_login('nhanhnt','wb/1JnRshCLfYbpGEpitiA==');
	DECLARE r_res TEXT;
	DECLARE r_id_taikhoan INT DEFAULT 0;
	
	IF EXISTS
	(
		SELECT 1 
		FROM taikhoan 
		WHERE taikhoan.tentaikhoan=rq_username 
		AND taikhoan.matkhau=rq_password
		AND taikhoan.role=0
	)
	THEN
		BEGIN
			SELECT taikhoan.id_taikhoan INTO r_id_taikhoan
			FROM taikhoan 
			WHERE taikhoan.tentaikhoan=rq_username 
			AND taikhoan.matkhau=rq_password
			AND taikhoan.role=0;
			
			SET r_res=r_id_taikhoan;
		END;
	ELSE
		SET r_res="-1";
	END IF;
return r_res;
END//
DELIMITER ;


-- Dumping structure for function shoponline.func_muahang_old
DELIMITER //
CREATE DEFINER=`luanvan`@`localhost` FUNCTION `func_muahang_old`(`rq_id_sanpham` INT, `rq_dongia` DOUBLE, `rq_giamgia` INT) RETURNS text CHARSET utf8
BEGIN
	# select func_muahang(1,319000,41);
	DECLARE r_res TEXT;
	DECLARE r_count_sanpham TINYINT default 0;
	DECLARE r_thanhtien DOUBLE default 0;
	
	Select COUNT(sanpham.id_sanpham) INTO r_count_sanpham
	from sanpham
	where sanpham.id_sanpham=rq_id_sanpham;
	
	IF r_count_sanpham>0 then
		BEGIN
			SET r_thanhtien=rq_dongia-(rq_dongia * rq_giamgia)/100;
			INSERT INTO tbl_muahang(tbl_muahang.id_sanpham,tbl_muahang.dongia,tbl_muahang.giamgia,tbl_muahang.thanhtien)
			VALUES(rq_id_sanpham,rq_dongia,rq_giamgia,r_thanhtien);
			IF (select ROW_COUNT())>0 then
				#Thành công
				SET r_res="1";
			ELse
				#Lỗi hệ thống
				SET r_res="-1";
			end if;
		END;
	ELSE
		#Không tìm thấy sản phẩm này
		SET r_res="0";
	END IF;
	
	return r_res;
END//
DELIMITER ;


-- Dumping structure for function shoponline.func_registry
DELIMITER //
CREATE DEFINER=`luanvan`@`localhost` FUNCTION `func_registry`(`rq_username` VARCHAR(50), `rq_password` VARCHAR(50), `rq_email` VARCHAR(50)) RETURNS text CHARSET utf8
BEGIN
#select func_registry('nhanhnt','wb/1JnRshCLfYbpGEpitiA==','honguyenthanhnhan@gmail.com');

	DECLARE response TEXT;
	DECLARE c_user,c_email INT DEFAULT(0);

	SELECT Count(taikhoan.id_taikhoan) into c_user FROM taikhoan where taikhoan.tentaikhoan=rq_username;
	select COUNT(taikhoan.email) into c_email from taikhoan where taikhoan.email=rq_email;
	#IF (c_user>0 || c_email>0) THEN
	IF (c_user>0 ) THEN
		# User đã tồn tại trong hệ thống : -1
		SET response='-1';
	ELSE
		IF c_email>0 THEN
			# Email đã tồn tại trong hệ thống
			SET response='-2';
	ELSE
		BEGIN
			INSERT INTO taikhoan(taikhoan.tentaikhoan,taikhoan.matkhau,taikhoan.email,taikhoan.created)	
			VALUES (rq_username,rq_password,rq_email,now());
			IF (SELECT ROW_COUNT())>0 THEN
				# Đăng ký thành công
				SET response='1'; 
			ELSE
				# Lỗi hệ thống
				SET response='0';
			END IF;
		END;
	END IF;
	END IF;	
				
	RETURN response;
END//
DELIMITER ;


-- Dumping structure for table shoponline.hoadon
CREATE TABLE IF NOT EXISTS `hoadon` (
  `id_hoadon` int(11) NOT NULL AUTO_INCREMENT,
  `id_taikhoan` int(11) NOT NULL,
  `diachigiaohang` varchar(50) NOT NULL DEFAULT '',
  `phuongthucthanhtoan` varchar(50) NOT NULL DEFAULT '',
  `ngaygiaohang` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ngaymuahang` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `phiship` double NOT NULL DEFAULT '0',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1 đã trả tiền, 0 chưa trả tiền',
  `checkhang` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1 Đã thanh toán, 0 chưa thanh toán',
  PRIMARY KEY (`id_hoadon`),
  KEY `fk_id_taikhoan` (`id_taikhoan`),
  CONSTRAINT `fk_id_taikhoan` FOREIGN KEY (`id_taikhoan`) REFERENCES `taikhoan` (`id_taikhoan`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Dumping data for table shoponline.hoadon: ~2 rows (approximately)
DELETE FROM `hoadon`;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
INSERT INTO `hoadon` (`id_hoadon`, `id_taikhoan`, `diachigiaohang`, `phuongthucthanhtoan`, `ngaygiaohang`, `ngaymuahang`, `phiship`, `status`, `checkhang`) VALUES
	(9, 10, '', '', '2016-02-16 22:34:22', '2016-02-16 22:34:22', 0, 0, 1),
	(10, 10, '', '', '2016-02-16 22:34:34', '2016-02-16 22:34:34', 0, 0, 0);
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;


-- Dumping structure for procedure shoponline.pro_getdetailsp
DELIMITER //
CREATE DEFINER=`luanvan`@`localhost` PROCEDURE `pro_getdetailsp`(IN `rq_id_sanpham` INT)
BEGIN
	#call pro_getdetailsp(13);
	select sanpham.id_sanpham,sanpham.id_danhmuc,sanpham.tensanpham,sanpham.hinhanh,sanpham.soluong,sanpham.mota,sanpham.dongia,sanpham.giamgia,
		sanpham.created
	from sanpham
	WHERE sanpham.id_sanpham=rq_id_sanpham;
END//
DELIMITER ;


-- Dumping structure for procedure shoponline.pro_getdmcha
DELIMITER //
CREATE DEFINER=`luanvan`@`localhost` PROCEDURE `pro_getdmcha`()
BEGIN
	#call pro_getdmcha();
	select *  from danhmuc where danhmuc.danhmuccha=0;
END//
DELIMITER ;


-- Dumping structure for procedure shoponline.pro_getdmcon
DELIMITER //
CREATE DEFINER=`luanvan`@`localhost` PROCEDURE `pro_getdmcon`(IN `dmcha` INT)
BEGIN
	#call pro_getdmcon(1);
	select *  from danhmuc where danhmuc.danhmuccha=dmcha;
END//
DELIMITER ;


-- Dumping structure for procedure shoponline.pro_getsanpham
DELIMITER //
CREATE DEFINER=`luanvan`@`localhost` PROCEDURE `pro_getsanpham`(IN `rq_id_danhmuc` INT)
BEGIN
	#call pro_getsanpham(13);
	select sanpham.id_sanpham,sanpham.id_danhmuc,sanpham.tensanpham,sanpham.hinhanh,sanpham.soluong,sanpham.mota,sanpham.dongia,sanpham.giamgia,
		sanpham.created
	from sanpham
	WHERE sanpham.id_danhmuc=rq_id_danhmuc;
END//
DELIMITER ;


-- Dumping structure for procedure shoponline.pro_test
DELIMITER //
CREATE DEFINER=`luanvan`@`localhost` PROCEDURE `pro_test`()
BEGIN
		#call pro_test();
	select 'Lay thong tin tu DATABASE' as 'tt';
END//
DELIMITER ;


-- Dumping structure for table shoponline.sanpham
CREATE TABLE IF NOT EXISTS `sanpham` (
  `id_sanpham` int(11) NOT NULL AUTO_INCREMENT,
  `id_danhmuc` int(11) NOT NULL DEFAULT '0',
  `tensanpham` varchar(255) NOT NULL DEFAULT '',
  `hinhanh` varchar(255) NOT NULL DEFAULT '',
  `soluong` int(11) NOT NULL DEFAULT '0',
  `mota` longtext NOT NULL,
  `dongia` double NOT NULL DEFAULT '0',
  `giamgia` int(11) NOT NULL DEFAULT '0',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_sanpham`),
  KEY `fk_id_danhmuc` (`id_danhmuc`),
  CONSTRAINT `fk_id_danhmuc` FOREIGN KEY (`id_danhmuc`) REFERENCES `danhmuc` (`id_danhmuc`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- Dumping data for table shoponline.sanpham: ~17 rows (approximately)
DELETE FROM `sanpham`;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` (`id_sanpham`, `id_danhmuc`, `tensanpham`, `hinhanh`, `soluong`, `mota`, `dongia`, `giamgia`, `created`) VALUES
	(1, 12, 'Áo vét Nam 2 lớp', 'images/sanpham/dovet1', 18, 'ĐIỂM NỔI BẬT\r\n- Thiết kế vừa sang trọng, lịch lãm vừa trẻ trung, năng động.\r\n- Mang đến cho phái mạnh vẻ sang trọng, lịch lãm và vô cùng cá tính. \r\n- Phù hợp cho những sự kiện, cuộc hẹn hò lãng mạn, hay những buổi hẹn, party...\r\n- Chất liệu: Kaki Hàn Quốc thoáng mát.\r\n- Phù hợp với bạn dưới 70kg (tùy chiều cao)', 319000, 41, '2016-02-05 23:02:11'),
	(2, 12, 'Áo vét viền màu', 'images/sanpham/dovet2', 15, 'Một chiếc áo vest thời trang và đẹp không chỉ thể hiện phong cách nam tính mà còn làm bật lên vẻ đẹp sang trọng và lịch lãm của phái mạnh. Chiếc áo vest thời trang nam chắc chắn sẽ làm bạn được chú ý bởi chất liệu cao cấp và thiết kế độc đáo của nó. Chiếc áo vest thời trang nam với thiết kế trẻ trung năng động kết hợp kiểu dáng đơn giản làm cho chiếc áo trở lên sang trọng và mạnh mẽ hơn bao giờ hết. Đặc biêt, chiếc áo vest thời trang nam được làm từ chất liệu kaki Hàn Quốc cao cấp đi kèm với lớp dù mềm mịn thoáng mát, mang tới cho bạn cảm giác dễ chịu và thoải mãn mỗi khi mặc nó và góp phần làm tôn lên vẻ điển trai của bạn ở mọi lúc, mọi nơi.', 299000, 0, '2016-02-05 23:02:16'),
	(3, 12, 'Áo vest FAL AKV01', 'images/sanpham/dovet3', 6, 'ÁO VEST, màu: XANH, chất liệu: COTTON, xuất xứ Việt Nam, trẻ trung, thời trang, không bảo hành, M: Dài áo 70, rộng vai 41, vòng ngực 51*2. ,L: Dài áo 71, rộng vai 42, vòng ngực 52*2., XL: Dài áo 73, rộng vai 44, vòng ngực 53*2.,', 319000, 0, '2016-02-05 23:02:19'),
	(4, 12, 'Áo Blazer Name New Look', 'images/sanpham/dovet4', 7, 'New Look là thương hiệu thời trang trẻ trung, cá tính đến từ nước Anh. Sản phẩm luôn được cập nhật theo những xu hướng mới nhất, được ưa chuộng nhất để bạn có thể bổ sung vào tủ quần áo của mình. Quan tâm đến ngoại hình và xu hướng thời trang phù hợp, New Look cho bạn rất nhiều sự lựa chọn với mức giá vô cùng hợp lý. Các cô nàng có thể tìm thấy tất cả những gì mình mong muốn cho bất kỳ dịp đặc biệt nào với New Look.\r\n\r\nThông tin sản phẩm\r\n- Giặt máy \r\n- Chất liệu: 98% Polyester, 2% Elastane', 1600000, 8, '2016-02-05 23:02:22'),
	(5, 12, 'Áo vest nam SAIGONBOY V03', 'images/sanpham/dovet5', 19, 'THÔNG TIN SẢN PHẨM\r\n- Chất liệu kaki cao cấp\r\n- Thiết kế thời trang; nam tính\r\n- Dễ dàng kết hợp trang phục', 279000, 0, '2016-02-05 23:02:25'),
	(6, 12, 'Áo vest nam TUTTAT 8042-19', 'images/sanpham/dovet6', 7, 'TUTTAT sẽ mang lại cho khách hàng những trải nghiệm mua sắm thời trang trực tuyến thú vị từ các mẫu mã kiểu dáng thời trang nam mới nhất. Thời trang TUTTAT luôn đổi mới từng ngày với những bộ sưu tập thời trang nam từ giày dép, trang phục, phụ kiện theo trào lưu mới nhất. TUTTAT cam kết chất lượng phục vụ hàng đầu cùng với những với những xu hướng thời trang mới nhất. Bạn có thể tìm thấy những bộ trang phục mình yêu thích, từ những bộ đồ mặc nhà thật thoải mái hay tự tin trong những trang phục công sở thanh lịch. Đừng bỏ lỡ những trải nghiệm mua sắm thú vị tạiTUTTAT – THỜI TRANG NAM PHONG CÁCH\r\n\r\nĐẶC ĐIỂM NỔI BẬT\r\n Loại sản phẩm:\r\n Áo vest với đa dạng mẫu mã sở hữu phong cách từ công sở lịch thiệp đến thời trang dạo phố sành điệu, năng động.\r\nThiết kế đơn giản mà sành điệu \r\nVới phom áo cực chuẩn, kiểu dáng đơn giản, áo vest TUTTAT giúp giúp bạn khéo léo khoe những đường nét mạnh mẽ của cơ thể cũng như nét năng động và quyến rũ rất riêng của mình.\r\nMàu sắc: Thanh lịch, trẻ trung \r\nChất liệu: Cao cấp\r\nXuất xứ: Việt Nam\r\nBảo hành: Không bảo hành', 659000, 0, '2016-02-05 23:02:27'),
	(7, 13, 'Quần tây nam công sở QT106 ', 'images/sanpham/quannam1', 27, 'Bạn thường quan tâm những điều gì về thời trang công sở nam? Có thể quan tâm đến giày nam công sở, vest nam công sở, áo sơ mi công sở… Nhưng bạn đã quan tâm đủ đến quần tây nam chưa? Một bộ đồ công sở có thể nói nên rất nhiều điều về bạn.\r\n\r\nThời trang công sở là sự kết hợp tinh tế của các thành phần quấn, áo và phụ kiện. Quần tây nam là thành phần rất quan trọng tạo nên dáng vẻ và đẳng cấp cho một nam công sở thành đạt.', 364000, 0, '2016-02-05 23:02:30'),
	(8, 14, 'Áo sơ mi nam Prazenta O-ASN261', 'images/sanpham/aosomi1', 15, 'Áo sơ mi nam Prazenta O-ASN261 thiết kế trẻ trung, hợp thời trang\r\nChất liệu: COTTON đem lại sự thoải mái cho người mặc.\r\nSản xuất tại Việt Nam.', 239000, 0, '2016-02-05 23:02:33'),
	(9, 16, 'Áo dáng rộng xòe đuôi cá Nhanh Mua 5697', 'images/sanpham/aothunnu1', 17, 'Điểm nổi bật:\r\n- Áo form rộng xòe đuôi cá thời trang với thiết kế đơn giản, form xòe trẻ trung mang lại nét thanh lịch, dịu dàng.\r\n- Chất liệu cát len mềm mại, thấm hút mồ hôi mang lại cảm giác thông thoáng cho người mặc.\r\n- Thiết kế form suông rộng, xòe nhẹ nhàng, giúp che khuyết điểm hiệu quả.\r\n- Thích hợp diện đi làm, dạo phố, coffee cùng bạn bè…\r\nKÍCH THƯỚC:\r\n- Chất liệu: cát len\r\n- Vòng ngực: 84 - 92 cm\r\n- Vòng eo: 78 - 86 cm\r\n- Chiều dài: 56 cm\r\n- Cân nặng: < 55 kg tùy theo chiều cao', 309000, 0, '2016-02-05 23:02:40'),
	(10, 17, 'Chân váy bút chì Zahra', 'images/sanpham/chanvay1', 27, 'Chân váy dáng dài qua gối- Dáng bút chì sang trọng- Chất liệu co giãn thoải mái', 215000, 0, '2016-02-05 23:02:45'),
	(11, 18, 'Quần legging da bóng', 'images/sanpham/quannu1', 7, 'Điểm nổi bật\r\n\r\n- Quần legging mới cực thời trang, giả da sành điệu, dễ dàng phối với các loại trang phục - phụ kiện khác.\r\n\r\n- Form quần ôm gọn đôi chân, tạo cảm giác thon gọn và hiệu ứng làm dài chân.\r\n\r\n- Thiết kế quần lưng cao, không làm lộ vùng bụng, tôn vòng eo - mông và đùi tuyệt đối, bó sát nhưng quần không gây phô hay phản cảm.\r\n\r\n- Chất thun PU giả da cao cấp, sờ mát và rất giống da nhưng có độ co giãn tốt và không gây bức bí, khó chịu cho người mặc.\r\n\r\n- Quần legging da bóng tạo nên sự quyến rũ mà mạnh mẽ, thích hợp mặc đi chơi, đi dạo phố, tiệc ..v..v..\r\n\r\n- Màu sắc: Đen.', 259000, 0, '2016-02-05 23:02:51'),
	(12, 20, 'Quần áo người nhện Spider Man 110cm', 'images/sanpham/betraiao1', 2, 'Quần Áo Người Nhện Loại Tốt (Tay Dài) là trang phục dành cho các bé trong ngày hallowen đầy bất ngờ và thích thú.Bộ đồ người nhện phù hợp với các bé từ 3 dến 6 tuổi.Một món quà dễ thương dành cho các bé trong ngày này..tạo cho bé một phong cách mạnh mẽ và đây là một bồ đồ khá độc đáo đúng không nào…Hãy dành những món quà yêu thương này tới các bé ngay bạn nhé…', 250000, 0, '2016-02-05 23:02:55'),
	(13, 21, 'Bộ 6 quần len mông thú bé trai Rubistore', 'images/sanpham/betraiquan1', 16, '- Quần len 1 lớp\r\n- Chất dày dặn, thấm hút mồ hôi tốt\r\n- Thích hợp khi trẻ đóng bỉm\r\n- Size theo độ dài quần: 80cm, 90cm, 95cm\r\n- Có thể giặt với máy giặt\r\n- Không dùng chất tẩy rửa mạnh\r\n- Giao sản phẩm ngẫu nhiên', 350000, 0, '2016-02-05 23:02:59'),
	(14, 22, 'Bộ đồ nỉ liền hình thú ngộ nghĩnh Family Shop TED05', 'images/sanpham/betraidongu1', 14, 'ĐẶC ĐIỂM NỔI BẬT\r\nChất liệu: Cotton\r\nBảo hành: Sản phẩm không bảo hành\r\nSản xuất tại: Trung Quốc\r\nKiểu dáng thời trang, phù hợp nhiều lứa tuổi.\r\nChất liệu cotton thoáng mát, phù hợp với làn da trẻ', 415000, 0, '2016-02-05 23:03:03'),
	(15, 24, 'Bộ 6 quần len mông thú bé gái Rubistore', 'images/sanpham/begaiquan', 35, '- Quần len 1 lớp\r\n- Chất dày dặn, thấm hút mồ hôi tốt\r\n- Thích hợp khi trẻ đóng bỉm\r\n- Size theo độ dài quần: 80cm, 90cm, 95cm\r\n- Có thể giặt với máy giặt\r\n- Không dùng chất tẩy rửa mạnh\r\n- Giao sản phẩm ngẫu nhiên', 350000, 0, '2016-02-05 23:03:07'),
	(16, 25, 'Đầm mẹ và bé', 'images/sanpham/begaidam', 15, 'Tên sản phẩm : ĐẦM MẸ VÀ BÉ 3 MÀU\r\n\r\nMàu : Hồng, Xanh lá\r\n\r\nChất liệu : Thun cotton\r\n\r\nKích thước : \r\n\r\n+ Mẹ : Dài 80, vai 35, ngực 80-88, eo 66-72, mông 88-95\r\n\r\n+ Bé : Vai 28, dài 53. Phù hợp bé từ 12-18kg\r\n\r\nKiểu dáng : Cổ tròn, ngắn tay, form xoè', 329000, 0, '2016-02-05 23:03:11'),
	(17, 26, 'Áo len bé gái Gymboree Puppy Ruffle Sweater', 'images/sanpham/begaiaoam', 11, ' - Chất liệu: 100% acrylic knit\r\n - Áo len in hình kết hợp nơ đỏ rất yêu\r\n- Rất ấm áp và thoải mái khi mặc\r\n - Chất lượng đã được kiểm duyệt tại thị trường Mỹ\r\n - Có thể giặt máy\r\n - Nhập khẩu chính hãng từ Mỹ', 320000, 0, '2016-02-05 23:03:15');
/*!40000 ALTER TABLE `sanpham` ENABLE KEYS */;


-- Dumping structure for table shoponline.taikhoan
CREATE TABLE IF NOT EXISTS `taikhoan` (
  `id_taikhoan` int(11) NOT NULL AUTO_INCREMENT,
  `tentaikhoan` varchar(255) NOT NULL,
  `tendangnhap` varchar(255) NOT NULL,
  `matkhau` varchar(255) NOT NULL,
  `diachi` varchar(255) NOT NULL,
  `sodienthoai` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '1',
  `role` int(11) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_taikhoan`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Dumping data for table shoponline.taikhoan: ~9 rows (approximately)
DELETE FROM `taikhoan`;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` (`id_taikhoan`, `tentaikhoan`, `tendangnhap`, `matkhau`, `diachi`, `sodienthoai`, `email`, `status`, `role`, `created`) VALUES
	(2, 'nhanhnt1', '', 'wb/1JnRshCLfYbpGEpitiA==', '', '', 'honguyenthanhnhan2@gmail.com', 1, 0, '2016-02-15 00:17:13'),
	(3, '', '', 'axis2', '', '', 'admin@a.com', 1, 0, '2016-02-15 00:17:14'),
	(4, 'a', '', 'axis2', '', '', 'a@g.com', 1, 0, '2016-02-15 00:17:15'),
	(5, 'nhanhnt2', '', 'thanhnhan', '', '', 'nhanhnt2@gmail.com', 1, 0, '2016-02-15 00:17:16'),
	(6, 'nhanhnt3', '', 'thanhnhan', '', '', 'nhanhnt3@gmail.com', 1, 0, '2016-02-15 00:17:17'),
	(7, 'nhanhnt', '', '145d2281d4402cabdd25ec94972d3c81', '', '', 'nhanhnt@gmail.com', 1, 0, '2016-02-15 00:17:19'),
	(8, '111111', '', 'c9e89dfcf63cc3249c79527aa57c969c', '', '', 'admin@a1.com', 1, 0, '2016-02-15 00:17:19'),
	(9, 'aaaaaa', '', '69ff16a97ab333144d3570e76a07f385', '', '', 'adminaaaa@a.com', 1, 0, '2016-02-15 00:17:21'),
	(10, '1', '', '7725556fea625c3dce7f8715acac5ec9', '', '', 'admin@aaaaaaaa.com', 1, 0, '2016-02-16 14:53:32');
/*!40000 ALTER TABLE `taikhoan` ENABLE KEYS */;


-- Dumping structure for table shoponline.tbl_giaohang
CREATE TABLE IF NOT EXISTS `tbl_giaohang` (
  `id_giaohang` int(11) NOT NULL AUTO_INCREMENT,
  `id_hoadon` int(11) NOT NULL,
  `diachigiaohang` text NOT NULL,
  `phuongthucthanhtoan` varchar(50) NOT NULL,
  `ngaygiaohang` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ngaymuahang` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_giaohang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table shoponline.tbl_giaohang: ~0 rows (approximately)
DELETE FROM `tbl_giaohang`;
/*!40000 ALTER TABLE `tbl_giaohang` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_giaohang` ENABLE KEYS */;


-- Dumping structure for table shoponline.tbl_hoadon
CREATE TABLE IF NOT EXISTS `tbl_hoadon` (
  `id_hoadon` int(11) NOT NULL AUTO_INCREMENT,
  `id_muahang` int(11) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_hoadon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table shoponline.tbl_hoadon: ~0 rows (approximately)
DELETE FROM `tbl_hoadon`;
/*!40000 ALTER TABLE `tbl_hoadon` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_hoadon` ENABLE KEYS */;


-- Dumping structure for table shoponline.tbl_muahang
CREATE TABLE IF NOT EXISTS `tbl_muahang` (
  `id_muahang` int(11) NOT NULL AUTO_INCREMENT,
  `id_sanpham` int(11) NOT NULL,
  `dongia` double NOT NULL,
  `giamgia` int(11) NOT NULL,
  `thanhtien` double NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_muahang`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table shoponline.tbl_muahang: ~1 rows (approximately)
DELETE FROM `tbl_muahang`;
/*!40000 ALTER TABLE `tbl_muahang` DISABLE KEYS */;
INSERT INTO `tbl_muahang` (`id_muahang`, `id_sanpham`, `dongia`, `giamgia`, `thanhtien`, `created`) VALUES
	(1, 1, 319000, 41, 188210, '2016-02-16 15:32:49');
/*!40000 ALTER TABLE `tbl_muahang` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
