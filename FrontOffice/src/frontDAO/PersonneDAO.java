package frontDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import frontMetier.Personne;
import frontMetier.Role;

public class PersonneDAO {
	
	private Connection connect;
	private ResultSet result;
	private PreparedStatement prepare;
	
	public PersonneDAO() {
		super();
		this.connect = ConnexionMySQL.getInstanceConnect();
	}
	
	public Personne getEmploye(int cin) {
		Personne employe = new Personne();
		String query = ("SELECT * FROM personne WHERE role = 'employe' AND CIN = "+cin);
		try {
			prepare = connect.prepareStatement(query);
			result = prepare.executeQuery();
			while(result.next()) {
				employe = new Personne();
				employe.setId(result.getInt(1));
				employe.setCIN(result.getInt(2));
				employe.setNom(result.getString(3));
				employe.setPrenom(result.getString(4));
				employe.setEmail(result.getString(5));
				employe.setService(result.getString(6));
				employe.setRole(Role.employe);
				employe.setPassword(result.getString(8));

			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return employe;
		
	}
	public Personne getChefDivision(int cin) {
		Personne chefDivision = new Personne();
		String query = ("SELECT * FROM personne WHERE role = 'chefDivision' AND CIN = "+cin);
		try {
			prepare = connect.prepareStatement(query);
			result = prepare.executeQuery();
			while(result.next()) {
				chefDivision = new Personne();
				chefDivision.setId(result.getInt(1));
				chefDivision.setCIN(result.getInt(2));
				chefDivision.setNom(result.getString(3));
				chefDivision.setPrenom(result.getString(4));
				chefDivision.setEmail(result.getString(5));
				chefDivision.setService(result.getString(6));
				chefDivision.setRole(Role.chefDivision);
				chefDivision.setPassword(result.getString(8));

			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return chefDivision;
		
	}

}
