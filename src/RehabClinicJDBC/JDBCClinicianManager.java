package RehabClinicJDBC;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import RehabClinicIfaces.ClinicianManager;
import RehabClinicPOJOs.Clinician;

public class JDBCClinicianManager implements ClinicianManager {

	public JDBCManager manager;
	
	public JDBCClinicianManager(JDBCManager m) {
	
		this.manager = m;
	}
	
	public List<Clinician> getAllClinicians()
	{
		List<Clinician> clinicians = new ArrayList<Clinician>();
		
		try {
		
			Statement stmt = manager.getConnection().createStatement();
			String sql = "Select * FROM clinicians";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Integer id = rs.getInt("id");
				String name= rs.getString("name");
				String surname = rs.getString("surname");
				String speciality = rs.getString("speciality");
				String email = rs.getString("email");
				Integer phone = rs.getInt("phone");
				
				Clinician c= new Clinician(id,name,surname,speciality,email,phone);
				clinicians.add(c);
			}

			rs.close();
			stmt.close();
				
		}catch(Exception e)
		{e.printStackTrace();}
		
		return clinicians;
		
	}
	
}
