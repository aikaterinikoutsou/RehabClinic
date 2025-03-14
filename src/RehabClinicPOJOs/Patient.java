package RehabClinicPOJOs;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Patient implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 152349264546461202L;
	
	private Integer id;
	private String DNI;
	private String name;
	private String surname;
	private Date dob;
	private Integer telephone;
	private String email;
	private Integer credit_card;
	private Therapists therapist;

	private String history;
	
	
	public Patient() {
		super();
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


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public Integer getTelephone() {
		return telephone;
	}


	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getCredit_card() {
		return credit_card;
	}


	public void setCredit_card(Integer credit_card) {
		this.credit_card = credit_card;
	}

	public Therapists getTherapist() {
		return therapist;
	}


	public void setTherapist(Therapists therapist) {
		this.therapist = therapist;
	}

	@Override
	public int hashCode() {
		return Objects.hash(DNI, credit_card, dob, email, id, name, surname, telephone, therapist);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(DNI, other.DNI) && Objects.equals(credit_card, other.credit_card)
				&& Objects.equals(dob, other.dob) && Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(surname, other.surname)
				&& Objects.equals(telephone, other.telephone) && Objects.equals(therapist, other.therapist);
	}


	@Override
	public String toString() {
		return "Patient [DNI=" + DNI + ", name=" + name + ", surname=" + surname + ", dob=" + dob + ", telephone="
				+ telephone + ", email=" + email + ", credit_card=" + credit_card + "]";
	}

	
}
