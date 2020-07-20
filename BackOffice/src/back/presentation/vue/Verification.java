package back.presentation.vue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * classe permettant de verifier la forme d'un email
 *
 */
public class Verification {
	private Pattern pa;
	private Matcher m;
 
public boolean isMail(String mail){
	 pa = Pattern.compile("^[A-Z0-9._-]+@[A-Z]+\\.[A-Z]{2,4}$");
	 m = pa.matcher(mail.toUpperCase());
	return m.matches();
}
}
