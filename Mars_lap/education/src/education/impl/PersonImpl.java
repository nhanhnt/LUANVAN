/**
 */
package education.impl;

import education.EducationPackage;
import education.Person;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link education.impl.PersonImpl#getFirstname <em>Firstname</em>}</li>
 *   <li>{@link education.impl.PersonImpl#getLastname <em>Lastname</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PersonImpl extends MinimalEObjectImpl.Container implements Person {
	/**
	 * The default value of the '{@link #getFirstname() <em>Firstname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstname()
	 * @generated
	 * @ordered
	 */
	protected static final String FIRSTNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFirstname() <em>Firstname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstname()
	 * @generated
	 * @ordered
	 */
	protected String firstname = FIRSTNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastname() <em>Lastname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastname()
	 * @generated
	 * @ordered
	 */
	protected static final String LASTNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastname() <em>Lastname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastname()
	 * @generated
	 * @ordered
	 */
	protected String lastname = LASTNAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PersonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EducationPackage.Literals.PERSON;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstname(String newFirstname) {
		String oldFirstname = firstname;
		firstname = newFirstname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EducationPackage.PERSON__FIRSTNAME, oldFirstname, firstname));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastname(String newLastname) {
		String oldLastname = lastname;
		lastname = newLastname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EducationPackage.PERSON__LASTNAME, oldLastname, lastname));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EducationPackage.PERSON__FIRSTNAME:
				return getFirstname();
			case EducationPackage.PERSON__LASTNAME:
				return getLastname();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EducationPackage.PERSON__FIRSTNAME:
				setFirstname((String)newValue);
				return;
			case EducationPackage.PERSON__LASTNAME:
				setLastname((String)newValue);
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
			case EducationPackage.PERSON__FIRSTNAME:
				setFirstname(FIRSTNAME_EDEFAULT);
				return;
			case EducationPackage.PERSON__LASTNAME:
				setLastname(LASTNAME_EDEFAULT);
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
			case EducationPackage.PERSON__FIRSTNAME:
				return FIRSTNAME_EDEFAULT == null ? firstname != null : !FIRSTNAME_EDEFAULT.equals(firstname);
			case EducationPackage.PERSON__LASTNAME:
				return LASTNAME_EDEFAULT == null ? lastname != null : !LASTNAME_EDEFAULT.equals(lastname);
		}
		return super.eIsSet(featureID);
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
		result.append(" (firstname: ");
		result.append(firstname);
		result.append(", lastname: ");
		result.append(lastname);
		result.append(')');
		return result.toString();
	}

} //PersonImpl
