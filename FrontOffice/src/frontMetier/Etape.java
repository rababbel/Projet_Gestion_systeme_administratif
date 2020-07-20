package frontMetier;

public class Etape {
	
	private int id_etape;
	private etat_etape etat_etape;
	
	public Etape() {
		super();
	}

	public Etape(int id_etape) {
		super();
		this.id_etape = id_etape;
	}

	public int getId_etape() {
		return id_etape;
	}

	public etat_etape getEtat_etape() {
		return etat_etape;
	}

	public void setId_etape(int id_etape) {
		this.id_etape = id_etape;
	}

	public void setEtat_etape(etat_etape etat_etape) {
		this.etat_etape = etat_etape;
	}
	
	

}
