package back.backMetier;

public class Document {
	
	private int idDocument;
	private String nomDocument;
	private int idProcedure;
	
	public Document() {
		super();
	}

	public Document(int idDocumet, String nomDocument, int idProcedure) {
		super();
		this.idDocument = idDocumet;
		this.nomDocument = nomDocument;
		this.idProcedure = idProcedure;
	}

	public int getIdDocument() {
		return idDocument;
	}

	public String getNomDocument() {
		return nomDocument;
	}

	public int getIdProcedure() {
		return idProcedure;
	}

	public void setIdDocument(int idDocumet) {
		this.idDocument = idDocumet;
	}

	public void setNomDocument(String nomDocument) {
		this.nomDocument = nomDocument;
	}

	public void setIdProcedure(int idProcedure) {
		this.idProcedure = idProcedure;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (idDocument != other.idDocument)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Document [idDocument=" + idDocument + ", nomDocument=" + nomDocument + ", idProcedure=" + idProcedure
				+ "]";
	}
	
	
	

}
