package myPojSergey.myTrainigProj.javaEmailParser;

import java.net.URL;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher ;
import java.util.regex.Pattern;

//import javax.swing.DefaultListModel;

public class HTMLLinkExtractor {
	
	
	private  final String HTML_A_HREF_TAG_PATTERN ="<a\\s[^>]*href\\s*=\\s*\"(mailto:)*([^\"]*)\"";  //"<a href=\"(mailto:)*(.*?)\"";
	private  final String URL_VALIDATION_PATTERN = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
	private  final String HTML_A_MAILTO_TAG_PATTERN = "mailto:";
	//private final  String EMAIL_VALID =  "[^\\?](.*)(\\?*.*)";
	
	
	private  Pattern hrefPttrn;
	private Matcher matcherLink ;
	//private Matcher matcherEmail;
	private URL myURL;
	
	
	
	//private DefaultListModel<String> listModel;
	//private static HashMap < URL, String> uniqueListEmails;	
	
	//private ArrayList<String> getNewEmails = new ArrayList<>();
	private ArrayList<String> getNewEmails = new ArrayList<>();
	
	
	
	public ArrayList<String> getGetNewEmails() {
		return getNewEmails;
	}

/*	
	HTMLLinkExtractor(String html, URL myURL, DefaultListModel<String> listModel) {	
		
		this.listModel = listModel;
		
		this.myURL = myURL;	
		hrefPttrn = Pattern.compile(HTML_A_HREF_TAG_PATTERN);
		matcherLink = hrefPttrn.matcher(html);	
	}*/
	
	
	
	HTMLLinkExtractor(String html, URL myURL ) {	
		
		//this.listModel = listModel;	
		this.myURL = myURL;	
		hrefPttrn = Pattern.compile(HTML_A_HREF_TAG_PATTERN);
		matcherLink = hrefPttrn.matcher(html);	
		
	}
	
	
	
	
	public List<String> grabHTMLLinks() {		
		List <String> URLsList = new LinkedList<>();
		String getURL, forEmailCheck = null;	 
		while (matcherLink.find()) {
			forEmailCheck = matcherLink.group(1); // for "mailto:" tag checking
			getURL = matcherLink.group(2); // getting URLs and emails 
			addToListOfURLs(getURL, URLsList);
			printEmails(forEmailCheck, getURL); 		
		} 
		return URLsList;
	}
 
	
	
	
	public void addToListOfURLs(String getURL, List<String> URLsList){	
		if (Pattern.matches(URL_VALIDATION_PATTERN, getURL)) URLsList.add(getURL);		
	}
	
	
	
	
	public void printEmails (String forEmailCheck , String email) {	
		if (forEmailCheck !=null 
			&& Pattern.matches(HTML_A_MAILTO_TAG_PATTERN, forEmailCheck) 
			&& !getUniqueListEmails().containsKey(email)
			&& !Pattern.matches("\\?(.*)", email)
		){ 			
			//if (!Pattern.matches("\\?(.*)", email)){
			//System.out.println ("Extract e-mail: "+"\""+email+"\"");//+ " from site " +"\""+myURL+"\".");
			//System.out.println ("From site " +"\""+myURL+"\"");
			//System.out.println ("Don't Thank Me for My Service!");
			//System.out.println ("=====================================================================");   
		//getUniqueListEmails().put(myURL, email);
		getUniqueListEmails().put(email,myURL);
		//listModel.addElement("From site "+myURL.getHost()+"Extract e-mail:");
		//listModel.addElement(email);
		getNewEmails.add(email);
		//listModel.addElement("");
		//}
		}
	}

	
	
	public static HashMap < String, URL> getUniqueListEmails() {
		return ParserSwingWorker.uniqEmailsURLsList;
	}

	
	
	public static void setUniqueListEmails(HashMap < String, URL> uniqueListEmails) {
		ParserSwingWorker.uniqEmailsURLsList = uniqueListEmails;
	}		
}

//http://national.kharkov.ua/
//http://www.triworks.com.ua/kontakti/
