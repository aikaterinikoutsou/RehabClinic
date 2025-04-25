package RehabClinicJDBC;

import java.sql.PreparedStatement;

import RehabClinicIfaces.PatientManager;
import RehabClinicPOJOs.Patient;

public class JDBCPatientManager implements PatientManager {
	
	private JDBCManager manager;
	
	
	public JDBCPatientManager(JDBCManager m) {
		this.manager = m;
	}
	
	@Override
	public void addPatient(Patient p) {
		try {
			
			String sql = "INSERT INTO Patients (name, surname, dob, telephone, credit_card, email, therapist_id) VALUES(?,?,?,?,?,?,?)";
			
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
				
			prep.setString(1, p.getName());	
			prep.setString(2, p.getSurname());
			prep.setDate(3, p.getDob());
			prep.setInt(4, p.getTelephone());
			prep.setInt(5,p.getCredit_card());
			prep.setString(6, p.getEmail());
			prep.setInt(7, p.getTherapist().getId());
			
			prep.executeUpdate();
		
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}
