package it.webred.mui.inputxml;

import java.io.StringWriter;

import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import javax.xml.xpath.*;

import java.io.FileWriter;
import java.io.Writer;

public class MuiFornituraXML2TXTTransformer {

	private Source xsltSource;

	public MuiFornituraXML2TXTTransformer(String xslFile) {
		this.xsltSource = new StreamSource(xslFile);
	}

	public int[]  transform(String xmlFile, Writer output) throws Exception {
		try {
			StringWriter outputTmp = new StringWriter();

			// applica xsl
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer(this.xsltSource);

			transformer.transform(new StreamSource(xmlFile), new StreamResult(
					outputTmp));

			outputTmp.close();

			// aggiusta '.' inizio riga
			StringBuffer outputBuffer = new StringBuffer(outputTmp.toString()
					.trim());

			if (outputBuffer.length() > 0) {
				output.write(outputBuffer.charAt(0));
				for (int pos = 1; pos < outputBuffer.length(); pos++) {
					if (!(outputBuffer.charAt(pos) == '.' && outputBuffer
							.charAt(pos - 1) == '\n')) {
						output.write(outputBuffer.charAt(pos));
					}
				}
			}

			output.flush();
			output.close();
			return extractCounters(xmlFile);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Errore durante la trasformazione: "
					+ e.getMessage());
		}
	}

	public static void main(String[] args) {
		try {

			String xslDir = "./WebContent/xsl/";
			String testDir = "/home/franci/tmp/anno 2007_XML/marzo_07/";

			String xslFilePath = xslDir + "MUI-TEST.xsl";
			String xmlFilePath = testDir + "F205_200703_17.xml";
			String txtFilePath = testDir + "MUI-TEST.txt";

			// XPath xpath = XPathFactory.newInstance().newXPath();
			//
			// XPathExpression expr = xpath
			// .compile("/DatiOut/DatiRichiesta/N_File_Tot");
			//
			// //
			// // Object result = expr.evaluate(doc, XPathConstants.NODESET);
			// // NodeList nodes = (NodeList) result;
			// // for (int i = 0; i < nodes.getLength(); i++) {
			// // System.out.println(nodes.item(i).getNodeValue());
			// // }
			// //
			MuiFornituraXML2TXTTransformer test = new MuiFornituraXML2TXTTransformer(
					xslFilePath);
			test.transform(xmlFilePath, new FileWriter(txtFilePath));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int []  extractCounters(String xmlFilePath) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory domFactory = DocumentBuilderFactory
				.newInstance();
		domFactory.setNamespaceAware(true); // never forget this!
		DocumentBuilder builder = domFactory.newDocumentBuilder();
		Document doc = builder.parse(xmlFilePath);
		int nfile = -1, nFileTot = -1;
		NodeList nl = doc.getChildNodes();
		for (int i = 0; i < nl.getLength(); i++) {
			if ("DatiOut".equals(nl.item(i).getNodeName())) {
				NodeList nl2 = nl.item(i).getChildNodes();
				for (int j = 0; j < nl2.getLength(); j++) {
					if ("DatiRichiesta".equals(nl2.item(j).getNodeName())) {
						NodeList nl3 = nl2.item(j).getChildNodes();
						for (int k = 0; k < nl3.getLength(); k++) {
							if ("N_File_Tot".equals(nl3.item(k)
									.getNodeName())) {
								System.out.println(" N_File_Tot= "+ nl3.item(k).getTextContent());
								nFileTot = Integer.valueOf(nl3.item(k)
										.getTextContent());
							} else if ("N_File".equals(nl3.item(k)
									.getNodeName())) {
								System.out.println(" N_File= "+ nl3.item(k).getTextContent());
								nfile = Integer.valueOf(nl3.item(k)
										.getTextContent());
							}
						}
					}
				}
			}
		}
		return new int[]{nfile,nFileTot};
	}

}
