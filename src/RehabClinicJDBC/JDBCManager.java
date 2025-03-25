package RehabClinicJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCManager {
	
	private Connection c = null;

	public JDBCManager() {
		
		try {
		
		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection("jdbc:sqlite:./db/rehabclinic.db");
		c.createStatement().execute("PRAGMA foreign_keys=ON");
		
		System.out.println("Database connection opened");	
		
		createTables();
		
		
		}	
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			System.out.print("Libraries not loaded");
		}
	
	}//	public JDBCManager() 
	
	private void createTables() {
		
		try {
			
			Statement stmt = c.createStatement();
			
			String sql = "CREATE TABLE Clinicians("
					+ "id	INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "name TEXT,"
					+ "surname TEXT,"
					+ "speciality TEXT,"
					+ "email TEXT NOT NULL,"
					+ "phone  INTEGER )";		
			stmt.executeUpdate(sql);
			
			
			sql= "CREATE TABLE Patients("
					+ "	id	INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "	name	TEXT,"
					+ "	surname	TEXT,"
					+ "	dob	date,"
					+ "	telephone	INTEGER,"
					+ "	credit_card	TEXT,"
					+ "	email TEXT NOT NULL,"
					+ "	therapist_id INTEGER REFERENCES Clinicians(id) )";
			stmt.executeUpdate(sql);
			
			
			sql = "CREATE TABLE Therapies ("
					+ "	id	INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "	description TEXT NOT NULL,"
					+ "	machine	BLOB)";
			stmt.executeUpdate(sql);
			
			
			sql="CREATE TABLE Clinician_therapies ("
					+ "	therapist_id	INTEGER REFERENCES Clinicians(id),"
					+ "	therapies_id	INTEGER REFERENCES Therapies(id),"
					+ "	PRIMARY KEY(therapist_id, therapies_id) )";
			stmt.executeUpdate(sql);
			
			sql="CREATE TABLE Patient_therapies ("
					+ "	id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "	patient_id	INTEGER REFERENCES Clinicians(id) NOT  NULL,"
					+ "	therapies_id	INTEGER REFERENCES Therapies(id) NOT NULL,"
					+ "	comments TEXT,"
					+ "	therapy_date DATE NOT NULL)";
			stmt.executeUpdate(sql);
			
			
			// insert default values to the tables
			sql = "INSERT INTO Therapists (name, surname, speciality, email, phone)"
					+"VALUES('Christian', 'Fox', 'Trauma', 'chris@email.com', 89085245)";
			stmt.executeUpdate(sql);
			
			sql = "INSERT INTO Therapists (name, surname, speciality, email, phone)"
					+"VALUES('Maria', 'Dallas', 'Physio', 'maria@email.com', 89234545)";
			stmt.executeUpdate(sql);
			
			System.out.println("Tables created and default values inserted");
			
			
		}catch(SQLException e) {
			
			if(!e.getMessage().contains("already exists"))
				e.printStackTrace();
		}			
		
	}
	
	public void closeConnection() {
		
		try {		
			c.close();
		}catch(SQLException e)
		{	
			e.printStackTrace();
		}
	}
	
}
