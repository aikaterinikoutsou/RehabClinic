package RehabClinicIfaces;

import java.io.File;

import RehabClinicPOJOs.Clinician;

public interface XMLManager {

	void patient2xml(Integer id);
	Clinician xml2Clinician(File xml);

}
