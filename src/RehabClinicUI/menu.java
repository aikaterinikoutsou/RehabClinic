package RehabClinicUI;

import RehabClinicJDBC.JDBCManager;

public class menu {
	
	private static JDBCManager jdbcmanager;

	public static void main(String[] args) {
		// TODO Auto-generated method 
	
		jdbcmanager = new JDBCManager();
		
		
			
		
		System.out.println("Hello World");
		
		jdbcmanager.closeConnection();

		
	}

}
