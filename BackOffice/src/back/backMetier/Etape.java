package back.backMetier;

public class Etape {
	private int idEtape;
	private int idProcedure;
	private int idEmploye;
	
	
	public Etape() {
		super();
	}

	public Etape(int idEtape) {
		super();
		this.idEtape = idEtape;
	}

	public Etape(int idEtape, int idProcedure) {
		super();
		this.idEtape = idEtape;
		this.idProcedure = idProcedure;
	}

	public Etape(int idEtape, int idProcedure, int idEmploye) {
		super();
		this.idEtape = idEtape;
		this.idProcedure = idProcedure;
		this.idEmploye = idEmploye;
	}

	public int getIdEtape() {
		return idEtape;
	}

	public int getIdProcedure() {
		return idProcedure;
	}

	public int getIdEmploye() {
		return idEmploye;
	}

	public void setIdEtape(int idEtape) {
		this.idEtape = idEtape;
	}

	public void setIdProcedure(int idProcedure) {
		this.idProcedure = idProcedure;
	}

	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etape other = (Etape) obj;
		if (idEtape != other.idEtape)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Etape [idEtape=" + idEtape + ", idProcedure=" + idProcedure + ", idEmploye=" + idEmploye + "]";
	}
	
	
}
