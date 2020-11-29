package hu.domparse.p3aanp;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.IOException;

public class DOMReadP3AANP {

	public static void main(String[] args)
		
		throws ParserConfigurationException, IOException, SAXException {

	        File xml = new File("XMLP3AANP.xml"); //Az XML file beolvasása
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //DocumentBuilderFactory inicializálása
	        
	        DocumentBuilder docBuilder = factory.newDocumentBuilder(); // A builder példányosítása
	        Document document = docBuilder.parse(xml); //A dokumentum konvertálása hogy értse az xml-t
	        document.getDocumentElement().normalize(); 
	        
	        ReadFile(document); //Kiíratjuk az összes adatot
	    }
	
	public static void ReadFile(Document document) { //Az adatok beolvasása és kiíratása
		
		  NodeList nodeList1 = document.getElementsByTagName("raktar"); //Lista létrehozása a gyermekelemeknek a raktár kulcsszóra
	        for (int i = 0; i < nodeList1.getLength(); i++) {
	            Node rNode = nodeList1.item(i);

	            if (rNode.getNodeType() == Node.ELEMENT_NODE) { //Elemek id-hez adása
	                Element element1 = (Element) rNode;
	                String gyogyszertar_id = element1.getAttribute("gyogyszertar_id"); //Attribútumok eltárolása
	                String raktar_id = element1.getAttribute("raktar_id");
	                
	                Node rNode1 = element1.getElementsByTagName("iranyitoszam").item(0); //Elemek eltárolása
	                String iranyitoszam = rNode1.getTextContent();
	                
	                Node rNode2 = element1.getElementsByTagName("varos").item(0);
	                String varos = rNode2.getTextContent();
	                
	                Node rNode3 = element1.getElementsByTagName("utca").item(0);
	                String utca = rNode3.getTextContent();
	                
	                Node rNode4 = element1.getElementsByTagName("hazszam").item(0);
	                String hazszam = rNode4.getTextContent();
	                
	                System.out.println("Raktár adatok: Gyógyszertár ID: " + gyogyszertar_id + ", Raktár ID: " + raktar_id + ", Irányítószám: " 
					+ iranyitoszam + ", Város: " + varos + ", Utca: " + utca + ", Házszám: " + hazszam + "."); //Az eltárolt adatok kiírása
	                
	            }
	        }
	       
	        NodeList nodeList2 = document.getElementsByTagName("gyogyszertar");
	        for (int i = 0; i < nodeList2.getLength(); i++) {
	            Node gytNode = nodeList2.item(i);
	            
	            if (gytNode.getNodeType() == Node.ELEMENT_NODE) {
	                Element element2 = (Element) gytNode;
	                String raktar_id = element2.getAttribute("raktar_id");
	                String gyogyszertar_id = element2.getAttribute("gyogyszertar_id");
	                String telszam = element2.getAttribute("telszam");
	                
	                Node gytNode1 = element2.getElementsByTagName("iranyitoszam").item(0);
	                String iranyitoszam = gytNode1.getTextContent();
	                
	                Node gytNode2 = element2.getElementsByTagName("varos").item(0);
	                String varos = gytNode2.getTextContent();
	                
	                Node gytNode3 = element2.getElementsByTagName("utca").item(0);
	                String utca = gytNode3.getTextContent();
	                
	                Node gytNode4 = element2.getElementsByTagName("hazszam").item(0);
	                String hazszam = gytNode4.getTextContent();
	                
	                Node gytNode5 = element2.getElementsByTagName("elerhetoseg").item(0);
	                String elerhetoseg = gytNode5.getTextContent();
	                
	                Node gytNode6 = element2.getElementsByTagName("nev").item(0);
	                String nev = gytNode6.getTextContent();
	                
	                System.out.println("Gyógyszertár adatok: Raktár ID: " + raktar_id + ", Gyógyszertár ID: " + gyogyszertar_id + ", Telefonszám: "
					+ telszam + ",Dolgozó adatok: (Név: " + nev + ", Irányítószám: " + iranyitoszam + ", Város: " + varos + ", Utca: " + utca + ", Házszám: " 
					+ hazszam + ", Elérhetõség: " + elerhetoseg + ").");
	            }
	        }
	        
	        NodeList nodeList3 = document.getElementsByTagName("gyogyszer");
	        for (int i = 0; i < nodeList3.getLength(); i++) {
	            Node gyNode = nodeList3.item(i);
	            
	            if (gyNode.getNodeType() == Node.ELEMENT_NODE) {
	                Element element3 = (Element) gyNode;
	                String gyogyszer_id = element3.getAttribute("gyogyszer_id");
	                String telszam = element3.getAttribute("telszam");
	                
	                Node gyNode1 = element3.getElementsByTagName("receptre_kaphato").item(0);
	                String receptre_kaphato = gyNode1.getTextContent();
	                
	                Node gyNode2 = element3.getElementsByTagName("hatoanyag").item(0);
	                String hatoanyag = gyNode2.getTextContent();
	                
	                Node gyNode3 = element3.getElementsByTagName("tipus").item(0);
	                String tipus = gyNode3.getTextContent();
	                
	                Node gyNode4 = element3.getElementsByTagName("nev").item(0);
	                String nev = gyNode4.getTextContent();
	                
	                
	                System.out.println("Gyógyszer adatok: Gyógyszer ID: " + gyogyszer_id + ", Telefonszám: " + telszam + ", Név: " + nev + 
					", Receptre kapható: " + receptre_kaphato + ", Hatóanyag: " + hatoanyag + ", Típus: " + tipus + ".");
	            }
	     }
	        
	        NodeList nodeList4 = document.getElementsByTagName("vasarlo");
	        for (int i = 0; i < nodeList4.getLength(); i++) {
	            Node vNode = nodeList4.item(i);
	            
	            if (vNode.getNodeType() == Node.ELEMENT_NODE) {
	                Element element4 = (Element) vNode;
	                String gyogyszer_id = element4.getAttribute("gyogyszer_id");
	                String telszam = element4.getAttribute("telszam");
	                String gyogyszertar_id = element4.getAttribute("gyogyszertar_id");
	                
	                Node vNode1 = element4.getElementsByTagName("nev").item(0);
	                String nev = vNode1.getTextContent();
	                
	                Node vNode2 = element4.getElementsByTagName("haziorvos").item(0);
	                String haziorvos = vNode2.getTextContent();
	                
	                Node vNode3 = element4.getElementsByTagName("gyogyszererzekenyseg").item(0);
	                String gyogyszererzekenyseg = vNode3.getTextContent();
	                
	                Node vNode4 = element4.getElementsByTagName("eletkor").item(0);
	                String eletkor = vNode4.getTextContent();
	                
	                
	                System.out.println("Vásárló adatok: Gyógyszer ID: " + gyogyszer_id + ", Telefonszám: " + telszam + ", Gyógyszertár ID: " 
					+ gyogyszertar_id +", Név: " + nev + ", Háziorvos: " + haziorvos + ", Gyógyszerérzékenység: " + gyogyszererzekenyseg +
					", Életkor: " + eletkor + ".");
			}    
		}
	        
	        NodeList nodeList5 = document.getElementsByTagName("szallitas");
	        for (int i = 0; i < nodeList5.getLength(); i++) {
	            Node szNode = nodeList5.item(i);
	            
	            if (szNode.getNodeType() == Node.ELEMENT_NODE) {
	                Element element5 = (Element) szNode;
	                String gyogyszertar_id = element5.getAttribute("gyogyszertar_id");
	                String raktar_id = element5.getAttribute("raktar_id");
	                
	                Node szNode1 = element5.getElementsByTagName("datum").item(0);
	                String datum = szNode1.getTextContent();
	                
	                Node szNode2 = element5.getElementsByTagName("fuvarozo_ceg").item(0);
	                String fuvarozo_ceg = szNode2.getTextContent();
	                
	                Node szNode3 = element5.getElementsByTagName("arucikkek").item(0);
	                String arucikkek = szNode3.getTextContent();
	                
	                Node szNode4 = element5.getElementsByTagName("szallitasi_mod").item(0);
	                String szallitasi_mod = szNode4.getTextContent();
	                
	                Node szNode5 = element5.getElementsByTagName("fizetesi_mod").item(0);
	                String fizetesi_mod = szNode5.getTextContent();
	                
	                Node szNode6 = element5.getElementsByTagName("osszeg").item(0);
	                String osszeg = szNode6.getTextContent();
	                
	                System.out.println("Szállítási adatok: Gyógyszertár ID: " + gyogyszertar_id + ", Raktár ID: " + raktar_id + ", Dátum: " + datum 
					+", Fuvarozó cég: " + fuvarozo_ceg + ", Árucikkek: " + arucikkek + ", Szállítási mód: " + szallitasi_mod + ", Fizetési mód: "
					+ fizetesi_mod + ", Összeg: " + osszeg + ".");
	            }
	        } 
	        
	        NodeList nodeList6 = document.getElementsByTagName("vasarlas");
	        for (int i = 0; i < nodeList6.getLength(); i++) {
	            Node vNode = nodeList6.item(i);
	            
	            if (vNode.getNodeType() == Node.ELEMENT_NODE) {
	                Element element6 = (Element) vNode;
	                String gyogyszertar_id = element6.getAttribute("gyogyszertar_id");
	                String telszam = element6.getAttribute("telszam");
	                
	                Node vNode1 = element6.getElementsByTagName("osszeg").item(0);
	                String osszeg = vNode1.getTextContent();
	                
	                Node vNode2 = element6.getElementsByTagName("fizetesi_mod").item(0);
	                String fizetesi_mod = vNode2.getTextContent();
	                
	                Node vNode3 = element6.getElementsByTagName("ceg_neve").item(0);
	                String ceg_neve = vNode3.getTextContent();
	                
	                Node vNode4 = element6.getElementsByTagName("maganszemely").item(0);
	                String maganszemely = vNode4.getTextContent();
	                
	                System.out.println("Vásárlási adatok: Gyógyszertár ID: " + gyogyszertar_id + ", Telefonszám: " + telszam + ", Összeg: " + osszeg
					+", Fizetési mód: " + fizetesi_mod + ", Számlázás: (Cég neve: " + ceg_neve + ", Magánszemély: " + maganszemely + ").");
	            }
	        }
	        
	        NodeList nodeList7 = document.getElementsByTagName("betegseg");
	        for (int i = 0; i < nodeList7.getLength(); i++) {
	            Node bNode = nodeList7.item(i);
	            
	            if (bNode.getNodeType() == Node.ELEMENT_NODE) {
	                Element element7 = (Element) bNode;
	                String telszam = element7.getAttribute("telszam");
	                String gyogyszer_id = element7.getAttribute("gyogyszer_id");
	                
	                Node bNode1 = element7.getElementsByTagName("panasz").item(0);
	                String panasz = bNode1.getTextContent();
	                
	                System.out.println("Betegség adatok: Telefonszám: " + telszam + ", Gyógyszer ID: " + gyogyszer_id +", Panasz: " + panasz + ".");
	            }
	        }
	}
}
