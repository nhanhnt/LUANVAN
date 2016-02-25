/**
 */
package education.impl;

import education.Course;
import education.EducationPackage;
import education.Student;
import education.Teacher;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Course</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link education.impl.CourseImpl#getName <em>Name</em>}</li>
 *   <li>{@link education.impl.CourseImpl#getStudent <em>Student</em>}</li>
 *   <li>{@link education.impl.CourseImpl#getTeacher <em>Teacher</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CourseImpl extends MinimalEObjectImpl.Container implements Course {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStudent() <em>Student</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStudent()
	 * @generated
	 * @ordered
	 */
	protected EList<Student> student;

	/**
	 * The cached value of the '{@link #getTeacher() <em>Teacher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTeacher()
	 * @generated
	 * @ordered
	 */
	protected Teacher teacher;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CourseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EducationPackage.Literals.COURSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EducationPackage.COURSE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Student> getStudent() {
		if (student == null) {
			student = new EObjectContainmentEList<Student>(Student.class, this, EducationPackage.COURSE__STUDENT);
		}
		return student;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Teacher getTeacher() {
		return teacher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTeacher(Teacher newTeacher, NotificationChain msgs) {
		Teacher oldTeacher = teacher;
		teacher = newTeacher;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EducationPackage.COURSE__TEACHER, oldTeacher, newTeacher);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTeacher(Teacher newTeacher) {
		if (newTeacher != teacher) {
			NotificationChain msgs = null;
			if (teacher != null)
				msgs = ((InternalEObject)teacher).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EducationPackage.COURSE__TEACHER, null, msgs);
			if (newTeacher != null)
				msgs = ((InternalEObject)newTeacher).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EducationPackage.COURSE__TEACHER, null, msgs);
			msgs = basicSetTeacher(newTeacher, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EducationPackage.COURSE__TEACHER, newTeacher, newTeacher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void start(Date startdate) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void finish(Date finishdate) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EducationPackage.COURSE__STUDENT:
				return ((InternalEList<?>)getStudent()).basicRemove(otherEnd, msgs);
			case EducationPackage.COURSE__TEACHER:
				return basicSetTeacher(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EducationPackage.COURSE__NAME:
				return getName();
			case EducationPackage.COURSE__STUDENT:
				return getStudent();
			case EducationPackage.COURSE__TEACHER:
				return getTeacher();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EducationPackage.COURSE__NAME:
				setName((String)newValue);
				return;
			case EducationPackage.COURSE__STUDENT:
				getStudent().clear();
				getStudent().addAll((Collection<? extends Student>)newValue);
				return;
			case EducationPackage.COURSE__TEACHER:
				setTeacher((Teacher)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EducationPackage.COURSE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EducationPackage.COURSE__STUDENT:
				getStudent().clear();
				return;
			case EducationPackage.COURSE__TEACHER:
				setTeacher((Teacher)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EducationPackage.COURSE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EducationPackage.COURSE__STUDENT:
				return student != null && !student.isEmpty();
			case EducationPackage.COURSE__TEACHER:
				return teacher != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case EducationPackage.COURSE___START__DATE:
				start((Date)arguments.get(0));
				return null;
			case EducationPackage.COURSE___FINISH__DATE:
				finish((Date)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //CourseImpl
