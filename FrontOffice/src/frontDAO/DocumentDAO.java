package frontDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import frontMetier.Document;
import frontDAO.ConnexionMySQL;;

public class DocumentDAO {

	private Connection connect;
	private ResultSet result;
	private PreparedStatement prepare;
	
	public DocumentDAO() {
		super();
		this.connect = ConnexionMySQL.getInstanceConnect();
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
				document.setId_document(result.getInt(1));
				document.setNom_document(result.getString(2));
				
				listDocumentsProcedure.add(document);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listDocumentsProcedure;
		
	}
}
