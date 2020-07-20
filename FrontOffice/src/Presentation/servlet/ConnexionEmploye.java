package ma.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import frontDAO.LoginEmployeChef;
import frontMetier.ConnexionForm;

/**
 * Servlet implementation class ConnexionEmploye
 */
@WebServlet("/ConnexionEmploye")
public class ConnexionEmploye extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String ATT_FORM         = "form";     
    public static final String VUE              = "/WEB-INF/connexionEmploye.jsp";    
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {        
    	/* Affichage de la page de connexion */        
    	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    	}
    
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {        
    	/* Préparation de l'objet formulaire */        
    	ConnexionForm form = new ConnexionForm(); 
    	form.connecterUtilisateur( request);
    	request.setAttribute( ATT_FORM, form );
    	LoginEmployeChef utilisateur=new LoginEmployeChef();
    	String nom = request.getParameter("nom");       
    	String motDePasse = request.getParameter( "motdepasse" );
    	String role=request.getParameter("role");
    	/*
    	 * verification des donnees recupérérs
    	 */
    	if ( !(nom == null || nom.trim().length() == 0 ))
    	{ if(role.equals("employe"))
         {   
    		if(utilisateur.loginEmploye(Integer.parseInt(nom),motDePasse)==true)
         {
		    HttpSession session=request.getSession();  
		   session.setAttribute("nom",nom);
		   session.setAttribute("role", role);
    		this.getServletContext().getRequestDispatcher("/WEB-INF/accuielEmploye.jsp" ).forward( request, response );
         }else
        		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
         }	
    	  else if(role.equals("chef"))
         	{if(utilisateur.loginChef(Integer.parseInt(nom),motDePasse))
            	{
    		    HttpSession session=request.getSession();  
    		    session.setAttribute("nom",nom);
    		    session.setAttribute("role", role);
    		   this.getServletContext().getRequestDispatcher("/WEB-INF/accuielChef.jsp" ).forward( request, response );
    		  
            	}
         	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    		}else
        		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    	    
    	
    	}else
    		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    }

