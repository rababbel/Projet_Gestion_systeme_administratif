package back.presentation.controleur;

import back.backDAO.AdministrateurLoginDAO;
import back.presentation.vue.VueAccuiel;
public class LoginControleur {
private AdministrateurLoginDAO login;
private int cin;
private String pwd;
public LoginControleur(int cin, String pwd) {
	super();
	this.cin = cin;
	this.pwd = pwd;
	login=new AdministrateurLoginDAO();
	if(login.loginAdministrateur(cin, pwd))
		new VueAccuiel();
	else 
		new Alert("le nom d'utilisateur ou le mot de passe est incorrect");
}

}
