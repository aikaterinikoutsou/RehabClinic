package RehabClinicPOJOs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Clinician implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1730535744139817679L;

	private Integer id;
	private String name;
	private String surname;
	private String speciality;
	private String email;
	private Integer phone;
	private List<Patient> patients;
	private List<Therapy> therapies;
	
	
	public Clinician() {
		super();
		patients = new ArrayList<Patient>();
		therapies = new ArrayList<Therapy>();
	}


	public Clinician(Integer id, String name, String surname, String speciality, String email, Integer phone) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.speciality = speciality;
		this.email = email;
		this.phone = phone;
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


	public List<Patient> getPatients() {
		return patients;
	}


	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}


	public List<Therapy> getTherapies() {
		return therapies;
	}


	public void setTherapies(List<Therapy> therapies) {
		this.therapies = therapies;
	}


	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, patients, phone, speciality, surname, therapies);
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
				&& Objects.equals(patients, other.patients) && Objects.equals(phone, other.phone)
				&& Objects.equals(speciality, other.speciality) && Objects.equals(surname, other.surname)
				&& Objects.equals(therapies, other.therapies);
	}


	@Override
	public String toString() {
		return "Clinician [id=" + id + ", name=" + name + ", surname=" + surname + ", speciality=" + speciality
				+ ", email=" + email + ", phone=" + phone + ", patients=" + patients + "]";
	}
	
	
	
	
}
