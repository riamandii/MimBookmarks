import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;


public class ContentExtractor {
	public String[] extractContent(String url){
		// Clean up URL (missing protocol)
		if( ! url.matches("\\w+://.+") ) {
			url = "http://" + url;
		}
		String[] content = null;
		try {
			// Fetch content
			Document doc = Jsoup.connect(url)
					.userAgent("Opera/9.80 (Macintosh; Intel Mac OS X 10.6.8; U; fr) Presto/2.9.168 Version/11.52")
					.ignoreContentType(true)
					.parser(Parser.xmlParser())
					.get();
			Element body = doc.body();
			if(body == null) {
				content = doc.text().split("\n");
			} else {
				// Remove script tags in the body
				Elements noise = body.select("script");
				for(Element e : noise) {
					e.remove();
				}
				// Remove pre tags in the body
				noise = body.select("pre");
				for(Element e : noise) {
					e.remove();
				}
				// Remove code tags in the body
				noise = body.select("code");
				for(Element e : noise) {
					e.remove();
				}
				// Remove code aside in the body
				noise = body.select("aside");
				for(Element e : noise) {
					e.remove();
				}
				content = body.text().split("\n");
			}

		} catch(IOException e) {}
		return content;
	}

}
