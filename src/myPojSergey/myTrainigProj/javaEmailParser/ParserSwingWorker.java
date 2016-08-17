package myPojSergey.myTrainigProj.javaEmailParser;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
//import java.util.ArrayList;
//import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
//import javax.swing.DefaultListModel;
import javax.swing.SwingWorker;
//import com.sun.java.accessibility.util.SwingEventMonitor;
//import myPojSergey.myTrainigProj.javaEmailParser.myParserEmailApplication.UICallback;



public abstract class ParserSwingWorker extends SwingWorker <List<String>, String>{
	
	static HashMap< String, URL> uniqEmailsURLsList;
	//static ArrayList<SwingWorker> listOfThreads = new ArrayList<>();
	// static ArrayList<SwingWorker> swingThreads = new ArrayList<>();
	//private UICallback ui;
	protected Mode mode;
	static boolean stop = false;
	protected ParserSwingWorker nextParser;
	protected URL startUrl = null; 
	protected int depth;
	protected String linkInfo; 
	//protected DefaultListModel<String> listModel;
	
	
	
	//protected List <URL> URLsFirstWebsite = new ArrayList<>(); // list of url for our website
	protected List <URL> URLsFirstWebsite = new LinkedList<>(); // list of url for our website
	protected List <String> URLsList = null; 
	//private static ArrayList<Thread> threads = new ArrayList<>(); 
	static HashSet <String> listOfUniqueURL = new HashSet<>(); 
	static double counter ;
	static double counterDone;
	
	
	
	ParserSwingWorker (URL url, int depth, Mode mode) {	
		//this.listModel = listModel;	
		this.startUrl = url;	
		this.depth = depth;
		this.mode = mode;
		//System.out.println("I am parsing new URL. It is" +"  \""+url+"\"  "+"My depth = "+ depth);
		}

	
	
	
	public void fillListURLs() throws MalformedURLException {
		URL getUrl;
		for(String str : URLsList ){
			if(stop) break;
			getUrl=getURL(str);
			if (!getListOfUniqueURL().contains(getUrl.getHost())) URLsFirstWebsite.add(getUrl);
			}
		}
	
	
	
	
	
	
	
	
	public static URL getURL(String link) throws MalformedURLException{
		return(new URL(link));
	}
		
	
	
	public  String ReadFromUrl ( ){
		
		
		StringBuilder strBldr = new StringBuilder();
		 try {
	    	  // URL url = new URL ( link);
	    	   InputStream is = startUrl.openStream();
	    	   BufferedReader br = new BufferedReader (new InputStreamReader (is));
	    	   String line; 
	    	   while ((line = br.readLine())!=null){  
	    		   strBldr.append(line);
	    	} 
	    	   br.close();
	    	   is.close();	   	   
	       } catch (Exception e){
	    	   e.printStackTrace ();
	       }	
	      return strBldr.toString();	
	}

	
	
	
	public static HashSet <String> getListOfUniqueURL() {
		return listOfUniqueURL;
	}

	
	
	
	public static void setListOfUniqueURL(HashSet<String> hashSet) {
		ParserSwingWorker.listOfUniqueURL = hashSet;
	}

	//public static ArrayList<SwingWorker> getThreads() {
	//	return swingThreads;
	//}

	//public static void setThreads(ArrayList<Thread> threads) {
	//	ParserSwingWorker.threads = threads;
	//}
	
	public enum Mode{
		NORMAL,RESOURCE_INTENSIVE;	
	}
}
