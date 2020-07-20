package back.backDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {
	private String URL = "jdbc:mysql://localhost/backprojet";
	private String login = "root";
	private String password = "";
    private static Connection connect;
    
    //Constructeur prive
    private ConnexionBD() {
    	try {
    		connect = DriverManager.getConnection(URL,login,password);
    	}catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    //Methode qui va retourner notre insance et la creer su elle n'existe pas
    public static Connection getInstanceConnect() {
    	if(connect==null) {
    		new ConnexionBD();
    		System.out.println("Connection fait");
    	}
    	else System.out.print("deja fait");
    	return connect;
    }

}
