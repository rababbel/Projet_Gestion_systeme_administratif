package ma.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import frontMetier.GestionnaireCitoyen;

/**
 * Servlet implementation class connexionCitoyenVerification
 */
@WebServlet("/connexionCitoyenVerification")
public class connexionCitoyenVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public connexionCitoyenVerification() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cin=request.getParameter("cin");
		GestionnaireCitoyen citoyen=new GestionnaireCitoyen();
		String erreur="vous dever remplir les champs requis";
		if(cin==null ||cin.equals(""))
		{
			request.setAttribute("erreur", erreur);
			this.getServletContext().getRequestDispatcher( "/WEB-INF/connexionCitoyen.jsp" ).forward( request, response );
		}else if(citoyen.CitoyenExist(Integer.parseInt(cin)))
			this.getServletContext().getRequestDispatcher( "/WEB-INF/accuielCitoyen.jsp" ).forward( request, response );
		else
			{request.setAttribute("erreur", "votre cin est incorrect ");	
		   this.getServletContext().getRequestDispatcher( "/WEB-INF/connexionCitoyen.jsp" ).forward( request, response );}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
