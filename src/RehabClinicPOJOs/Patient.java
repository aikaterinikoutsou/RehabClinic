package RehabClinicPOJOs;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import RehabClinicXmlUtils.SQLDateAdapter;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Patient")
@XmlType(propOrder = {"name", "surname", "dob","email", "credit_card", "therapist"})
public class Patient implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 152349264546461202L;
	
	@XmlTransient
	private Integer id;
	@XmlElement
	private String name;
	@XmlElement
	private String surname;	
	@XmlJavaTypeAdapter(SQLDateAdapter.class)
	private Date dob;
	@XmlAttribute
	private Integer telephone;
	@XmlElement
	private String email;
	@XmlElement
	private Integer credit_card;
	//@XmlTransient
	@XmlElement(name= "clinician")
	private Clinician therapist;
	//@XmlElement(name= "therapy")
	//@XmlElementWrapper(name = "therapies")
	@XmlTransient
	private List<Patient_Therapy> pt;
	
	public Patient() {
		super();
		
		pt= new ArrayList<Patient_Therapy>();
	}

	

	public Patient(String name, String surname, Date dob, Integer telephone, String email, Integer credit_card) {
		super();
		this.name = name;
		this.surname = surname;
		this.dob = dob;
		this.telephone = telephone;
		this.email = email;
		this.credit_card = credit_card;
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

	public Clinician getTherapist() {
		return therapist;
	}


	public void setTherapist(Clinician therapist) {
		this.therapist = therapist;
	}

	public List<Patient_Therapy> getPt() {
		return pt;
	}


	public void setPt(List<Patient_Therapy> pt) {
		this.pt = pt;
	}


	@Override
	public int hashCode() {
		return Objects.hash(credit_card, dob, email, id, name, pt, surname, telephone, therapist);
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
		return  Objects.equals(credit_card, other.credit_card)
				&& Objects.equals(dob, other.dob) && Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(pt, other.pt)
				&& Objects.equals(surname, other.surname) && Objects.equals(telephone, other.telephone)
				&& Objects.equals(therapist, other.therapist);
	}


	@Override
	public String toString() {
		return "Patient [name=" + name + ", surname=" + surname + ", dob=" + dob + ", telephone="
				+ telephone + ", email=" + email + ", credit_card=" + credit_card + ", therapist=" + therapist + "]";
	}

	
}
