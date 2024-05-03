package CrawlerWebsite.CrawlerWebsite;

import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebCrawlerExampleWithDepth {
	private static final int MAX_DEPTH = 2;
	private HashSet<String> urlLinks;

	public WebCrawlerExampleWithDepth() {
		urlLinks = new HashSet<String>();
	}

	public void getPageLinks(String URL, int depth) {
		if (!urlLinks.contains(URL) && depth <= MAX_DEPTH) {

			System.out.println(">> Depth:" + depth + " [" + URL + "]");
			try {
				urlLinks.add(URL);
				Document document = (Document) Jsoup.connect(URL).get();
				Elements availableLinksOnPage = document.select("a[href]");
				depth++;
				
				for (Element ele : availableLinksOnPage) {
					getPageLinks(ele.attr("abs:href"), depth);
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("For '" + URL + "': " + e.getMessage()); 
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create instance of the WebCrawlerExampleWithDepth class  
	    WebCrawlerExampleWithDepth obj = new WebCrawlerExampleWithDepth ();  
	      
	    // pick a URL from the frontier and call the getPageLinks()method and pass 0 as starting depth  
	    obj.getPageLinks("https://daotao.vku.udn.vn/", 0); 
	}

}
