-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               5.6.21 - MySQL Community Server (GPL)
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
  `soluong` int(11) NOT NULL,
  `dongia` double NOT NULL,
  `giamgia` int(11) NOT NULL,
  `phiship` int(11) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_chitiethoadon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table shoponline.chitiethoadon: ~0 rows (approximately)
DELETE FROM `chitiethoadon`;
/*!40000 ALTER TABLE `chitiethoadon` DISABLE KEYS */;
/*!40000 ALTER TABLE `chitiethoadon` ENABLE KEYS */;


-- Dumping structure for table shoponline.danhmuc
CREATE TABLE IF NOT EXISTS `danhmuc` (
  `id_danhmuc` int(11) NOT NULL AUTO_INCREMENT,
  `tendanhmuc` varchar(255) NOT NULL DEFAULT '',
  `danhmuccha` varchar(50) NOT NULL DEFAULT '0',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_danhmuc`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- Dumping data for table shoponline.danhmuc: ~11 rows (approximately)
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


-- Dumping structure for table shoponline.hoadon
CREATE TABLE IF NOT EXISTS `hoadon` (
  `id_hoadon` int(11) NOT NULL AUTO_INCREMENT,
  `id_taikhoan` int(11) NOT NULL,
  `diachigiaohang` varchar(50) NOT NULL,
  `phuongthucthanhtoan` varchar(50) NOT NULL,
  `ngaygiaohang` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ngaymuahang` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_hoadon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table shoponline.hoadon: ~0 rows (approximately)
DELETE FROM `hoadon`;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;


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
  PRIMARY KEY (`id_sanpham`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- Dumping data for table shoponline.sanpham: ~0 rows (approximately)
DELETE FROM `sanpham`;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` (`id_sanpham`, `id_danhmuc`, `tensanpham`, `hinhanh`, `soluong`, `mota`, `dongia`, `giamgia`, `created`) VALUES
	(1, 12, 'Áo vét Nam 2 lớp', 'images/dovet1', 18, 'ĐIỂM NỔI BẬT\r\n- Thiết kế vừa sang trọng, lịch lãm vừa trẻ trung, năng động.\r\n- Mang đến cho phái mạnh vẻ sang trọng, lịch lãm và vô cùng cá tính. \r\n- Phù hợp cho những sự kiện, cuộc hẹn hò lãng mạn, hay những buổi hẹn, party...\r\n- Chất liệu: Kaki Hàn Quốc thoáng mát.\r\n- Phù hợp với bạn dưới 70kg (tùy chiều cao)', 319000, 41, '2016-01-27 20:16:33'),
	(2, 12, 'Áo vét viền màu', 'images/dovet2', 15, 'Một chiếc áo vest thời trang và đẹp không chỉ thể hiện phong cách nam tính mà còn làm bật lên vẻ đẹp sang trọng và lịch lãm của phái mạnh. Chiếc áo vest thời trang nam chắc chắn sẽ làm bạn được chú ý bởi chất liệu cao cấp và thiết kế độc đáo của nó. Chiếc áo vest thời trang nam với thiết kế trẻ trung năng động kết hợp kiểu dáng đơn giản làm cho chiếc áo trở lên sang trọng và mạnh mẽ hơn bao giờ hết. Đặc biêt, chiếc áo vest thời trang nam được làm từ chất liệu kaki Hàn Quốc cao cấp đi kèm với lớp dù mềm mịn thoáng mát, mang tới cho bạn cảm giác dễ chịu và thoải mãn mỗi khi mặc nó và góp phần làm tôn lên vẻ điển trai của bạn ở mọi lúc, mọi nơi.', 299000, 0, '2016-01-27 20:19:18'),
	(3, 12, 'Áo vest FAL AKV01', 'images/dovet3', 6, 'ÁO VEST, màu: XANH, chất liệu: COTTON, xuất xứ Việt Nam, trẻ trung, thời trang, không bảo hành, M: Dài áo 70, rộng vai 41, vòng ngực 51*2. ,L: Dài áo 71, rộng vai 42, vòng ngực 52*2., XL: Dài áo 73, rộng vai 44, vòng ngực 53*2.,', 319000, 0, '2016-01-27 20:19:13'),
	(4, 12, 'Áo Blazer Name New Look', 'images/dovet4', 7, 'New Look là thương hiệu thời trang trẻ trung, cá tính đến từ nước Anh. Sản phẩm luôn được cập nhật theo những xu hướng mới nhất, được ưa chuộng nhất để bạn có thể bổ sung vào tủ quần áo của mình. Quan tâm đến ngoại hình và xu hướng thời trang phù hợp, New Look cho bạn rất nhiều sự lựa chọn với mức giá vô cùng hợp lý. Các cô nàng có thể tìm thấy tất cả những gì mình mong muốn cho bất kỳ dịp đặc biệt nào với New Look.\r\n\r\nThông tin sản phẩm\r\n- Giặt máy \r\n- Chất liệu: 98% Polyester, 2% Elastane', 1600000, 8, '2015-01-27 20:20:27'),
	(5, 12, 'Áo vest nam SAIGONBOY V03', 'images/dovet5', 19, 'THÔNG TIN SẢN PHẨM\r\n- Chất liệu kaki cao cấp\r\n- Thiết kế thời trang; nam tính\r\n- Dễ dàng kết hợp trang phục', 279000, 0, '2016-01-27 20:21:24'),
	(6, 12, 'Áo vest nam TUTTAT 8042-19', 'images/dovet6', 7, 'TUTTAT sẽ mang lại cho khách hàng những trải nghiệm mua sắm thời trang trực tuyến thú vị từ các mẫu mã kiểu dáng thời trang nam mới nhất. Thời trang TUTTAT luôn đổi mới từng ngày với những bộ sưu tập thời trang nam từ giày dép, trang phục, phụ kiện theo trào lưu mới nhất. TUTTAT cam kết chất lượng phục vụ hàng đầu cùng với những với những xu hướng thời trang mới nhất. Bạn có thể tìm thấy những bộ trang phục mình yêu thích, từ những bộ đồ mặc nhà thật thoải mái hay tự tin trong những trang phục công sở thanh lịch. Đừng bỏ lỡ những trải nghiệm mua sắm thú vị tạiTUTTAT – THỜI TRANG NAM PHONG CÁCH\r\n\r\nĐẶC ĐIỂM NỔI BẬT\r\n Loại sản phẩm:\r\n Áo vest với đa dạng mẫu mã sở hữu phong cách từ công sở lịch thiệp đến thời trang dạo phố sành điệu, năng động.\r\nThiết kế đơn giản mà sành điệu \r\nVới phom áo cực chuẩn, kiểu dáng đơn giản, áo vest TUTTAT giúp giúp bạn khéo léo khoe những đường nét mạnh mẽ của cơ thể cũng như nét năng động và quyến rũ rất riêng của mình.\r\nMàu sắc: Thanh lịch, trẻ trung \r\nChất liệu: Cao cấp\r\nXuất xứ: Việt Nam\r\nBảo hành: Không bảo hành', 659000, 0, '2016-01-27 20:22:30'),
	(7, 13, 'Quần tây nam công sở QT106 ', 'images/quannam1', 27, 'Bạn thường quan tâm những điều gì về thời trang công sở nam? Có thể quan tâm đến giày nam công sở, vest nam công sở, áo sơ mi công sở… Nhưng bạn đã quan tâm đủ đến quần tây nam chưa? Một bộ đồ công sở có thể nói nên rất nhiều điều về bạn.\r\n\r\nThời trang công sở là sự kết hợp tinh tế của các thành phần quấn, áo và phụ kiện. Quần tây nam là thành phần rất quan trọng tạo nên dáng vẻ và đẳng cấp cho một nam công sở thành đạt.', 364000, 0, '2016-01-27 20:24:02'),
	(8, 14, 'Áo sơ mi nam Prazenta O-ASN261', 'images/aosomi1', 15, 'Áo sơ mi nam Prazenta O-ASN261 thiết kế trẻ trung, hợp thời trang\r\nChất liệu: COTTON đem lại sự thoải mái cho người mặc.\r\nSản xuất tại Việt Nam.', 239000, 0, '2016-01-27 20:25:30'),
	(9, 16, 'Áo dáng rộng xòe đuôi cá Nhanh Mua 5697', 'images/aothunnu1', 17, 'Điểm nổi bật:\r\n- Áo form rộng xòe đuôi cá thời trang với thiết kế đơn giản, form xòe trẻ trung mang lại nét thanh lịch, dịu dàng.\r\n- Chất liệu cát len mềm mại, thấm hút mồ hôi mang lại cảm giác thông thoáng cho người mặc.\r\n- Thiết kế form suông rộng, xòe nhẹ nhàng, giúp che khuyết điểm hiệu quả.\r\n- Thích hợp diện đi làm, dạo phố, coffee cùng bạn bè…\r\nKÍCH THƯỚC:\r\n- Chất liệu: cát len\r\n- Vòng ngực: 84 - 92 cm\r\n- Vòng eo: 78 - 86 cm\r\n- Chiều dài: 56 cm\r\n- Cân nặng: < 55 kg tùy theo chiều cao', 309000, 0, '2016-01-27 20:27:11'),
	(10, 17, 'Chân váy bút chì Zahra', 'images/chanvay1', 27, 'Chân váy dáng dài qua gối- Dáng bút chì sang trọng- Chất liệu co giãn thoải mái', 215000, 0, '2016-01-27 20:28:23'),
	(11, 18, 'Quần legging da bóng', 'images/quannu1', 7, 'Điểm nổi bật\r\n\r\n- Quần legging mới cực thời trang, giả da sành điệu, dễ dàng phối với các loại trang phục - phụ kiện khác.\r\n\r\n- Form quần ôm gọn đôi chân, tạo cảm giác thon gọn và hiệu ứng làm dài chân.\r\n\r\n- Thiết kế quần lưng cao, không làm lộ vùng bụng, tôn vòng eo - mông và đùi tuyệt đối, bó sát nhưng quần không gây phô hay phản cảm.\r\n\r\n- Chất thun PU giả da cao cấp, sờ mát và rất giống da nhưng có độ co giãn tốt và không gây bức bí, khó chịu cho người mặc.\r\n\r\n- Quần legging da bóng tạo nên sự quyến rũ mà mạnh mẽ, thích hợp mặc đi chơi, đi dạo phố, tiệc ..v..v..\r\n\r\n- Màu sắc: Đen.', 259000, 0, '2016-01-27 20:29:41'),
	(12, 20, 'Quần áo người nhện Spider Man 110cm', 'images/betraiao1', 2, 'Quần Áo Người Nhện Loại Tốt (Tay Dài) là trang phục dành cho các bé trong ngày hallowen đầy bất ngờ và thích thú.Bộ đồ người nhện phù hợp với các bé từ 3 dến 6 tuổi.Một món quà dễ thương dành cho các bé trong ngày này..tạo cho bé một phong cách mạnh mẽ và đây là một bồ đồ khá độc đáo đúng không nào…Hãy dành những món quà yêu thương này tới các bé ngay bạn nhé…', 250000, 0, '2016-01-27 20:31:28'),
	(13, 21, 'Bộ 6 quần len mông thú bé trai Rubistore', 'images/betraiquan1', 16, '- Quần len 1 lớp\r\n- Chất dày dặn, thấm hút mồ hôi tốt\r\n- Thích hợp khi trẻ đóng bỉm\r\n- Size theo độ dài quần: 80cm, 90cm, 95cm\r\n- Có thể giặt với máy giặt\r\n- Không dùng chất tẩy rửa mạnh\r\n- Giao sản phẩm ngẫu nhiên', 350000, 0, '2016-01-27 20:32:32'),
	(14, 22, 'Bộ đồ nỉ liền hình thú ngộ nghĩnh Family Shop TED05', 'images/betraidongu1', 14, 'ĐẶC ĐIỂM NỔI BẬT\r\nChất liệu: Cotton\r\nBảo hành: Sản phẩm không bảo hành\r\nSản xuất tại: Trung Quốc\r\nKiểu dáng thời trang, phù hợp nhiều lứa tuổi.\r\nChất liệu cotton thoáng mát, phù hợp với làn da trẻ', 415000, 0, '2016-01-27 20:33:48'),
	(15, 24, 'Bộ 6 quần len mông thú bé gái Rubistore', 'images/begaiquan', 35, '- Quần len 1 lớp\r\n- Chất dày dặn, thấm hút mồ hôi tốt\r\n- Thích hợp khi trẻ đóng bỉm\r\n- Size theo độ dài quần: 80cm, 90cm, 95cm\r\n- Có thể giặt với máy giặt\r\n- Không dùng chất tẩy rửa mạnh\r\n- Giao sản phẩm ngẫu nhiên', 350000, 0, '2016-01-27 20:35:07'),
	(16, 25, 'Đầm mẹ và bé', 'images/begaidam', 15, 'Tên sản phẩm : ĐẦM MẸ VÀ BÉ 3 MÀU\r\n\r\nMàu : Hồng, Xanh lá\r\n\r\nChất liệu : Thun cotton\r\n\r\nKích thước : \r\n\r\n+ Mẹ : Dài 80, vai 35, ngực 80-88, eo 66-72, mông 88-95\r\n\r\n+ Bé : Vai 28, dài 53. Phù hợp bé từ 12-18kg\r\n\r\nKiểu dáng : Cổ tròn, ngắn tay, form xoè', 329000, 0, '2016-01-27 20:36:07'),
	(17, 26, 'Áo len bé gái Gymboree Puppy Ruffle Sweater', 'images/begaiaoam', 11, ' - Chất liệu: 100% acrylic knit\r\n - Áo len in hình kết hợp nơ đỏ rất yêu\r\n- Rất ấm áp và thoải mái khi mặc\r\n - Chất lượng đã được kiểm duyệt tại thị trường Mỹ\r\n - Có thể giặt máy\r\n - Nhập khẩu chính hãng từ Mỹ', 320000, 0, '2016-01-27 20:37:14');
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
  `status` varchar(255) NOT NULL,
  `role` int(11) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_taikhoan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table shoponline.taikhoan: ~0 rows (approximately)
DELETE FROM `taikhoan`;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
/*!40000 ALTER TABLE `taikhoan` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
