package back.backDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import back.backMetier.Procedure;

public class ProcedureDAO {
	private Connection connect;
	private ResultSet result;
	private PreparedStatement prepare;
	
	public ProcedureDAO() {
		super();
		this.connect = ConnexionBD.getInstanceConnect();
	}
	
	public boolean ajouterProcedure(Procedure procedure) {
		String query = "INSERT INTO procedure_(idProcedure,nomProcedure) values(?,?)";
		try {
			prepare =connect.prepareStatement(query);
			prepare.setInt(1, procedure.getIdProcedure());
			prepare.setString(2, procedure.getNomProcedure());
			
			return prepare.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean modifierProcedure(Procedure procedure) {
		String query = "UPDATE procedure_ set nomProcedure = ?  where idProcedure = ? ";
		try {
			prepare =connect.prepareStatement(query);
			
			prepare.setString(1, procedure.getNomProcedure());
			//prepare.setInt(2, procedure.getIdChefDivision());
			prepare.setInt(2, procedure.getIdProcedure());
			
			
			return prepare.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public ArrayList<Procedure> getAllProcedure(){
		ArrayList<Procedure> listeProcedure = new ArrayList<Procedure>();
		Procedure procedure;
		String query = "SELECT * FROM procedure_";
		try {
			prepare = connect.prepareStatement(query);
			result = prepare.executeQuery();
			while(result.next()) {
				procedure = new Procedure();
				procedure.setIdProcedure(result.getInt(1));
				procedure.setNomProcedure(result.getString(2));
				procedure.setIdChefDivision(result.getInt(3));
				
				listeProcedure.add(procedure);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listeProcedure;
		
	}
	
	public Procedure getProcedure(int id) {
		Procedure procedure = null;
		String query = ("SELECT * FROM procedure_ WHERE idProcedure = "+id);
		try {
			prepare = connect.prepareStatement(query);
			result = prepare.executeQuery();
			while(result.next()) {
				procedure = new Procedure();
				procedure.setIdProcedure(result.getInt(1));
				procedure.setNomProcedure(result.getString(2));
				procedure.setIdChefDivision(result.getInt(3));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return procedure;	
	}
	public boolean affectationProcedure(Procedure procedure) {
		String query = "UPDATE procedure_ SET idPersonne = ? where idProcedure = ?";
		try {
			prepare = connect.prepareStatement(query);
			prepare.setInt(1, procedure.getIdChefDivision());
			prepare.setInt(2, procedure.getIdProcedure());
			
			return prepare.execute();
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean isExist(Procedure procedure) {
		if (procedure.equals(this.getProcedure(procedure.getIdProcedure()))){
			return true;
		}
			return false;
		
	}
}
