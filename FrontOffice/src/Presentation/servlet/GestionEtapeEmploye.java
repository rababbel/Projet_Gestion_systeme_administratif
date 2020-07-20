package ma.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import frontMetier.Demande;
import frontMetier.GestionnaireDemande;

/**
 * Servlet implementation class GestionEtapeEmploye
 */
@WebServlet("/GestionEtapeEmploye")
public class GestionEtapeEmploye extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionEtapeEmploye() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		final String idEtape= request.getParameter("idEtape");
		session.setAttribute("idEtape",idEtape);
		GestionnaireDemande demandes=new GestionnaireDemande();
		ArrayList<Integer> demande=new ArrayList<Integer>();
		for(Demande dem:demandes.getDemandesEmploye(Integer.parseInt(idEtape)))
		{
			demande.add(dem.getId_demande());
		}
		request.setAttribute("demandes", demande);

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
