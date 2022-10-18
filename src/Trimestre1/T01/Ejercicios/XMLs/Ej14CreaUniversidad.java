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

public class Ej14CreaUniversidad {
    public static void main(String[] args) throws TransformerException, ParserConfigurationException {
        DocumentBuilderFactory miFactoria = DocumentBuilderFactory.newInstance();
        DocumentBuilder miConstructor = miFactoria.newDocumentBuilder();
        DOMImplementation implementacion = miConstructor.getDOMImplementation();

        Document miDocumento = implementacion.createDocument(null, "universidad", null);
        miDocumento.setXmlVersion("1.0");

        Scanner teclado = new Scanner(System.in);

        Element departamento = miDocumento.createElement("departamento");

        System.out.println("Introduce el teléfono del departamento: ");
        String telInput = teclado.nextLine();
        departamento.setAttribute("telefono", telInput);

        System.out.println("Introduce el tipo del departamento: ");
        String tipoInput = teclado.nextLine();
        departamento.setAttribute("tipo", tipoInput);

        System.out.println("Introduce el código del departamento: ");
        String codigoInput = teclado.nextLine();
        Element codigo = miDocumento.createElement("codigo");
        Text txtCodigo = miDocumento.createTextNode(codigoInput);
        codigo.appendChild(txtCodigo);

        departamento.appendChild(codigo);

        System.out.println("Introduce el nombre del departamento: ");
        String nombreInput = teclado.nextLine();
        Element nombre = miDocumento.createElement("nombre");
        Text txtnombre = miDocumento.createTextNode(nombreInput);
        nombre.appendChild(txtnombre);

        departamento.appendChild(nombre);


        for (int i = 0; i < 2; i++) {
            Element empleado = miDocumento.createElement("empleado");

            System.out.println("Introduce el salario del empleado: ");
            String salarioInput = teclado.nextLine();
            empleado.setAttribute("salario", salarioInput);

            System.out.println("Introduce el puesto del empleado: ");
            String puestoInput = teclado.nextLine();
            Element puesto = miDocumento.createElement("puesto");
            Text txtpuesto = miDocumento.createTextNode(puestoInput);
            puesto.appendChild(txtpuesto);

            System.out.println("Introduce el nombre del empleado: ");
            String nombreInput2 = teclado.nextLine();
            Element nombre2 = miDocumento.createElement("nombre");
            Text txtnombre2 = miDocumento.createTextNode(nombreInput2);
            nombre2.appendChild(txtnombre2);

            empleado.appendChild(puesto);
            empleado.appendChild(nombre2);

            departamento.appendChild(empleado);
        }

        miDocumento.getDocumentElement().appendChild(departamento);

        Source source = new DOMSource(miDocumento);
        Result resultado = new StreamResult(new File("src/ACDA/Trimestre1/T01/Ejercicios/XMLs/universidad.xml"));
        Transformer miTransformer = TransformerFactory.newInstance().newTransformer();
        miTransformer.transform(source, resultado);

    }
}
