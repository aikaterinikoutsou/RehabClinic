package RehabClinicUI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import RehabClinicJDBC.JDBCManager;
import RehabClinicJDBC.JDBCPatientManager;
import RehabClinicPOJOs.Patient;

public class menu {
	
	private static JDBCManager jdbcmanager;
	private static JDBCPatientManager patientManager;
	private static BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

	public static void main(String[] args) {
		// TODO Auto-generated method 
	
		jdbcmanager = new JDBCManager();
		int choice=0;
		try {
			
			
			do {
				
				System.out.println("Welcome to Rehab Clinic");
				System.out.println("Choose one of the following options:");
				System.out.println("1. Add a new patient");
				System.out.println("0. Exit");
				
				choice = Integer.parseInt(reader.readLine());
					
				switch(choice)
				{
				
				case 1: // add new patient
					addPatient();
					break;
				case 0:				
				    jdbcmanager.closeConnection();
				    break;

				}
				
			}while(choice!=0);
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	private static void addPatient() throws Exception
	{
		
		System.out.println("Please add the name of the patient:");
		String name= reader.readLine();
		System.out.println("Please add the surname of the patient");
		String surname= reader.readLine();
		System.out.println("Please add the Date Of Birth of the patient in format yyyy/MM/dd:");
		String dob_str = reader.readLine();
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		Date dob = (Date) df.parse(dob_str);
		System.out.println("Please add the patient's telephone number");
		Integer telephone = Integer.parseInt(reader.readLine());
		System.out.println("Please add the patient's email");
		String email = reader.readLine();
		System.out.println("Please add the patient's credit card");
		Integer credit = Integer.parseInt(reader.readLine());
		
		Patient p = new Patient(name, surname, dob,telephone, email,credit);
		
		patientManager.addPatient(p);
	}

}
