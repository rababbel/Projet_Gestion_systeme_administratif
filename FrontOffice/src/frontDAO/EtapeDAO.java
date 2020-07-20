package frontDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import frontMetier.Etape;
import frontDAO.ConnexionMySQL;;

public class EtapeDAO {
	private Connection connect;
	private ResultSet result;
	private PreparedStatement prepare;
	
	public EtapeDAO() {
		super();
		this.connect = ConnexionMySQL.getInstanceConnect();
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
				etape.setId_etape(result.getInt(1));
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
				etape.setId_etape(result.getInt(1));
				
				listeEtapesPersonne.add(etape);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listeEtapesPersonne;
	}
	public Etape getEtape(int id) {
		Etape etape = null;
		String query = ("SELECT * FROM etape WHERE idEtape = "+id);
		try {
			prepare = connect.prepareStatement(query);
			result = prepare.executeQuery();
			while(result.next()) {
				etape = new Etape();
				etape.setId_etape(result.getInt(1));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return etape;
	}
	
	
}
