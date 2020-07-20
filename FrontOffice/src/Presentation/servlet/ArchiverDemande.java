package ma.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import frontMetier.Demande;
import frontMetier.GestionairePersonne;
import frontMetier.GestionnaireDemande;
import frontMetier.GestionnaireProcedure;
import frontMetier.Personne;
import frontMetier.Procedure;

/**
 * Servlet implementation class ArchiverDemande
 */
@WebServlet("/ArchiverDemande")
public class ArchiverDemande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArchiverDemande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    GestionnaireDemande demande=new GestionnaireDemande();
	    GestionnaireProcedure procedures= new GestionnaireProcedure();
	    List<Integer> listeDemande=new ArrayList<Integer>();
		HttpSession session=request.getSession();
		String cin=(String) session.getAttribute("nom");
		GestionairePersonne person=new GestionairePersonne();
		Personne personne=person.getChefDivision(Integer.parseInt(cin));
		/*
		 * les demandes de toutes les procedures affecte au chef de division et n'ont pas encore archiver
		 */
	    for(Procedure proc:procedures.getAllProcedure(personne.getIdPersonne()))
	    {	
		for(Demande dem:demande.getDemandesChef(proc.getId_procedure()))
		{if(!dem.getIs_archived())
		listeDemande.add(dem.getId_demande());	
		}
		}
		request.setAttribute("demande", listeDemande);
		String demandeArchiv=request.getParameter("demande");
		if ( !(demandeArchiv == null || demandeArchiv.trim().length() == 0 ))
		{
		{   
			System.out.println(demandeArchiv);
			demande.archiverDemande(Integer.parseInt(demandeArchiv));
		}
		}
		 this.getServletContext().getRequestDispatcher( "/WEB-INF/archiverDemande.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
