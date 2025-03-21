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
			
			String sql = "CREATE TABLE Therapists"
					+ "	id	INTEGER PRIMARY KEY AUTOINCREMENT"
					+ "	name TEXT"
					+ "	surname TEXT"
					+ "	speciality TEXT"
					+ "	 email TEXT NOT NULL "
					+ "	 phone  INTEGER )";		
			stmt.executeUpdate(sql);
			
			
			sql= "CREATE TABLE Patients"
					+ "	id	INTEGER PRIMARY KEY AUTOINCREMENT"
					+ "	name	TEXT"
					+ "	surname	TEXT"
					+ "	dob	date"
					+ "	telephone	INTEGER"
					+ "	credit_card	TEXT"
					+ "	email TEXT NOT NULL"
					+ "	therapist_id INTEGER REFERENCES Therapists(id) )";
			stmt.executeUpdate(sql);
			
			
		}catch(SQLException e) {
			
			if(!e.getMessage().contains("already exists"))
				e.printStackTrace();
		}
		
		
		
	}
	
}
