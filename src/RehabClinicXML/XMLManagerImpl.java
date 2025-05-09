package RehabClinicXML;

import java.io.File;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import RehabClinicIfaces.XMLManager;
import RehabClinicJDBC.JDBCManager;
import RehabClinicPOJOs.Clinician;
import RehabClinicPOJOs.Patient;
import RehabClinicPOJOs.Therapy;

public class XMLManagerImpl implements XMLManager{

	JDBCManager manager;
	
	@Override
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
			rs.close();
			stmt.close();
			
			Statement stmt2= manager.getConnection().createStatement();
			String sql2 = "SELECT * FROM Clinicians WHERE id=" + therapist_id;
			ResultSet rs2= stmt2.executeQuery(sql2);
			
			String name_c = rs2.getString("name");
			String surname_c = rs2.getString("surname");
			String speciality = rs2.getString("speciality");
			String email_c = rs2.getString("email");
			Integer phone = rs2.getInt("phone");
			rs2.close();
			stmt2.close();
			
			c = new Clinician(name_c, surname_c,speciality, email_c, phone);
			p = new Patient(name, surname, fecha, telephone, email, credit_card);
			
			//export this Patient to a XML file
			JAXBContext jaxbcontext =  JAXBContext.newInstance(Patient.class);
			Marshaller marshaller = jaxbcontext.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);

			File file = new File("./xmls/Patient.xml");
			
			marshaller.marshal(p,file);
			
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public Clinician xml2Clinician(File xml)
	{
		Clinician c = null;
		
		try {
			//read pet from xml file
			JAXBContext jaxbContext = JAXBContext.newInstance(Clinician.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			
			c = (Clinician) unmarshaller.unmarshal(xml);
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return c;

	}
}
