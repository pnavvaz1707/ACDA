package Trimestre1.T01.Ejercicios.XMLs;

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

/**
 * 13. Recorrer el fichero creado en el ejercicio anterior.
 */


public class Ej13RecorreClientes {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory miFactoria = DocumentBuilderFactory.newInstance();
        DocumentBuilder miConstructor = miFactoria.newDocumentBuilder();

        Document miDocumento = miConstructor.parse(new File("src/ACDA/Trimestre1/T01/Ejercicios/XMLs/clientes.xml"));

        NodeList listaClientes = miDocumento.getElementsByTagName("cliente");

        for (int i = 0; i < listaClientes.getLength(); i++) {
            Node nodo = listaClientes.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE){
                Element e = (Element) nodo;
                System.out.println("\nNúmero: " + e.getNodeName() + ": " + e.getAttribute("numero"));
                NodeList listaHijos = e.getChildNodes();

                for (int j = 0; j < listaHijos.getLength(); j++) {
                    Node hijo = listaHijos.item(j);
                    if (hijo.getNodeType() == Node.ELEMENT_NODE){
                        Element eHijo = (Element) hijo;
                        System.out.println(eHijo.getNodeName() + " --> " + eHijo.getTextContent());
                    }
                }
            }
        }

    }
}
