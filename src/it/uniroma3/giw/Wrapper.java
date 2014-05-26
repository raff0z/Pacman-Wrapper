package it.uniroma3.giw;

import java.io.IOException;
import java.util.List;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public abstract class Wrapper {
	public abstract void extractCSV(HtmlPage page);
	
	public WebClient getNewWebClient() {
		WebClient webClient = new WebClient();
		webClient.getOptions().setCssEnabled(false);
		webClient.getOptions().setAppletEnabled(false);
		webClient.getOptions().setJavaScriptEnabled(false);
		return webClient;
	}

	public void doWrapping(String path) {
		WebClient webClient = getNewWebClient();		
		HtmlPage page;

		PathGetter pg = new PathGetter(path);
		List<String> paths = pg.getPaths();


		for (String pathPage : paths) {
			try {
				page = webClient.getPage(pathPage);
				System.out.println(page.getTitleText());
				//get title
				//get list
				//get img
				extractCSV(page);
			} catch (FailingHttpStatusCodeException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}


	}
	
}
