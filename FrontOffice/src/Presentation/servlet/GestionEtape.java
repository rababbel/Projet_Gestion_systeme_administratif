package ma.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import frontMetier.Etape;
import frontMetier.GestionairePersonne;
import frontMetier.GestionnaireEtape;
import frontMetier.Personne;

/**
 * Servlet implementation class GestionEtape
 */
@WebServlet("/GestionEtape")
public class GestionEtape extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionEtape() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionnaireEtape etape=new GestionnaireEtape();
		HttpSession session=request.getSession();
		String cin=(String) session.getAttribute("nom");
		GestionairePersonne person=new GestionairePersonne();
		Personne personne=person.getEmploye(Integer.parseInt(cin));
		System.out.println(personne.getIdPersonne());
		ArrayList<Etape> ListeEtapes=etape.listeEtapesPersonne(personne.getIdPersonne());
		ArrayList<Integer> listEtape=new ArrayList<Integer>();
		for(Etape eta:ListeEtapes)
			listEtape.add(eta.getId_etape());
		request.setAttribute("ListeEtapes",listEtape);
		this.getServletContext().getRequestDispatcher( "/WEB-INF/GestionEtape.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
