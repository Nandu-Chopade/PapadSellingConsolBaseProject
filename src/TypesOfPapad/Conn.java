package TypesOfPapad;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

public class Conn {

	/* NEED TO IMPORT FOLLOWING SPECIFICATION FROM JAVA CLASSES
	 * import java.sql.DriverManager;
     * import java.sql.*;
	 * 
	 * CREATE VARIABLE LIKE Connection , Statement;
	 * 
	 * NOW MAKE CONSTRUCTOR
	 * 
	 * NOW DECLARE STRING TYPE VARIABLE WHICH IS 
	 * url, username , password
	 * NOW USE try catch block for handling sql database exception
	 * Now in side the try catch call Class.forName(Driver);
	 * Next --->
	 * connection = DriverManager.getConnection(url  , username , password)
	 * Next --->
	 * statement = connection.createStatement();
	 * 
	 * 
	 */
	
	Connection connection;
	Statement statement;
	
	Conn(){
		String url = "jdbc:mysql:///papads";
		String username = "root";
		String password = "NanduMySql@1998";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			statement = connection.createStatement();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
