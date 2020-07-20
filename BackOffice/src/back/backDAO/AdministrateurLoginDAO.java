package back.backDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AdministrateurLoginDAO {
	private Connection connect;
	private ResultSet result;
	private PreparedStatement prepare;
	
	public AdministrateurLoginDAO() {
		super();
		this.connect = ConnexionBD.getInstanceConnect();
	}
	public boolean loginAdministrateur(int CIN, String password) {
		String query = ("SELECT * FROM personne WHERE CIN = ? AND password = ? and role = 'admin'");
		try {
			prepare = connect.prepareStatement(query);
			prepare.setInt(1, CIN);
			prepare.setString(2, password);
			result = prepare.executeQuery();
			if(result.next()) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	

}
