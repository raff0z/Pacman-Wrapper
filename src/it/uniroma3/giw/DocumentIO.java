package it.uniroma3.giw;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DocumentIO {
	private String id2urlSport;
	private String id2urlMovies;
	private String id2urlGames;
	private String id2urlNews;
	

	private String csvpath;
	
	public DocumentIO(){
		Properties conf = new Properties();
		try {
			InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("config/pacman_configuration.properties");
			if(inputStream == null)
				System.out.println("qua");
			
			conf.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}		

		this.setId2urlSport(conf.getProperty("id2urlSport-path"));
		
		this.setId2urlGames(conf.getProperty("id2urlGames-path"));
		
		this.setId2urlMovies(conf.getProperty("id2urlMovie-path"));
		
		this.setId2urlNews(conf.getProperty("id2urlNews-path"));
		
		this.setCsvpath(conf.getProperty("csv-path"));
	}

	public String getId2urlSport() {
		return id2urlSport;
	}

	public void setId2urlSport(String id2urlSport) {
		this.id2urlSport = id2urlSport;
	}

	public String getCsvpath() {
	    return csvpath;
	}

	public void setCsvpath(String csvpath) {
	    this.csvpath = csvpath;
	}
	
	public String getId2urlMovies() {
		return id2urlMovies;
	}

	public void setId2urlMovies(String id2urlMovies) {
		this.id2urlMovies = id2urlMovies;
	}

	public String getId2urlGames() {
		return id2urlGames;
	}

	public void setId2urlGames(String id2urlGames) {
		this.id2urlGames = id2urlGames;
	}

	public String getId2urlNews() {
		return id2urlNews;
	}

	public void setId2urlNews(String id2urlNews) {
		this.id2urlNews = id2urlNews;
	}
	
	public void cleanPath() {
		File dir = new File(this.csvpath);
		if (dir.exists())
			deleteFolder(dir);
		dir.mkdir();
	}

	private void deleteFolder(File d) {
		for(File f : d.listFiles()) {
			if(!f.isFile())
				deleteFolder(f);
			f.delete();		
		}
	}
	
}
