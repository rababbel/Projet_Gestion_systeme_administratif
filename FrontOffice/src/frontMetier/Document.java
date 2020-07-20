package frontMetier;

public class Document {
	
	private int id_document;
	private String nom_document;
	
	
	public Document() {
		super();
	}

	public Document(int id_document, String nom_document) {
		super();
		this.id_document = id_document;
		this.nom_document = nom_document;
	}
	
	public int getId_document() {
		return id_document;
	}
	public String getNom_document() {
		return nom_document;
	}
	public void setId_document(int id_document) {
		this.id_document = id_document;
	}
	public void setNom_document(String nom_document) {
		this.nom_document = nom_document;
	}

	@Override
	public String toString() {
		return "Document [id_document=" + id_document + ", nom_document=" + nom_document + "]";
	}
	
	

}
