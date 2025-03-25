package RehabClinicPOJOs;

import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Therapy implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4394940046926912886L;

	private Integer id;
	private String description;
	private Blob machine;
	private List<Clinician> doctors;
	private List<Patient_Therapy> patienttherapy;
	
	public Therapy() {
		super();
		doctors = new ArrayList<Clinician>();
		patienttherapy = new ArrayList<Patient_Therapy>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Blob getMachine() {
		return machine;
	}

	public void setMachine(Blob machine) {
		this.machine = machine;
	}

	public List<Clinician> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Clinician> doctors) {
		this.doctors = doctors;
	}

	
	public List<Patient_Therapy> getPatienttherapy() {
		return patienttherapy;
	}

	public void setPatienttherapy(List<Patient_Therapy> patienttherapy) {
		this.patienttherapy = patienttherapy;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, doctors, id, patienttherapy);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Therapy other = (Therapy) obj;
		return Objects.equals(description, other.description) && Objects.equals(doctors, other.doctors)
				&& Objects.equals(id, other.id) && Objects.equals(patienttherapy, other.patienttherapy);
	}

	@Override
	public String toString() {
		return "Therapy [id=" + id + ", description=" + description + ", doctors=" + doctors + "]";
	}
	
	
	
	
	
	
}
