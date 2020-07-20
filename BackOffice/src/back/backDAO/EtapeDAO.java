package back.backDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import back.backMetier.Etape;

public class EtapeDAO {
	private Connection connect;
	private ResultSet result;
	private PreparedStatement prepare;
	
	public EtapeDAO() {
		super();
		this.connect = ConnexionBD.getInstanceConnect();
	}

	public boolean ajouterEtape(Etape etape) {
		String query = "INSERT INTO etape(idEtape,idProcedure) values(?,?)";
		try {
			prepare =connect.prepareStatement(query);
			prepare.setInt(1, etape.getIdEtape());
			prepare.setInt(2, etape.getIdProcedure());
			
			return prepare.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean effacerEtape(Etape etape) {
		String query = "DELETE FROM etape WHERE idEtape = ?";
		try {
			prepare = connect.prepareStatement(query);
			prepare.setInt(1, etape.getIdEtape());
			
			return prepare.execute();
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Etape getEtape(int id) {
		Etape etape = null;
		String query = ("SELECT * FROM etape WHERE idEtape = "+id);
		try {
			prepare = connect.prepareStatement(query);
			result = prepare.executeQuery();
			while(result.next()) {
				etape = new Etape();
				etape.setIdEtape(result.getInt(1));
				etape.setIdProcedure(result.getInt(2));
				etape.setIdEmploye(result.getInt(3));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return etape;
	}
	
	public ArrayList<Etape> listeEtapesProcedure(){
		ArrayList<Etape> listeEtapesProcedure = new ArrayList<Etape>();
		Etape etape;
		String query = ("SELECT * FROM etape");
		try {
			prepare = connect.prepareStatement(query);
			result = prepare.executeQuery();
			while(result.next()) {
				etape = new Etape();
				etape.setIdEtape(result.getInt(1));
				etape.setIdProcedure(result.getInt(2));
				etape.setIdEmploye(result.getInt(3));
				
				listeEtapesProcedure.add(etape);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listeEtapesProcedure;
	}
	
	
	public ArrayList<Etape> listeEtapesProcedure(int idProcedure){
		ArrayList<Etape> listeEtapesProcedure = new ArrayList<Etape>();
		Etape etape;
		String query = ("SELECT * FROM etape where idProcedure = "+ idProcedure);
		try {
			prepare = connect.prepareStatement(query);
			result = prepare.executeQuery();
			while(result.next()) {
				etape = new Etape();
				etape.setIdEtape(result.getInt(1));
				etape.setIdProcedure(result.getInt(2));
				etape.setIdEmploye(result.getInt(3));
				
				listeEtapesProcedure.add(etape);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listeEtapesProcedure;
	}
	
	public ArrayList<Etape> listeEtapesPersonne(int idPersonne){
		ArrayList<Etape> listeEtapesPersonne = new ArrayList<Etape>();
		Etape etape;
		String query = ("SELECT * FROM etape where id_personne = "+ idPersonne);
		try {
			prepare = connect.prepareStatement(query);
			result = prepare.executeQuery();
			while(result.next()) {
				etape = new Etape();
				etape.setIdEtape(result.getInt(1));
				etape.setIdProcedure(result.getInt(2));
				etape.setIdEmploye(result.getInt(3));
				
				listeEtapesPersonne.add(etape);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listeEtapesPersonne;
	}
	
	public boolean affectationEtape(Etape etape) {
		String query = "UPDATE etape SET id_personne = ? where idEtape = ?";
		try {
			prepare = connect.prepareStatement(query);
			prepare.setInt(1, etape.getIdEmploye());
			prepare.setInt(2, etape.getIdEtape());
			
			return prepare.execute();
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean isExist(Etape etape) {
		if (etape.equals(this.getEtape(etape.getIdEtape()))){
			return true;
		}
			return false;
		
	}
}
