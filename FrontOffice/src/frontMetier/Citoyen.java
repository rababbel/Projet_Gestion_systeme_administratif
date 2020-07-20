package frontMetier;

public class Citoyen {
	private int CIN;
	private String nom;
	private String prenom;
	private String email;
	
	public Citoyen() {
		super();
	}

	public Citoyen(int cIN, String nom, String prenom) {
		super();
		this.CIN = cIN;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Citoyen(int cIN, String nom, String prenom, String email) {
		super();
		this.CIN = cIN;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public Citoyen(int cIN) {
		super();
		CIN = cIN;
	}

	public int getCIN() {
		return CIN;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setCIN(int cIN) {
		this.CIN = cIN;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "[CIN=" + CIN + "]";
	}

	
	
	

}
