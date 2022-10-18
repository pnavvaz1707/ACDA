package Trimestre1.T01.Ejercicios.XMLs;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

/**
 * 12. Realiza un programa en Java que permita crear un fichero XML, utilizando
 * DOM, con la siguiente indicada, introduciendo los datos por teclado.
 * **/

public class Ej12CreaClientes {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory miFactoria = DocumentBuilderFactory.newInstance();
        DocumentBuilder miConstructor = miFactoria.newDocumentBuilder();
        DOMImplementation implementacion = miConstructor.getDOMImplementation();

        Document miDocumento = implementacion.createDocument(null, "clientes", null);
        miDocumento.setXmlVersion("1.0");

        Scanner teclado = new Scanner(System.in);

        Element cliente = miDocumento.createElement("cliente");

        System.out.println("Introduce el número: ");
        String numInput = teclado.nextLine();
        cliente.setAttribute("numero",numInput);

        System.out.println("Introduce el nombre: ");
        String nombreInput = teclado.nextLine();
        Element nombre = miDocumento.createElement("nombre");
        Text txtNombre = miDocumento.createTextNode(nombreInput);
        nombre.appendChild(txtNombre);

        cliente.appendChild(nombre);

        System.out.println("Introduce la población: ");
        String pobalcionInput = teclado.nextLine();
        Element poblacion = miDocumento.createElement("poblacion");
        Text txtPoblacion = miDocumento.createTextNode(pobalcionInput);
        poblacion.appendChild(txtPoblacion);

        cliente.appendChild(poblacion);


        System.out.println("Introduce el teléfono: ");
        String tlfInput = teclado.nextLine();
        Element tlf = miDocumento.createElement("tlf");
        Text txtTlf = miDocumento.createTextNode(tlfInput);
        tlf.appendChild(txtTlf);

        cliente.appendChild(tlf);

        System.out.println("Introduce la dirección: ");
        String direccionInput = teclado.nextLine();

        Element direccion = miDocumento.createElement("direccion");
        Text txtDireccion = miDocumento.createTextNode(direccionInput);
        direccion.appendChild(txtDireccion);

        cliente.appendChild(direccion);

        miDocumento.getDocumentElement().appendChild(cliente);

        Source source = new DOMSource(miDocumento);
        Result resultado = new StreamResult(new File("src/ACDA/Trimestre1/T01/Ejercicios/XMLs/clientes.xml"));
        Transformer miTransformer = TransformerFactory.newInstance().newTransformer();
        miTransformer.transform(source, resultado);
    }
}
