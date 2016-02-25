/**
 */
package education;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see education.EducationFactory
 * @model kind="package"
 * @generated
 */
public interface EducationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "education";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/education";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "education";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EducationPackage eINSTANCE = education.impl.EducationPackageImpl.init();

	/**
	 * The meta object id for the '{@link education.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see education.impl.PersonImpl
	 * @see education.impl.EducationPackageImpl#getPerson()
	 * @generated
	 */
	int PERSON = 0;

	/**
	 * The feature id for the '<em><b>Firstname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__FIRSTNAME = 0;

	/**
	 * The feature id for the '<em><b>Lastname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__LASTNAME = 1;

	/**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link education.impl.StudentImpl <em>Student</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see education.impl.StudentImpl
	 * @see education.impl.EducationPackageImpl#getStudent()
	 * @generated
	 */
	int STUDENT = 1;

	/**
	 * The feature id for the '<em><b>Firstname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUDENT__FIRSTNAME = PERSON__FIRSTNAME;

	/**
	 * The feature id for the '<em><b>Lastname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUDENT__LASTNAME = PERSON__LASTNAME;

	/**
	 * The number of structural features of the '<em>Student</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUDENT_FEATURE_COUNT = PERSON_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Student</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUDENT_OPERATION_COUNT = PERSON_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link education.impl.TeacherImpl <em>Teacher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see education.impl.TeacherImpl
	 * @see education.impl.EducationPackageImpl#getTeacher()
	 * @generated
	 */
	int TEACHER = 2;

	/**
	 * The feature id for the '<em><b>Firstname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEACHER__FIRSTNAME = PERSON__FIRSTNAME;

	/**
	 * The feature id for the '<em><b>Lastname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEACHER__LASTNAME = PERSON__LASTNAME;

	/**
	 * The number of structural features of the '<em>Teacher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEACHER_FEATURE_COUNT = PERSON_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Teacher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEACHER_OPERATION_COUNT = PERSON_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link education.impl.CourseImpl <em>Course</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see education.impl.CourseImpl
	 * @see education.impl.EducationPackageImpl#getCourse()
	 * @generated
	 */
	int COURSE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COURSE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Student</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COURSE__STUDENT = 1;

	/**
	 * The feature id for the '<em><b>Teacher</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COURSE__TEACHER = 2;

	/**
	 * The number of structural features of the '<em>Course</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COURSE_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>Start</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COURSE___START__DATE = 0;

	/**
	 * The operation id for the '<em>Finish</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COURSE___FINISH__DATE = 1;

	/**
	 * The number of operations of the '<em>Course</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COURSE_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '<em>date</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Date
	 * @see education.impl.EducationPackageImpl#getdate()
	 * @generated
	 */
	int DATE = 4;


	/**
	 * Returns the meta object for class '{@link education.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see education.Person
	 * @generated
	 */
	EClass getPerson();

	/**
	 * Returns the meta object for the attribute '{@link education.Person#getFirstname <em>Firstname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Firstname</em>'.
	 * @see education.Person#getFirstname()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Firstname();

	/**
	 * Returns the meta object for the attribute '{@link education.Person#getLastname <em>Lastname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lastname</em>'.
	 * @see education.Person#getLastname()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Lastname();

	/**
	 * Returns the meta object for class '{@link education.Student <em>Student</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Student</em>'.
	 * @see education.Student
	 * @generated
	 */
	EClass getStudent();

	/**
	 * Returns the meta object for class '{@link education.Teacher <em>Teacher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Teacher</em>'.
	 * @see education.Teacher
	 * @generated
	 */
	EClass getTeacher();

	/**
	 * Returns the meta object for class '{@link education.Course <em>Course</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Course</em>'.
	 * @see education.Course
	 * @generated
	 */
	EClass getCourse();

	/**
	 * Returns the meta object for the attribute '{@link education.Course#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see education.Course#getName()
	 * @see #getCourse()
	 * @generated
	 */
	EAttribute getCourse_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link education.Course#getStudent <em>Student</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Student</em>'.
	 * @see education.Course#getStudent()
	 * @see #getCourse()
	 * @generated
	 */
	EReference getCourse_Student();

	/**
	 * Returns the meta object for the containment reference '{@link education.Course#getTeacher <em>Teacher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Teacher</em>'.
	 * @see education.Course#getTeacher()
	 * @see #getCourse()
	 * @generated
	 */
	EReference getCourse_Teacher();

	/**
	 * Returns the meta object for the '{@link education.Course#start(java.util.Date) <em>Start</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Start</em>' operation.
	 * @see education.Course#start(java.util.Date)
	 * @generated
	 */
	EOperation getCourse__Start__Date();

	/**
	 * Returns the meta object for the '{@link education.Course#finish(java.util.Date) <em>Finish</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Finish</em>' operation.
	 * @see education.Course#finish(java.util.Date)
	 * @generated
	 */
	EOperation getCourse__Finish__Date();

	/**
	 * Returns the meta object for data type '{@link java.util.Date <em>date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>date</em>'.
	 * @see java.util.Date
	 * @model instanceClass="java.util.Date"
	 * @generated
	 */
	EDataType getdate();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EducationFactory getEducationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link education.impl.PersonImpl <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see education.impl.PersonImpl
		 * @see education.impl.EducationPackageImpl#getPerson()
		 * @generated
		 */
		EClass PERSON = eINSTANCE.getPerson();

		/**
		 * The meta object literal for the '<em><b>Firstname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__FIRSTNAME = eINSTANCE.getPerson_Firstname();

		/**
		 * The meta object literal for the '<em><b>Lastname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__LASTNAME = eINSTANCE.getPerson_Lastname();

		/**
		 * The meta object literal for the '{@link education.impl.StudentImpl <em>Student</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see education.impl.StudentImpl
		 * @see education.impl.EducationPackageImpl#getStudent()
		 * @generated
		 */
		EClass STUDENT = eINSTANCE.getStudent();

		/**
		 * The meta object literal for the '{@link education.impl.TeacherImpl <em>Teacher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see education.impl.TeacherImpl
		 * @see education.impl.EducationPackageImpl#getTeacher()
		 * @generated
		 */
		EClass TEACHER = eINSTANCE.getTeacher();

		/**
		 * The meta object literal for the '{@link education.impl.CourseImpl <em>Course</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see education.impl.CourseImpl
		 * @see education.impl.EducationPackageImpl#getCourse()
		 * @generated
		 */
		EClass COURSE = eINSTANCE.getCourse();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COURSE__NAME = eINSTANCE.getCourse_Name();

		/**
		 * The meta object literal for the '<em><b>Student</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COURSE__STUDENT = eINSTANCE.getCourse_Student();

		/**
		 * The meta object literal for the '<em><b>Teacher</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COURSE__TEACHER = eINSTANCE.getCourse_Teacher();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COURSE___START__DATE = eINSTANCE.getCourse__Start__Date();

		/**
		 * The meta object literal for the '<em><b>Finish</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COURSE___FINISH__DATE = eINSTANCE.getCourse__Finish__Date();

		/**
		 * The meta object literal for the '<em>date</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Date
		 * @see education.impl.EducationPackageImpl#getdate()
		 * @generated
		 */
		EDataType DATE = eINSTANCE.getdate();

	}

} //EducationPackage
