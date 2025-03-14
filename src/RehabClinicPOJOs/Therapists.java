package RehabClinicPOJOs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Therapists implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6592785222742033062L;
	
	private Integer id;
	private String DNI;
	private String name;
	private String email;
	private Integer telephone;
	private String speciality;
	private List<Patient> patients;
	
	private Integer vacations;
	
	public Therapists() {
		super();
		patients = new ArrayList<Patient>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTelephone() {
		return telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	@Override
	public int hashCode() {
		return Objects.hash(DNI, email, id, name, patients, speciality, telephone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Therapists other = (Therapists) obj;
		return Objects.equals(DNI, other.DNI) && Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(patients, other.patients)
				&& Objects.equals(speciality, other.speciality) && Objects.equals(telephone, other.telephone);
	}

	@Override
	public String toString() {
		return "Therapists [DNI=" + DNI + ", name=" + name + ", email=" + email + ", telephone=" + telephone
				+ ", speciality=" + speciality + ", patients=" + patients + "]";
	}
	
	
	
}
