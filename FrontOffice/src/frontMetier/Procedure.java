package frontMetier;

import java.util.ArrayList;

public class Procedure {
	private int id_procedure;
	private String nom_procedure;
	private ArrayList<Document> documents;
	private ArrayList<Etape> etapes;
	
	
	public Procedure() {
		super();
	}

	public Procedure(int id_procedure, String nom_procedure, ArrayList<Document> documents, ArrayList<Etape> etapes) {
		super();
		this.id_procedure = id_procedure;
		this.nom_procedure = nom_procedure;
		this.documents = documents;
		this.etapes = etapes;
	}

	public String getNom_procedure() {
		return nom_procedure;
	}

	public ArrayList<Document> getDocuments() {
		return documents;
	}

	public ArrayList<Etape> getEtapes() {
		return etapes;
	}

	public void setId_procedure(int id_procedure) {
		this.id_procedure = id_procedure;
	}

	public void setNom_procedure(String nom_procedure) {
		this.nom_procedure = nom_procedure;
	}

	public void setDocuments(ArrayList<Document> documents) {
		this.documents = documents;
	}

	public void setEtapes(ArrayList<Etape> etapes) {
		this.etapes = etapes;
	}

	@Override
	public String toString() {
		return "[id_procedure=" + id_procedure + ", nom_procedure="+nom_procedure +"]";
	}

	public int getId_procedure() {
		return id_procedure;
	}
	
	
	
	

}
