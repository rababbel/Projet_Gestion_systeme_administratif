package frontDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginEmployeChef {
	private Connection connect;
	private ResultSet result;
	private PreparedStatement prepare;
	
	public LoginEmployeChef() {
		super();
		this.connect = ConnexionMySQL.getInstanceConnect();
	}
	
	public boolean loginChef(int CIN, String password) {
		String query = ("SELECT * FROM personne WHERE CIN = ? AND password = ? and role = 'chefDivision'");
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
	
	public boolean loginEmploye(int CIN, String password) {
		String query = ("SELECT * FROM personne WHERE CIN = ? AND password = ? and role = 'employe'");
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
