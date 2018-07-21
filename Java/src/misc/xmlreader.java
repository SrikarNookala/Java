package misc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class xmlreader {
  public static void main(String []args) throws ParserConfigurationException, SAXException, IOException{
	  File fXmlFile = new File("E:/performance fixes/saveandcreateanother/perf_save_create.xml");
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    PrintStream out = new PrintStream(new FileOutputStream("E:/performance fixes/saveandcreateanother/output.txt"));
	    System.setOut(out);
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    Document doc = dBuilder.parse(fXmlFile);
	    doc.getDocumentElement().normalize();
	    NodeList nList = doc.getElementsByTagName("Query");
	    for(int i=0;i<nList.getLength();i++){
	    	Node nNode = nList.item(i);
	    	 if(!nNode.getChildNodes().item(1).getTextContent().equals("SetupOptionVO")){
		    	 System.out.println("----------------------------------------------------------------");
		    	 System.out.println(nNode.getChildNodes().item(1).getTextContent());
		    	 System.out.println();
		    	  System.out.println(nNode.getChildNodes().item(2).getTextContent());
			    	 System.out.println();
		    	 System.out.println(nNode.getChildNodes().item(3).getTextContent());
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();
		    	 System.out.println();

	    	 }
	    	/*
	    	System.out.println(eElement.getAttribute("Sql"));
	    	System.out.println(eElement.getAttribute("ObjName"));
	    	if(!eElement.getAttribute("ObjName").equals("SetupOptionVO")){
	    		System.out.println(eElement.getAttribute("Sql"));
	    	}
	    	*/
	    }
  }
}
