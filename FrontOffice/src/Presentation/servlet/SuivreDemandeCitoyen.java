package ma.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import frontMetier.Demande;
import frontMetier.GestionnaireDemande;

/**
 * Servlet implementation class SuivreDemandeCitoyen
 */
@WebServlet("/SuivreDemandeCitoyen")
public class SuivreDemandeCitoyen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuivreDemandeCitoyen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String jeton=request.getParameter("jeton");
		 request.setAttribute("jeton",jeton);
			
			GestionnaireDemande g = new GestionnaireDemande();
			ArrayList<Demande> b = new ArrayList<Demande>();
			
	     if(jeton!=null)
		 {
		    try{/*supprimer les espaces blancs du debut et fin*/
		    jeton=jeton.trim();
	    	 b=g.getDemandeCitoyen(jeton);
	    	 if(b.get(0).getEtat_demande()==null)
	    	 request.setAttribute("etape", "non encore traité");
	    	 else
	    	 request.setAttribute("etape",b.get(0).getEtat_demande());
	    	 }catch(IllegalArgumentException e)
		    {
	    		 request.setAttribute("erreur", "jeton invalid réssayer");
		    }
		    
	    	 }
	 
	   
		this.getServletContext().getRequestDispatcher( "/WEB-INF/suivreDemandeCitoyen.jsp" ).forward( request, response );
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
