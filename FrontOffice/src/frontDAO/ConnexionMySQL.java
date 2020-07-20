package frontDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionMySQL {
	
	private String URL = "jdbc:mysql://localhost/backprojet";
	private String login = "root";
	private String password = "";
    private static Connection connect;
    
	private ConnexionMySQL() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e)
		{
			
		}
		try {
    		connect = DriverManager.getConnection(URL,login,password);
    	}catch (SQLException e) {
    		e.printStackTrace();
    	}
	}
	
	 public static Connection getInstanceConnect() {
	    	if(connect==null) {
	    		new ConnexionMySQL();
	    		System.out.println("Connection fait");
	    	}
	    	else System.out.println("deja fait");
	    	return connect;
	    }
    

}
