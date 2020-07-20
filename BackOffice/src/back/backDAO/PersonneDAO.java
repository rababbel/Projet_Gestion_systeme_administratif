package back.backDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import back.backMetier.Personne;
import back.backMetier.Role;

public class PersonneDAO {
	
	private Connection connect;
	private ResultSet result;
	private PreparedStatement prepare;
	
	
	public PersonneDAO() {
		super();
		this.connect = ConnexionBD.getInstanceConnect();
	}
	public boolean ajouterPersonne(Personne personne) {
		String query = "INSERT INTO personne(id_personne,CIN,nom,prenom,service,email,password,role) values(?,?,?,?,?,?,?,?)";
		try {
			prepare =connect.prepareStatement(query);
			prepare.setInt(1, personne.getIdPersonne());
			prepare.setInt(2, personne.getCIN());
			prepare.setString(3, personne.getNom());
			prepare.setString(4, personne.getPrenom());
			prepare.setString(5, personne.getService());
			prepare.setString(6, personne.getEmail());
			prepare.setString(7, personne.getPassword());
			prepare.setString(8, personne.getRole().name());
			
			return prepare.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	public boolean modifierPersonne(Personne personne) {
		String query = "UPDATE personne set CIN = ? ,nom = ? ,prenom = ?,service = ?,email = ? ,password = ? , role = ? where id_personne= ? ";
		try {
			prepare =connect.prepareStatement(query);
			prepare.setInt(1, personne.getCIN());
			prepare.setString(2, personne.getNom());
			prepare.setString(3, personne.getPrenom());
			prepare.setString(4, personne.getService());
			prepare.setString(5, personne.getEmail());
			prepare.setString(6, personne.getPassword());
			prepare.setString(7, personne.getRole().name());
			prepare.setInt(8, personne.getIdPersonne());
			
			return prepare.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public void archiverEmployer() {
		
	}
	
	public ArrayList<Personne> getAllEmploye(){
		ArrayList<Personne> listeEmploye = new ArrayList<Personne>();
		Personne personne;
		String query = "SELECT * FROM personne WHERE role = 'employe'";
		try {
			prepare = connect.prepareStatement(query);
			result = prepare.executeQuery();
			while(result.next()) {
				personne = new Personne();
				personne.setId(result.getInt(1));
				personne.setCIN(result.getInt(2));
				personne.setNom(result.getString(3));
				personne.setPrenom(result.getString(4));
				personne.setEmail(result.getString(5));
				personne.setService(result.getString(6));
				personne.setRole(Role.employe);
				personne.setPassword(result.getString(8));
				listeEmploye.add(personne);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listeEmploye;
		
	}
	public Personne getEmploye(int id) {
		Personne employe = new Personne();
		String query = ("SELECT * FROM personne WHERE role = 'employe' AND id_personne = "+id);
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
	
	public ArrayList<Personne> getAllChefdivision(){
		ArrayList<Personne> listeChefdivision = new ArrayList<Personne>();
		Personne personne;
		String query = "SELECT * FROM personne WHERE role = 'chefDivision'";
		try {
			prepare = connect.prepareStatement(query);
			result = prepare.executeQuery();
			while(result.next()) {
				personne = new Personne();
				personne.setId(result.getInt(1));
				personne.setCIN(result.getInt(2));
				personne.setNom(result.getString(3));
				personne.setPrenom(result.getString(4));
				personne.setEmail(result.getString(5));
				personne.setService(result.getString(6));
				personne.setRole(Role.chefDivision);
				personne.setPassword(result.getString(8));

				listeChefdivision.add(personne);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listeChefdivision;
		
	}
	
	public Personne getChefDivision(int id) {
		Personne chefDivision = new Personne();
		String query = ("SELECT * FROM personne WHERE role = 'chefDivision' AND id_personne = "+id);
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
	public boolean isExist(Personne personne) {
		if (personne.equals(this.getEmploye(personne.getIdPersonne()))){
			return true;
		}else if (personne.equals(this.getChefDivision(personne.getIdPersonne()))) {
			return true;
		}else 
			return false;
		
	}
	
	
	

}
