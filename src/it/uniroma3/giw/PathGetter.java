package it.uniroma3.giw;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class PathGetter {
	private String path;

	public PathGetter(String path) {
		this.path = path;
	}
	
	
	public List<String> getPaths() {
		List<String> list = new ArrayList<String>();

		try{
						
			FileReader filereader;

			filereader = new FileReader(path);

			BufferedReader b;
			b = new BufferedReader(filereader);

			String s;

			while((s=b.readLine()) != null) {

				String[] array = s.split(" -> ");

				list.add("file://"+array[0]);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return list;
	}
	
	
	
	

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	

}
