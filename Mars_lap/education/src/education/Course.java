/**
 */
package education;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Course</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link education.Course#getName <em>Name</em>}</li>
 *   <li>{@link education.Course#getStudent <em>Student</em>}</li>
 *   <li>{@link education.Course#getTeacher <em>Teacher</em>}</li>
 * </ul>
 *
 * @see education.EducationPackage#getCourse()
 * @model
 * @generated
 */
public interface Course extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see education.EducationPackage#getCourse_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link education.Course#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Student</b></em>' containment reference list.
	 * The list contents are of type {@link education.Student}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Student</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Student</em>' containment reference list.
	 * @see education.EducationPackage#getCourse_Student()
	 * @model containment="true"
	 * @generated
	 */
	EList<Student> getStudent();

	/**
	 * Returns the value of the '<em><b>Teacher</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Teacher</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Teacher</em>' containment reference.
	 * @see #setTeacher(Teacher)
	 * @see education.EducationPackage#getCourse_Teacher()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Teacher getTeacher();

	/**
	 * Sets the value of the '{@link education.Course#getTeacher <em>Teacher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Teacher</em>' containment reference.
	 * @see #getTeacher()
	 * @generated
	 */
	void setTeacher(Teacher value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model startdateDataType="education.date"
	 * @generated
	 */
	void start(Date startdate);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model finishdateDataType="education.date"
	 * @generated
	 */
	void finish(Date finishdate);

} // Course
