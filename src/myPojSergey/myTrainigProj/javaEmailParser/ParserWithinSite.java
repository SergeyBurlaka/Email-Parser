
package myPojSergey.myTrainigProj.javaEmailParser;
import java.net.MalformedURLException;
import java.net.URL;
//import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
//import javax.swing.DefaultListModel;

import myPojSergey.myTrainigProj.javaEmailParser.myParserEmailApplication.InnerParserSwingWorker;
import myPojSergey.myTrainigProj.javaEmailParser.myParserEmailApplication;

public class ParserWithinSite extends InnerParserSwingWorker {	
		
		static ExecutorService threads;
		@SuppressWarnings("rawtypes")
		static List<Future> tasks;
		static myParserEmailApplication myParser;
		private static  Set <URL> otherURLs;	
		private static Set <URL> uniqURL;
		
		
		@SuppressWarnings("rawtypes")
		ParserWithinSite(myParserEmailApplication myParser, URL url, int depth, Mode mode,ExecutorService threads,  List <Future> task) {
			myParser.super(url, depth, mode);
			ParserWithinSite.tasks = task;
			ParserWithinSite.threads = threads;
			ParserWithinSite.myParser = myParser;
		}

		
		ParserWithinSite(URL url, int depth, Mode mode) {
			myParser.super(url, depth, mode);
		}
		
		

		@Override
		public void fillListURLs () throws MalformedURLException {
			linkInfo = startUrl.getHost();
			URL getUrl;
			for (String str : URLsList ){
				getUrl=getURL(str); //достали следующий урл на проверку	
				if (getUrl.getHost().equals(linkInfo)&& ! uniqURL.contains(getUrl)){
					URLsFirstWebsite.add(getUrl); //Ссылки с родительского сайта собираем вместе.
					//System.out.println("Формирую мой список ListURLs: "+URLsFirstWebsite+" Мой родитель: "+startUrl);	
					getUniqURL().add(getUrl);	
				}else				
					getOtherURLs().add(getUrl);	
			} 
		} 	
		
		
		
		@Override
		public void parseNextURLs(){
				//ParserSwingWorker nextParser ;
				//System.out.println("Парсю основные ссылки" +"мой список ListURLs : "+URLsFirstWebsite );
				//System.out.println("Мой входящий URL: "+startUrl);
				//System.out.println(+"Мой поток"+Thread.currentThread().getName());
				for (URL lnk : URLsFirstWebsite){					
					if(stop) break;////действует по нажатию "Стоп"
					tasks.add(( threads).submit( new ParserWithinSite ( lnk, depth-1,mode)	));
				}
			}	
		

		public static Set <URL> getOtherURLs() {
			return otherURLs;
		}

		public static void setOtherURLs(Set <URL> otherURLs) {
			ParserWithinSite.otherURLs = otherURLs;
		}

		public static Set <URL> getUniqURL() {
			return uniqURL;
		}

		public static void setUniqURL(Set <URL> uniqURL) {
			ParserWithinSite.uniqURL = uniqURL;
		}
	}

	
	
	

