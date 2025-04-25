package RehabClinicUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import RehabClinicIfaces.PatientManager;
import RehabClinicIfaces.UserManager;
import RehabClinicJDBC.JDBCManager;
import RehabClinicJDBC.JDBCPatientManager;
import RehabClinicJPA.JPAUserManager;
import RehabClinicPOJOs.Patient;
import RehabClinicPOJOs.Role;
import RehabClinicPOJOs.User;

public class menu {
	
	private static JDBCManager jdbcmanager;
	private static PatientManager patientManager;
	private static UserManager usermanager;
	private static BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

	public static void main(String[] args) {
		// TODO Auto-generated method 
	
		jdbcmanager = new JDBCManager();
		patientManager = new JDBCPatientManager(jdbcmanager);
		usermanager = new JPAUserManager();
		
		int choice=0;
		try {
			
			
			do {
				
				System.out.println("Welcome to Rehab Clinic");
				System.out.println("Choose one of the following options:");
				System.out.println("1. Login");
				System.out.println("2. Sign-up");
				System.out.println("0. Exit");
				
				choice = Integer.parseInt(reader.readLine());
					
				switch(choice)
				{
				
				case 1: // add new patient
					login();
					break;
				case 2: // Sign-up
					addNewUser();
					break;
				case 0:				
				    jdbcmanager.closeConnection();
				    usermanager.disconnect();
				    break;

				}
				
			}while(choice!=0);
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unused")
	private static void login() {
		// TODO Auto-generated method stub
		
		
		try {
			System.out.println("Introduce email:");
			String email = reader.readLine();
			System.out.println("Introduce password");
			String passw = reader.readLine();
			
			User u = usermanager.checkPassword(email, passw);
			
			if (u!=null & u.getRole().getDescription().equals("Patient"))
			{
				
				System.out.println("Login Successful!");
				patientmenu(u.getEmail());
			}
			else if(u==null)
				System.out.println("No user with these credentials");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void patientmenu(String email) {
		// TODO Auto-generated method stub
		
		patientManager.getPatient(email);
		
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
	
	private static void addNewUser() {
		
		try {
			System.out.println("Introduce email: ");
			String email = reader.readLine();
			
			System.out.println("Introduce password: ");
			String passwd = reader.readLine();
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(passwd.getBytes());
			byte[] digest = md.digest();
			
			System.out.println("Choose one role:");
			List<Role> roles = usermanager.getRoles();
			System.out.println(roles.toString());
			Integer role = Integer.parseInt(reader.readLine());				
			Role r=usermanager.getRole(role);
			
			User u =  new User(email, digest, r);
						
			usermanager.newUser(u);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
