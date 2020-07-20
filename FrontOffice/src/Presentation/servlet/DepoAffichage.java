package ma.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import frontMetier.Document;
import frontMetier.GestionnaireDemande;
import frontMetier.GestionnaireDocument;
import frontMetier.GestionnaireProcedure;
import frontMetier.Procedure;

/**
 * Servlet implementation class DepoAffichage
 */
@WebServlet("/DepoAffichage")
public class DepoAffichage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepoAffichage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionnaireProcedure procedures=new GestionnaireProcedure();
		GestionnaireDocument documents=new GestionnaireDocument();
		List<String> document=new ArrayList<String>();
		List<Integer> procedure=new ArrayList<Integer>();
		for(Procedure proc:procedures.getAllProcedure())
		{
			procedure.add(proc.getId_procedure());
		}
		//id du procedure selectionnée
		String id=request.getParameter("procedure");
		if(id!=null) {
		if(!id.equals("")) {
		for(Document doc:documents.getDocumentProcedure(Integer.parseInt(id)))
		{
			document.add(doc.getNom_document());
		}
		}
		}
		request.setAttribute("document", document);
        request.setAttribute("procedure",procedure);
        String idProc=request.getParameter("procedure");
        String cin=request.getParameter("cinCitoyen");
        String fichier=request.getParameter("fichier");
        GestionnaireDemande demande= new GestionnaireDemande();
        request.setAttribute("cinCitoyen", cin);
        if(idProc==null||cin==null)
        {
        	idProc="";
        	cin="";
        }
        if(!(idProc.equals("")||cin.equals("")||fichier.equals("")))
        { request.setAttribute("jeton",demande.ajouterDemande(Integer.parseInt(idProc), Integer.parseInt(cin)));
        }
		  request.setAttribute("procedures", procedure);
		 this.getServletContext().getRequestDispatcher( "/VueDepoDemande.jsp" ).forward( request, response );
		
		}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
