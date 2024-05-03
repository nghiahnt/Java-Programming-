package CrawlerWebsite.CrawlerWebsite;

import java.util.ArrayList;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class CrawlerWebsite_Wikipedia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "https://en.wikipedia.org/";
		String url2 = "https://daotao.vku.udn.vn/sv";
		String url3 = "https://www.youtube.com/watch?v=wrFXBV4MwvI";
		crawl(1, url, new ArrayList<String>());
	}

	private static void crawl(int level, String url, ArrayList<String> visited) {
		if (level <= 2) {
			Document doc = request(url, visited, level);

			if (doc != null) {
				for (Element link : doc.select("a[href]")) {
					String next_link = link.absUrl("href");
					if (visited.contains(next_link) == false) {
						crawl(level++, next_link, visited);
					}
				}
			}
		}
	}

	private static Document request(String url, ArrayList<String> v, int level) {
		Document doc = null;
		try {
			Connection con = Jsoup.connect(url);
			doc = con.get();

			if (con.response().statusCode() == 200) {
				System.out.println(level + " - Link: " + url);
				System.out.println(doc.title());
				v.add(url);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return doc;
	}

}
