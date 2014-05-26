package it.uniroma3.giw;

import com.gargoylesoftware.htmlunit.html.DomAttr;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class WrapperTuttoMercatoWeb extends Wrapper{

    @Override
    public String[] getRowCSV(HtmlPage page) {
	
	String title = page.getTitleText();
	DomAttr img = page.getFirstByXPath("//img/@src[contains(.,'jpg') or contains(.,'jpeg')]");
	HtmlAnchor anchor = (HtmlAnchor) page.getByXPath("//*[contains(@class, 'correlati')]/li/a").get(0);
	
	String[] idArray = page.getUrl().toString().split("/");
	
	String id = idArray[idArray.length-1]; 
		
	String[] elementRow = {id,title,img.getValue(),anchor.getHrefAttribute()};
	
	System.out.println(title);
	
	return elementRow;
    }

    @Override
    public String[] getHeading() {

	String[] head = "id,titolo,img,link".split(",");
	
	return head;
    }

    @Override
    public String getCsvPath() {
	DocumentIO dio = new DocumentIO();
	return dio.getCsvpath();
    }

}