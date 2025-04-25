package RehabClinicIfaces;

import RehabClinicPOJOs.Patient;

public interface PatientManager {

	void addPatient(Patient p);

	void getPatient(String email);

}
