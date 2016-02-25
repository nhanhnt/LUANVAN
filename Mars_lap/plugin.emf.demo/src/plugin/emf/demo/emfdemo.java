package plugin.emf.demo;

import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;

import education.Course;
import education.EducationFactory;
import education.Student;
import education.Teacher;
import education.impl.EducationFactoryImpl;

public class emfdemo {

	public static void main(String[] args) {
		EducationFactoryImpl.init();
		EducationFactory fatory= EducationFactoryImpl.eINSTANCE;
		
		Student s1=fatory.createStudent();
		s1.setFirstname("Lê");
		s1.setLastname("Oanh");
		
		Student s2=fatory.createStudent();
		s2.setFirstname("Hồ");
		s2.setLastname("Nhân");
		
		Teacher t=fatory.createTeacher();
		t.setFirstname("Hoàng");
		t.setLastname("Hạnh");
		
		Course c=fatory.createCourse();
		c.setName("Web Ngữ Nghĩa");
		c.setTeacher(t);
		c.getStudent().add(s1);
		c.getStudent().add(s2);
		
		System.out.println("Khóa học: "+c.getName());
		System.out.println("Giáo viên: "+c.getTeacher().getFirstname()+" "+c.getTeacher().getLastname());
		System.out.println("Số lượng học sinh: "+ c.getStudent().size());
		
		List<Student> list_student=c.getStudent();
		for (int i = 0; i < list_student.size(); i++) {
			Student student=list_student.get(i);
			System.out.println("Học sinh "+i+ " : "+student.getFirstname()+" "+student.getLastname());
		}
		
		

	}

}
