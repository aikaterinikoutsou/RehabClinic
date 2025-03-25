package RehabClinicPOJOs;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Patient_Therapy implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1994317123464697523L;

	
	private Integer id;
	private String Comments;
	private Date therapy_date;
	private Therapy therapy;
	private Patient patient;
	public Patient_Therapy(Integer id, String comments, Date therapy_date, Therapy therapy, Patient patient) {
		super();
		this.id = id;
		Comments = comments;
		this.therapy_date = therapy_date;
		this.therapy = therapy;
		this.patient = patient;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	public Date getTherapy_date() {
		return therapy_date;
	}
	public void setTherapy_date(Date therapy_date) {
		this.therapy_date = therapy_date;
	}
	public Therapy getTherapy() {
		return therapy;
	}
	public void setTherapy(Therapy therapy) {
		this.therapy = therapy;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Comments, id, patient, therapy, therapy_date);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient_Therapy other = (Patient_Therapy) obj;
		return Objects.equals(Comments, other.Comments) && Objects.equals(id, other.id)
				&& Objects.equals(patient, other.patient) && Objects.equals(therapy, other.therapy)
				&& Objects.equals(therapy_date, other.therapy_date);
	}
	@Override
	public String toString() {
		return "Patient_Therapy [Comments=" + Comments + ", therapy_date=" + therapy_date + ", therapy=" + therapy
				+ ", patient=" + patient + "]";
	}
	
	
	
}
