package back.backDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import back.backMetier.Document;

public class DocumentDAO {
	
	private Connection connect;
	private ResultSet result;
	private PreparedStatement prepare;
	
	public DocumentDAO() {
		super();
		this.connect = ConnexionBD.getInstanceConnect();
	}
	
	public boolean ajouterDocument(Document document) {
		String query = "INSERT INTO document(idDocument,nomDocument,idProcedure) values(?,?,?)";
		try {
			prepare =connect.prepareStatement(query);
			prepare.setInt(1, document.getIdDocument());
			prepare.setString(2, document.getNomDocument());
			prepare.setInt(3, document.getIdProcedure());
			return prepare.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean modifierDocument(Document document) {
		String query = "UPDATE document set nomDocument = ? ,idProcedure = ? where idDocument = ? ";
		try {
			prepare =connect.prepareStatement(query);
			
			prepare.setString(1, document.getNomDocument());
			prepare.setInt(2, document.getIdProcedure());
			prepare.setInt(3, document.getIdProcedure());
			
			return prepare.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Document getDocument(int id) {
		Document document = null;
		String query = ("SELECT * FROM document WHERE idDocument = "+id);
		try {
			prepare = connect.prepareStatement(query);
			result = prepare.executeQuery();
			while(result.next()) {
				document = new Document();
				document.setIdDocument(result.getInt(1));
				document.setNomDocument(result.getString(2));
				document.setIdProcedure(result.getInt(3));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return document;
	}
	public ArrayList<Document> getAllDocument(){
		ArrayList<Document> listeDocument = new ArrayList<Document>();
		Document document;
		String query = "SELECT * FROM document";
		try {
			prepare = connect.prepareStatement(query);
			result = prepare.executeQuery();
			while(result.next()) {
				document = new Document();
				document.setIdDocument(result.getInt(1));
				document.setNomDocument(result.getString(2));
				document.setIdProcedure(result.getInt(3));
				
				listeDocument.add(document);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listeDocument;
		
	}
	
	public ArrayList<Document> getDocumentProcedure(int id) {
		ArrayList<Document> listDocumentsProcedure = new ArrayList<Document>();
		Document document;
		String query = ("SELECT * FROM document WHERE idProcedure = "+id);
		try {
			prepare = connect.prepareStatement(query);
			result = prepare.executeQuery();
			while(result.next()) {
				document = new Document();
				document.setIdDocument(result.getInt(1));
				document.setNomDocument(result.getString(2));
				document.setIdProcedure(result.getInt(3));
				
				listDocumentsProcedure.add(document);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listDocumentsProcedure;
		
	}

	public boolean isExist(Document document) {
		if (document.equals(this.getDocument(document.getIdDocument()))){
			return true;
		}
			return false;
		
	}
}
