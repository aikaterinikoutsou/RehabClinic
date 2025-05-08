package RehabClinicXML;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import RehabClinicIfaces.XMLManager;
import RehabClinicJDBC.JDBCManager;
import RehabClinicPOJOs.Clinician;
import RehabClinicPOJOs.Patient;
import RehabClinicPOJOs.Therapy;

public class XMLManagerImpl implements XMLManager{

	JDBCManager manager;
	
	public void patient2xml(Integer id) {
		
		
		
		Patient p = null;
		Clinician c= null;
		List<Therapy> therapies = new ArrayList<Therapy>();
		manager = new JDBCManager();	
		try {
			Statement stmt = manager.getConnection().createStatement();
			String sql =  "SELECT * FROM Patients WHERE id=" + id;
			
			ResultSet rs= stmt.executeQuery(sql);
			
			String name = rs.getString("name");
			String surname = rs.getString("surname");
			Date fecha = rs.getDate("dob");
			Integer telephone = rs.getInt("telephone");
			Integer credit_card = rs.getInt("credit_card");
			String email = rs.getString("email");
			
			Integer therapist_id = rs.getInt("therapist_id");
			
			stmt.close();
			
		}catch(Exception e) {e.printStackTrace();}
	}
	
}
