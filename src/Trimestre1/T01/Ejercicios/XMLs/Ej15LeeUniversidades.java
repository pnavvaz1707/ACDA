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

public class Ej15LeeUniversidades {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory miFactoria = DocumentBuilderFactory.newInstance();
        DocumentBuilder miConstructor = miFactoria.newDocumentBuilder();

        Document miDocumento = miConstructor.parse(new File("src/ACDA/Trimestre1/T01/Ejercicios/XMLs/universidades.xml"));

        NodeList listaDepartamentos = miDocumento.getElementsByTagName("departamento");

        for (int i = 0; i < listaDepartamentos.getLength(); i++) {
            Node nodo = listaDepartamentos.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) nodo;
                System.out.println("\n" + e.getNodeName() + "--> Teléfono: " + e.getAttribute("telefono") + " | Tipo: " + e.getAttribute("tipo"));

                NodeList listaHijos = e.getChildNodes();

                for (int j = 0; j < listaHijos.getLength(); j++) {
                    Node hijo = listaHijos.item(j);

                    if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                        Element eHijo = (Element) hijo;

                        if (eHijo.getNodeName().equals("empleado")) {
                            System.out.println(eHijo.getNodeName() + " salario --> " + eHijo.getAttribute("salario"));

                            NodeList listaHijosEmpleado = eHijo.getChildNodes();

                            for (int k = 0; k < listaHijosEmpleado.getLength(); k++) {
                                Node hijoEmpleado = listaHijosEmpleado.item(k);

                                if (hijoEmpleado.getNodeType() == Node.ELEMENT_NODE) {
                                    Element eHijoEmpleado = (Element) hijoEmpleado;

                                    System.out.println(eHijoEmpleado.getNodeName() + " --> " + eHijoEmpleado.getTextContent());
                                }
                            }


                        } else {
                            System.out.println(eHijo.getNodeName() + " --> " + eHijo.getTextContent());
                        }
                    }
                }
            }
        }
    }
//        static void leerXML(Element eHijo) {
//        NodeList listaHijosEmpleado = eHijo.getChildNodes();
//
//        for (int k = 0; k < listaHijosEmpleado.getLength(); k++) {
//            Node hijoEmpleado = listaHijosEmpleado.item(k);
//
//            if (hijoEmpleado.getNodeType() == Node.ELEMENT_NODE) {
//                Element eHijoEmpleado = (Element) hijoEmpleado;
//
//                System.out.println(eHijoEmpleado.getNodeName() + " --> " + eHijoEmpleado.getTextContent());
//            }
//        }
//    }
}
