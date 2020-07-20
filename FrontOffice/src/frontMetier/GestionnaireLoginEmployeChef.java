package frontMetier;

import frontDAO.LoginEmployeChef;

public class GestionnaireLoginEmployeChef {

	private LoginEmployeChef loginEmployeChef;
	public GestionnaireLoginEmployeChef() {
		 this.loginEmployeChef = new LoginEmployeChef();
	}
	
	public boolean loginChef(int CIN, String password) {
		return loginEmployeChef.loginChef(CIN, password);
	}
	
	public boolean loginEmploye(int CIN, String password) {
		return loginEmployeChef.loginEmploye(CIN, password);
	}
}
