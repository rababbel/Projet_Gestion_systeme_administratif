package frontDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import frontMetier.Procedure;
import frontDAO.ConnexionMySQL;

public class ProcedureDAO {
	
	private Connection connect;
	private ResultSet result;
	private PreparedStatement prepare;
	
	public ProcedureDAO() {
		super();
		this.connect = ConnexionMySQL.getInstanceConnect();
	}

	public ArrayList<Procedure> getAllProcedure(int idPersonne){
		ArrayList<Procedure> listeProcedure = new ArrayList<Procedure>();
		Procedure procedure;
		String query = "SELECT * FROM procedure_ WHERE idPersonne =" +idPersonne;
		try {
			prepare = connect.prepareStatement(query);
			result = prepare.executeQuery();
			while(result.next()) {
				procedure = new Procedure();
				procedure.setId_procedure(result.getInt(1));
				procedure.setNom_procedure(result.getString(2));
				
				listeProcedure.add(procedure);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listeProcedure;
		
	}
	
	public ArrayList<Procedure> getAllProcedure(){
		ArrayList<Procedure> listeProcedure = new ArrayList<Procedure>();
		Procedure procedure;
		String query = "SELECT * FROM procedure_" ;
		try {
			prepare = connect.prepareStatement(query);
			result = prepare.executeQuery();
			while(result.next()) {
				procedure = new Procedure();
				procedure.setId_procedure(result.getInt(1));
				procedure.setNom_procedure(result.getString(2));
				
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
				procedure.setId_procedure(result.getInt(1));
				procedure.setNom_procedure(result.getString(2));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return procedure;	
	}
}
