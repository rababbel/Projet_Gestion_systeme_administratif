package back.backMetier;

public class Procedure {

	private int idProcedure;
	private String nomProcedure;
	private int idChefDivision;
	
	public Procedure() {
		super();
	}
	
	public Procedure(int idProcedure, String nomProcedure, int idChefDivision) {
		super();
		this.idProcedure = idProcedure;
		this.nomProcedure = nomProcedure;
		this.idChefDivision = idChefDivision;
	}
	
	
	public Procedure(int idProcedure, int idChefDivision) {
		super();
		this.idProcedure = idProcedure;
		this.idChefDivision = idChefDivision;
	}

	public Procedure(int idProcedure, String nomProcedure) {
		super();
		this.idProcedure = idProcedure;
		this.nomProcedure = nomProcedure;
	}

	public int getIdProcedure() {
		return idProcedure;
	}

	public String getNomProcedure() {
		return nomProcedure;
	}

	public int getIdChefDivision() {
		return idChefDivision;
	}

	public void setIdProcedure(int idProcedure) {
		this.idProcedure = idProcedure;
	}

	public void setNomProcedure(String nomProcedure) {
		this.nomProcedure = nomProcedure;
	}

	public void setIdChefDivision(int idChefDivision) {
		this.idChefDivision = idChefDivision;
	}

	@Override
	public String toString() {
		return "Procedure [idProcedure=" + idProcedure + ", nomProcedure=" + nomProcedure + ", idChefDivision="
				+ idChefDivision + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Procedure other = (Procedure) obj;
		if (idProcedure != other.idProcedure)
			return false;
		return true;
	}
	
	
	
}
