package ma.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import frontMetier.Demande;
import frontMetier.Etape;
import frontMetier.GestionairePersonne;
import frontMetier.GestionnaireDemande;
import frontMetier.GestionnaireEtape;
import frontMetier.Personne;

/**
 * Servlet implementation class ConsulterDemande 
 */
@WebServlet("/ConsulterDemande")
public class ConsulterDemande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsulterDemande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionnaireEtape etape=new GestionnaireEtape();
		GestionnaireDemande demande=new GestionnaireDemande();
		HttpSession session=request.getSession();
		String cin=(String) session.getAttribute("nom");
		String role=(String) session.getAttribute("role");
		GestionairePersonne person=new GestionairePersonne();
		/*recuperation des etapes du l'emplye ou chef de division depuis sont id
		 * 
		 */
		Personne personne;
		if(role.equals("employe"))
		 personne=person.getEmploye(Integer.parseInt(cin));
		else
	     personne=person.getChefDivision(Integer.parseInt(cin));	
		
		ArrayList<Etape> ListeEtapes=etape.listeEtapesPersonne(personne.getIdPersonne());
		HashMap<Integer,Integer>  map=new HashMap<Integer,Integer>();
		ArrayList<Demande> listDemande;
		for(Etape eta:ListeEtapes)
		{   listDemande=demande.getDemandesEmploye(eta.getId_etape());
			for(Demande dem:listDemande)
			map.put(eta.getId_etape(),dem.getId_demande() );
		}
		request.setAttribute("demandes", map);
		this.getServletContext().getRequestDispatcher( "/WEB-INF/ConsulterDemande.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
