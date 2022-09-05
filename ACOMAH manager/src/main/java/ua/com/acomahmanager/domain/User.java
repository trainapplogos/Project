package ua.com.acomahmanager.domain;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String email;
	private String firstName;
	private String lastName;
	private String patronymic;

	private String street;
	private String building;
	private String apartment;
	private String phoneNumber;
	private String zipCode;

	@Enumerated(EnumType.STRING)
	private UserRole role;

	private String password;
	private String passwordConfirm;

	@Column(name = "is_deleted")
	private Boolean isDeleted;

	@Column(name = "is_active", nullable = false)
	private Boolean isActive = false;

	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	private Set<Bill> bills;

	public User() {}

	public User(User user) {
		this.id = user.id;
		this.email = user.email;
		this.firstName = user.firstName;
		this.lastName = user.lastName;
		this.patronymic = user.patronymic;
		this.role = user.role;
		this.password = user.password;
		this.isDeleted = user.isDeleted;
		this.isActive = user.isActive;
		this.street = user.street;
		this.building = user.building;
		this.apartment = user.apartment;
		this.phoneNumber = user.phoneNumber;
		this.zipCode = user.zipCode;
	}

	public User(String email, String firstName, String lastName, String patronymic, String street, String building,
			String apartment, String phoneNumber, String zipCode, UserRole role, String password,
			String passwordConfirm, Boolean isDeleted, Boolean isActive) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.patronymic = patronymic;
		this.street = street;
		this.building = building;
		this.apartment = apartment;
		this.phoneNumber = phoneNumber;
		this.zipCode = zipCode;
		this.role = role;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.isDeleted = isDeleted;
		this.isActive = isActive;
	}

	public User(Long id, String email, String firstName, String lastName, String patronymic, String street,
			String building, String apartment, String phoneNumber, String zipCode, UserRole role, String password,
			String passwordConfirm, Boolean isDeleted, Boolean isActive) {
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.patronymic = patronymic;
		this.street = street;
		this.building = building;
		this.apartment = apartment;
		this.phoneNumber = phoneNumber;
		this.zipCode = zipCode;
		this.role = role;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.isDeleted = isDeleted;
		this.isActive = isActive;
	}

	// [Custom getter: DO NOT DELETE]
	public String getUserName() {
		return email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apartment, building, email, firstName, id, isActive, isDeleted, lastName, password,
				passwordConfirm, patronymic, phoneNumber, role, street, zipCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(apartment, other.apartment) && Objects.equals(building, other.building)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(isActive, other.isActive)
				&& Objects.equals(isDeleted, other.isDeleted) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password) && Objects.equals(passwordConfirm, other.passwordConfirm)
				&& Objects.equals(patronymic, other.patronymic) && Objects.equals(phoneNumber, other.phoneNumber)
				&& role == other.role && Objects.equals(street, other.street) && Objects.equals(zipCode, other.zipCode);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", patronymic=" + patronymic + ", street=" + street + ", building=" + building + ", apartment="
				+ apartment + ", phoneNumber=" + phoneNumber + ", zipCode=" + zipCode + ", role=" + role + ", password="
				+ password + ", passwordConfirm=" + passwordConfirm + ", isDeleted=" + isDeleted + ", isActive="
				+ isActive + "]";
	}

}
