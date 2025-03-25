package RehabClinicPOJOs;

import java.io.Serializable;
import java.util.Objects;

public class Clinician implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1730535744139817679L;

	Integer id;
	String name;
	String surname;
	String speciality;
	String email;
	Integer phone;
	
	
	public Clinician() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getSpeciality() {
		return speciality;
	}


	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getPhone() {
		return phone;
	}


	public void setPhone(Integer phone) {
		this.phone = phone;
	}


	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, phone, speciality, surname);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clinician other = (Clinician) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(phone, other.phone) && Objects.equals(speciality, other.speciality)
				&& Objects.equals(surname, other.surname);
	}


	@Override
	public String toString() {
		return "Clinician [name=" + name + ", surname=" + surname + ", speciality=" + speciality + ", email=" + email
				+ ", phone=" + phone + "]";
	}
	
	
	
	
}
