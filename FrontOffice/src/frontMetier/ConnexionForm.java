package frontMetier;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
public final class ConnexionForm 
{   
private static final String CHAMP_NOM  = "nom";    
private static final String CHAMP_PASS   = "motdepasse";    
private String              resultat;    
private Map<String, String> erreurs      = new HashMap<String, String>();   
public String getResultat() {        
	return resultat;    }    
public Map<String, String> getErreurs() {
	return erreurs;    
	} 
public void connecterUtilisateur( HttpServletRequest request) 
{        /* Récupération des champs du formulaire */        
	String nom = getValeurChamp( request, CHAMP_NOM);        
	String motDePasse = getValeurChamp( request, CHAMP_PASS ); 
       /* Validation du champ mot de passe. */        
	try {            
		validationMotDePasse( motDePasse ); 
		
		} 
	catch ( Exception e )
	{            
		setErreur( CHAMP_PASS, e.getMessage() );        
	}
	if ( nom == null || nom.trim().length() == 0 )
	{
		setErreur(CHAMP_NOM,"champs obligatoire");
	}
	}       
private void validationMotDePasse( String motDePasse ) throws Exception { 
	if ( motDePasse != null ) {            
		if ( motDePasse.length() < 3 ) {                
		throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );           
		}     
		} 
	    else {  
	    	throw new Exception( "Merci de saisir votre mot de passe." );        }    }   
/* * Ajoute un message correspondant au champ spécifié à la map des erreurs. */    
private void setErreur( String champ, String message )
{        erreurs.put( champ, message );  
}

private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
	String valeur = request.getParameter( nomChamp );        
	if ( valeur == null || valeur.trim().length() == 0 ) {
		return null;        }
	else {            return valeur;
         }    
	}
}

