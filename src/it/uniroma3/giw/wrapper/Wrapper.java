package it.uniroma3.giw.wrapper;

import it.uniroma3.giw.PathGetter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public abstract class Wrapper {
	protected String CVSPath; 
	protected String[] header;
	protected String csvName;
	
	public Wrapper(){
		this.CVSPath = "";
		this.header = null;
		this.csvName = "";
	}
	
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

		System.out.println("Inizio scrittura file");

		try {
			CSVWriter csvw = new CSVWriter(new FileWriter(this.CVSPath + this.csvName + ".csv"));
			csvw.writeNext(this.header);

			for (String pathPage : paths) {
				try {
					page = webClient.getPage(pathPage);

					csvw.writeNext(getRowCSV(page));

				} catch (FailingHttpStatusCodeException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			csvw.close();
			System.out.println("Fine scrittura file");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	

	public abstract String[] getRowCSV(HtmlPage page);

}
