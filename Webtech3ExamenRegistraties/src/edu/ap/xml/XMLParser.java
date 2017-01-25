package edu.ap.xml;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.InputSource;

import java.io.*;

public class XMLParser {
	
	private String INPUTFILE = "C:/Users/Keiichi/workspace/Copy of Races/registraties.xml";
	
	/** Get all races from the xml file and return them 
	 * in html format
	 */
	public String getRaces() {
		File inputFile = new File(INPUTFILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	        String result = "<h2>Races</h2>";
	        
	        NodeList races = doc.getElementsByTagName("race");

	        for (int i = 0; i < races.getLength(); i++) {
	        	 Node nNode = races.item(i);
	        	 Element eElement = (Element) nNode;
	        	 
	        	 result += "<br/><b>Name : </b>" + eElement.getAttribute("name");
	        	 result += "<br/><b>Distance : </b>" + eElement.getAttribute("distance");
	        	 result += "<br/>";
	        }

	        return result;
		} 
		catch (Exception e) {
			return e.getMessage();
		}
	}
	
	/** Get the race with race_id and return them 
	 * in html format
	 */
	public String getRegistratie(String registratie_id) {
		File inputFile = new File(INPUTFILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	        String result = "<h2>Registratie</h2>";
	        
	        NodeList registraties = doc.getElementsByTagName("registratie");

	        for (int i = 0; i < registraties.getLength(); i++) {
	        	
	        	 Node nNode = registraties.item(i);
	        	 Element eElement = (Element) nNode;
	        	 
	        	 if(eElement.getAttribute("id").equalsIgnoreCase(registratie_id)) {
	        		 result += "<br/><b>registratie ID : </b>" + eElement.getAttribute("id");	        		 
	        		 result += "<br/><b>interventie datum : </b>" + eElement.getAttribute("datum");
	        		 result += "<br/><b>interventie tijd : </b>" + eElement.getAttribute("tijd");
	        		 result += "<br/><b>patiënt naam: </b>" + eElement.getAttribute("patiënt_firstname");
	        		 result += "<br/><b>patënt achternaam : </b>" + eElement.getAttribute("patiënt_lastname");
	        		 result += "<br/><b>patënt geboortedatum : </b>" + eElement.getAttribute("birthday");
	        		 result += "<br/><b>verpleegkundige : </b>" + eElement.getAttribute("verpleegkundige_name");
	        		 result += "<br/><b>diagnose : </b>" + eElement.getAttribute("diagnose");
	        		 result += "<br/>";
	        	 }
	        }

	        return result;
		} 
		catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String getRunner(String race_id, String runner_id) {
		File inputFile = new File(INPUTFILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	        String result = "<h2>Runner</h2>";
	        
	        NodeList races = doc.getElementsByTagName("race");

	        for (int i = 0; i < races.getLength(); i++) {
	        	
	        	 Node race = races.item(i);
	        	 Element eElement = (Element)race;
	        	 
	        	 if(eElement.getAttribute("id").equalsIgnoreCase(race_id)) {
	        		 
	        		 NodeList runners = eElement.getElementsByTagName("runner");
	        		 
	        		 for (int j = 0; j < runners.getLength(); j++) {
	        			 
	        			 Node runner = runners.item(j);
	        			 Element eElement2 = (Element)runner;
	        			 
	        			 if(eElement2.getAttribute("id").equalsIgnoreCase(runner_id)) {
	        				 
	        			 result += "<br/><b>First Name : </b>" + eElement2.getAttribute("first_name");
		        		 result += "<br/><b>Last Name : </b>" + eElement2.getAttribute("last_name");
		        		 result += "<br/><b>Age : </b>" + eElement2.getAttribute("age");
		        		 result += "<br />";
	        			 }
	        		 }
	        	 }
	        }

	        return result;
		} 
		catch (Exception e) {
			return e.getMessage();
		}
	}
	
	/** Get all runners for the race with race_id and return them
	 * in valid html format
	 */
	public String getRunners(String race_id) {
		File inputFile = new File(INPUTFILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	        String result = "<h2>Runners</h2>";
	        
	        NodeList races = doc.getElementsByTagName("race");

	        for (int i = 0; i < races.getLength(); i++) {
	        	
	        	 Node race = races.item(i);
	        	 Element eElement = (Element)race;
	        	 
	        	 if(eElement.getAttribute("id").equalsIgnoreCase(race_id)) {
	        		 NodeList runners = eElement.getElementsByTagName("runner");
	        		 for (int j = 0; j < runners.getLength(); j++) {
	        			 Node runner = runners.item(j);
	        			 Element eElement2 = (Element)runner;
	        			 result += "<br/><b>First Name : </b>" + eElement2.getAttribute("first_name");
		        		 result += "<br/><b>Last Name : </b>" + eElement2.getAttribute("last_name");
		        		 result += "<br/><b>Age : </b>" + eElement2.getAttribute("age");
	        		 }
	        	 }
	        }

	        return result;
		} 
		catch (Exception e) {
			return e.getMessage();
		}
	}
	
	/** Delete the rqce with race_id and return all races in 
	 * valid format
	 */
	public String deleteRace(String race_id) {
		File inputFile = new File(INPUTFILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	        
	        NodeList races = doc.getElementsByTagName("race");

	        for (int i = 0; i < races.getLength(); i++) {
	        	
	        	 Node nNode = races.item(i);
	        	 Element eElement = (Element)nNode;
	        	 
	        	 if(eElement.getAttribute("id").equalsIgnoreCase(race_id)) {
	        		 eElement.getParentNode().removeChild(eElement);
	        		 Transformer transformer = TransformerFactory.newInstance().newTransformer();
	                 DOMSource source = new DOMSource(doc);
	                 StreamResult result = new StreamResult(new StringWriter());
	                 transformer.transform(source, result);
	        	 }
	        }

	        return this.getRaces();
		} 
		catch (Exception e) {
			return e.getMessage();
		}
	}
	
	/**
	 * Add a race and return all races in
	 * html format
	 */
	public String addRace(String xml) {
		File inputFile = new File(INPUTFILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        // set validating false to enable copying
        // node from one document to another
        dbFactory.setValidating(false);
        DocumentBuilder dBuilder;
        
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc1 = dBuilder.parse(inputFile);
	        Document doc2 = dBuilder.parse(new InputSource(new StringReader(xml)));
	        Element element = (Element) doc2.getDocumentElement();
	        // imports a node from doc2 document to doc1, without altering
	        // or removing the source node from the original document
	        Node copiedNode = doc1.importNode(element, true);
	        // adds the node to the end of the list of children of this node
	        doc1.getDocumentElement().appendChild(copiedNode);
	        
	        /*FileWriter fw = new FileWriter(INPUTFILE);
	        fw.write(doc1.toString());
	        fw.close();*/
	        // write the new document to file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc1);
			StreamResult result = new StreamResult(new File(INPUTFILE));
			transformer.transform(source, result);
	        
	        return this.getRaces();
		} 
		catch (Exception e) {
			return e.getMessage();
		}
	}

	/**
	 * Add a runner to race with race_id and 
	 * return all races in html format
	 */
	public String addRunner(String race_id, String xml) {
		
		// implementation left to students
		
		return this.getRaces();
	}
	
	/**
	 * Utility method to print xml document
	 */
	public String prettyPrint(Document xml) throws Exception {
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		Writer out = new StringWriter();
		tf.transform(new DOMSource(xml), new StreamResult(out));
		return out.toString();
	}
}
