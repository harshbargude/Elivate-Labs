package repo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "novemequinox@2004";
	
	public static Connection connectToDB() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
	
}
