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
import java.io.*;
import java.util.Scanner;

public class Ej14CreaUniversidadv2 {
    public static void main(String[] args) throws TransformerException, ParserConfigurationException {
        DocumentBuilderFactory miFactoria = DocumentBuilderFactory.newInstance();
        DocumentBuilder miConstructor = miFactoria.newDocumentBuilder();
        DOMImplementation implementacion = miConstructor.getDOMImplementation();

        Document miDocumento = implementacion.createDocument(null, "universidad", null);
        miDocumento.setXmlVersion("1.0");

        File f = new File("src/Trimestre1/T01/Ejercicios/XMLs/DatosUniversidad.txt");

        try {
            String linea;
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String telInput = "";
            String tipoInput = "";
            String codigoInput = "";
            String nombreInput = "";
            String salarioInput = "";
            String puestoInput = "";
            String nombreInput2 = "";

            while ((linea = br.readLine()) != null) {
                String[] datosDpto = linea.split("#");
                String [] datosEmpleado = linea.substring(linea.indexOf("!")).split("#");
                // 0 = tel, 1 = tipo, 2 = codigo, 3 = nomDpto, 4 = salarioEmpleado, 5 = puestoEmpleado, 6 = nomEmpleado
                telInput = datosDpto[0];
                tipoInput = datosDpto[1];
                codigoInput = datosDpto[2];
                nombreInput = datosDpto[3];
                for (int i = 0; i < datosEmpleado.length; i++) {
                    salarioInput = datosEmpleado[0 + (i * 3)];
                    puestoInput = datosEmpleado[1 + (i * 3)];
                    nombreInput2 = datosEmpleado[2 + (i*3)];
                }
            }
            Element departamento = miDocumento.createElement("departamento");


            departamento.setAttribute("telefono", telInput);


            departamento.setAttribute("tipo", tipoInput);


            Element codigo = miDocumento.createElement("codigo");
            Text txtCodigo = miDocumento.createTextNode(codigoInput);
            codigo.appendChild(txtCodigo);

            departamento.appendChild(codigo);


            Element nombre = miDocumento.createElement("nombre");
            Text txtnombre = miDocumento.createTextNode(nombreInput);
            nombre.appendChild(txtnombre);

            departamento.appendChild(nombre);


            Element empleado = miDocumento.createElement("empleado");


            empleado.setAttribute("salario", salarioInput);


            Element puesto = miDocumento.createElement("puesto");
            Text txtpuesto = miDocumento.createTextNode(puestoInput);
            puesto.appendChild(txtpuesto);

            Element nombre2 = miDocumento.createElement("nombre");
            Text txtnombre2 = miDocumento.createTextNode(nombreInput2);
            nombre2.appendChild(txtnombre2);

            empleado.appendChild(puesto);
            empleado.appendChild(nombre2);

            departamento.appendChild(empleado);


            miDocumento.getDocumentElement().

                    appendChild(departamento);

            Source source = new DOMSource(miDocumento);
            Result resultado = new StreamResult(new File("src/ACDA/Trimestre1/T01/Ejercicios/XMLs/universidad.xml"));
            Transformer miTransformer = TransformerFactory.newInstance().newTransformer();
            miTransformer.transform(source, resultado);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
