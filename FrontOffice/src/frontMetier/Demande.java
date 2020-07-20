package frontMetier;


public class Demande {

	private int id_demande;
	private String date_depot;
	private String etat_demande;
	private Boolean is_archived;
	private Citoyen citoyen;
	private Procedure procedure;
	
	public Demande(int id_demande, String date_depot, Citoyen citoyen, Procedure procedure) {
		super();
		this.id_demande = id_demande;
		this.date_depot = date_depot;
		this.citoyen = citoyen;
		this.procedure = procedure;
		this.etat_demande = null;
		this.is_archived = false;
	}

	public Demande() {
	}

	public int getId_demande() {
		return id_demande;
	}

	public String getDate_depot() {
		return date_depot;
	}

	public String getEtat_demande() {
		return etat_demande;
	}

	public Boolean getIs_archived() {
		return is_archived;
	}

	public Citoyen getCitoyen() {
		return citoyen;
	}

	public Procedure getProcedure() {
		return procedure;
	}

	public void setId_demande(int id_demande) {
		this.id_demande = id_demande;
	}

	public void setDate_depot(String date_depot) {
		this.date_depot = date_depot;
	}

	public void setEtat_demande(String etat_demande) {
		this.etat_demande = etat_demande;
	}

	public void setIs_archived(Boolean is_archived) {
		this.is_archived = is_archived;
	}

	public void setCitoyen(Citoyen citoyen) {
		this.citoyen = citoyen;
	}

	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}

	@Override
	public String toString() {
		return "id_demande=" + id_demande + ", date_depot=" + date_depot + ", etat_demande=" + etat_demande
				+ ", is_archived=" + is_archived + ", citoyen=" + citoyen + ", procedure=" + procedure ;
	}

	
	
	
	
	
	
}
