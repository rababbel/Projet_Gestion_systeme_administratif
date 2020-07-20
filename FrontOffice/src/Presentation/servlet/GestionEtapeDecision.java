package ma.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import frontMetier.GestionnaireDemande;
import frontMetier.etat_etape;

/**
 * Servlet implementation class GestionEtapeDecision
 */
@WebServlet("/GestionEtapeDecision")
public class GestionEtapeDecision extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionEtapeDecision() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String idEtape=(String) session.getAttribute("idEtape");
		String idDemande=(String) session.getAttribute("id_Demande");
		String etat=request.getParameter("decision");
		GestionnaireDemande demande=new GestionnaireDemande();
		switch(etat)
		{case "accept":demande.gestionEtape(Integer.parseInt(idDemande),Integer.parseInt(idEtape),etat_etape.accept);
		    break;
		 case "maj":demande.gestionEtape(Integer.parseInt(idDemande),Integer.parseInt(idEtape),etat_etape.maj);
	     break;  
		 case "refus":demande.gestionEtape(Integer.parseInt(idDemande),Integer.parseInt(idEtape),etat_etape.refus);
		    break;
		 case "rejet":demande.gestionEtape(Integer.parseInt(idDemande),Integer.parseInt(idEtape),etat_etape.rejet);
		    break;
		
		}
		this.getServletContext().getRequestDispatcher( "/WEB-INF/GestionEtapeEmploye.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
