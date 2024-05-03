package CrawlerWebsite.CrawlerWebsite;

import java.util.HashSet;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.w3c.dom.Element;


public class WebCrawlerExample {
	
	private HashSet<String> urlLink;
	
	public WebCrawlerExample() {
		urlLink = new HashSet<String>();
	}
	
	public void getPageLink(String URL) {
		if (!urlLink.contains(URL)) {
			try {
				if (urlLink.add(URL)) {
					System.out.println(URL);
				}
				
				// Fetch the HTML code
				Document document = Jsoup.connect(URL).get();
				// Get links from HTML
				Elements availableLinksOnPage = (Elements) document.select("a[href]");
				
				// Loop for the available links
				for (org.jsoup.nodes.Element e : availableLinksOnPage) {
					// Continue get link from URL
					getPageLink(e.attr("abs:href"));
				}
 			} catch (Exception e) {
				// TODO: handle exception
 				System.out.println(e.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebCrawlerExample obj = new WebCrawlerExample();
		obj.getPageLink("https://en.wikipedia.org/");
	}

}
