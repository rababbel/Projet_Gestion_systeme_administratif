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
 * Servlet implementation class AccepterDemande
 */
@WebServlet("/AccepterDemande")
public class AccepterDemande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccepterDemande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    GestionnaireDemande demandes=new GestionnaireDemande();
    GestionnaireProcedure procedures= new GestionnaireProcedure();
    List<Integer> listeDemande=new ArrayList<Integer>();
	HttpSession session=request.getSession();
	String cin=(String) session.getAttribute("nom");
	GestionairePersonne person=new GestionairePersonne();
	Personne personne=person.getChefDivision(Integer.parseInt(cin));
    for(Procedure proc:procedures.getAllProcedure(personne.getIdPersonne()))
    {	
	for(Demande dem:demandes.getDemandesChef(proc.getId_procedure()))
	{
	listeDemande.add(dem.getId_demande());	
	}
	}
	request.setAttribute("demande", listeDemande);
	String demandeAccepte=request.getParameter("demande");
	if ( !(demandeAccepte == null || demandeAccepte.trim().length() == 0 ))
	{
	{
		demandes.accepterDemande(Integer.parseInt(demandeAccepte));
	}
	}
	 this.getServletContext().getRequestDispatcher( "/WEB-INF/accepterDemande.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
