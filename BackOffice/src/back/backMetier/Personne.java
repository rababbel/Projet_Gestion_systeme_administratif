package back.backMetier;

public class Personne {
	
	private int idPersonne;
	private int CIN;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String service;
	private Role role;
	
	public Personne() {
		super();
	}
	public Personne(int id, int cIN, String nom, String prenom, String email, String password,String service, Role role) {
		super();
		this.idPersonne = id;
		this.CIN = cIN;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.service = service;
		this.role = role;
	}
	public int getIdPersonne() {
		return idPersonne;
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
	public String getPassword() {
		return password;
	}
	public Role getRole() {
		return role;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public void setId(int id) {
		this.idPersonne = id;
	}
	public void setCIN(int cIN) {
		CIN = cIN;
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
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		if (CIN != other.CIN)
		//return false;
		 if (idPersonne != other.idPersonne)
			return false;

		return true;
	}
	@Override
	public String toString() {
		return "Personne [idPersonne=" + idPersonne + ", CIN=" + CIN + ", nom=" + nom + ", prenom=" + prenom
				+ ", email=" + email + ", password=" + password + ", service=" + service + ", role=" + role + "]";
	}

	
	

}
