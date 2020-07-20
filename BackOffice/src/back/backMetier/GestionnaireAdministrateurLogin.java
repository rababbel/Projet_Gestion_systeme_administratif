package back.backMetier;

import back.backDAO.AdministrateurLoginDAO;

public class GestionnaireAdministrateurLogin {
	private AdministrateurLoginDAO administrateurLoginDAO;

	public GestionnaireAdministrateurLogin() {
		super();
		this.administrateurLoginDAO = new AdministrateurLoginDAO();
	}
	
	public boolean administrateurLogin(int CIN,String password) {
		return administrateurLoginDAO.loginAdministrateur(CIN, password);
	}
}
