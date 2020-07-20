package frontMetier;

import org.bson.Document;

import frontDAO.LoginCitoyen;

public class GestionnaireCitoyen {
	
	public GestionnaireCitoyen() {
		super();
		
	}
	
	public Citoyen getCitoyen(Document doc){
		Citoyen citoyen = new Citoyen();
		
		citoyen.setCIN((int) ((Document) doc.get("citoyen")).get("CIN"));
		//System.out.println(citoyen.toString());
		return citoyen;
	}
	
	public boolean CitoyenExist(int CIN) {
		LoginCitoyen loginCitoyen = new LoginCitoyen();
		return loginCitoyen.CitoyenExist(CIN);
	}
	
}
