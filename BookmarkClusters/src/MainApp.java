import java.io.IOException;
import java.util.List;
import java.util.Map;


public class MainApp {

	public static void main(String[] args) {
		String [] urls = {
				"http://www.thestranger.com/seattle/Suggests",
				"http://www.guitarjamz.com/members/beginner/beginner-lessons.html",
				"http://pcottle.github.io/learnGitBranching/",
				"http://www.amazon.com/gp/product/B00HQZKTKS/ref=as_li_qf_sp_asin_il_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=B00HQZKTKS&linkCode=as2&tag=rorschach-20"
				};
		
		LDAExtractor extractor = new LDAExtractor(new ContentExtractor());
		for (String url : urls) {
			try {
				List<Map<String,Integer>> topics = extractor.extractTags(url);
				for()
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
