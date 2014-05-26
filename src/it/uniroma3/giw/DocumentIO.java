package it.uniroma3.giw;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DocumentIO {
	private String id2urlSport;
	
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
	}

	public String getId2urlSport() {
		return id2urlSport;
	}

	public void setId2urlSport(String id2urlSport) {
		this.id2urlSport = id2urlSport;
	}

	
	
	
}