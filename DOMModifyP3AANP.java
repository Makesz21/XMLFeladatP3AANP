package hu.domparse.p3aanp;

import java.io.*;

import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;

import org.w3c.dom.*;
import org.xml.sax.*;

public class DOMModifyP3AANP {

	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException, TransformerException { {
        
		String xmlFilePath = "XMLP3AANP.xml"; //File beolvas�sa
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File(xmlFilePath));
		
		Node masodikGyogyszer = document.getElementsByTagName("gyogyszer").item(1); //A 2. gy�gyszer elem gyerekelemeinek megkeres�se
		NodeList masodikGyogyszerNodeList = masodikGyogyszer.getChildNodes();
		
		for (int i = 0; i < masodikGyogyszerNodeList.getLength(); i++) { //A 2. gy�gyszer elem hat�anyag�nak megv�ltoztat�sa magn�ziumra
			Node element = masodikGyogyszerNodeList.item(i);
			if ("hatoanyag".equals(element.getNodeName())) {
				element.setTextContent("magn�zium");
			}
		}
		
		Element ar = document.createElement("�r"); //A 2. gy�gyszer elemhez hozz�adunk egy �r elemet is.
		ar.appendChild(document.createTextNode("1759"));
		masodikGyogyszer.appendChild(ar);
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance(); //A m�dos�t�sokat felt�ltj�k az XML file-ba
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File(xmlFilePath));
		transformer.transform(source, result);
		
		System.out.println("V�ltoztat�sok sikeresen eszk�z�lve az XML file-on!!!!"); //Nyugt�zzuk az elg�vzett m�dos�t�sokat
		}
	}
}

