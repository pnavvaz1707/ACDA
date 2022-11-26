package Trimestre1.ExamenesAntiguos.ExamenACDA2021;

import Trimestre1.AuxiliarExamen.Auxiliar;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
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
import java.sql.*;
import java.text.ParseException;
import java.util.Date;

public class Main {

    static Connection conexion;
    static ODB odb = ODBFactory.open(Datos.RUTA_SANCIONES_NEODATIS);

    public static void main(String[] args) {

        try {
            File f = new File(Datos.RUTA_SANCIONES_BINARIO);
            FileOutputStream fos = new FileOutputStream(f);
            DataOutputStream dos = new DataOutputStream(fos);


            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/bibliotecaexamen", "root", "");
            Statement sentencia = conexion.createStatement();
            String sql = "SELECT * FROM PRESTAMOS";
            ResultSet resul = sentencia.executeQuery(sql);

            System.out.println("\n============= Obtenemos los préstamos entregados con retraso y los guardamos en un fichero binario =============\n");

            while (resul.next()) {
                Date fechaMaxDevolucion = Auxiliar.convertirStringADate(resul.getString(5));
                Date fechaDevolucion = Auxiliar.convertirStringADate(resul.getString(6));
                Statement sentenciaAuxiliar = conexion.createStatement();
                ResultSet rsAuxiliar;

                if (fechaMaxDevolucion.after(fechaDevolucion)) {

                    sql = "SELECT NombreLibro FROM Libros WHERE CodigoLibro = " + resul.getInt(2);
                    rsAuxiliar = sentenciaAuxiliar.executeQuery(sql);

                    rsAuxiliar.next();
                    System.out.println("Nombre libro --> " + rsAuxiliar.getString(1));
                    dos.writeUTF(rsAuxiliar.getString(1));

                    sql = "SELECT Nombre,Apellidos FROM Usuario WHERE CodigoUsuario = " + resul.getInt(3);
                    rsAuxiliar = sentenciaAuxiliar.executeQuery(sql);

                    rsAuxiliar.next();
                    System.out.println("Nombre usuario --> " + rsAuxiliar.getString(1));
                    System.out.println("Apellido usuario --> " + rsAuxiliar.getString(2));
                    dos.writeUTF(rsAuxiliar.getString(1));
                    dos.writeUTF(rsAuxiliar.getString(2));

                    System.out.println("Número de días con retraso --> " + (fechaMaxDevolucion.getTime() - fechaDevolucion.getTime()) / 86400000);
                    dos.writeInt((int) ((fechaMaxDevolucion.getTime() - fechaDevolucion.getTime()) / 86400000));

                    System.out.println("Fecha máxima de devolución: " + resul.getString(5) + "\t" + Auxiliar.convertirStringADate(resul.getString(5)));
                    System.out.println("Fecha de devolución: " + resul.getString(6) + "\t" + Auxiliar.convertirStringADate(resul.getString(6)));
                    System.out.println();
                }
            }
            dos.close();

            System.out.println("\n============= Empezamos a leer el fichero binario y creamos la base de datos Neodatis y el XML =============\n");



            FileInputStream fis = new FileInputStream(f);
            DataInputStream dis = new DataInputStream(fis);

            DocumentBuilderFactory miFactoria = DocumentBuilderFactory.newInstance(); //Definición de la factoría DOM
            DocumentBuilder miConstructor = miFactoria.newDocumentBuilder(); //Definición del constructor DOM
            DOMImplementation implementacion = miConstructor.getDOMImplementation(); //Interfaz DOM
            Document miDocumento = implementacion.createDocument(null, "sanciones", null); //Creación del documento
            miDocumento.setXmlVersion("1.0"); //versión que se le va a dar de XML
            try {


                while (true) {
                    String nombreLibro, nombreUsuario, apellidoUsuario;
                    int numDiasRetraso;

                    nombreLibro = dis.readUTF();
                    nombreUsuario = dis.readUTF();
                    apellidoUsuario = dis.readUTF();
                    numDiasRetraso = dis.readInt();


                    System.out.println("Nombre libro --> " + nombreLibro);
                    System.out.println("Nombre usuario --> " + nombreUsuario);
                    System.out.println("Apellido usuario --> " + apellidoUsuario);
                    System.out.println("Número de días con retraso libro --> " + numDiasRetraso);
                    System.out.println();
                    odb.store(new Sancion(nombreLibro, nombreUsuario, apellidoUsuario, numDiasRetraso));
                    odb.commit();

                    Element usuariosXML = miDocumento.createElement("usuarios"); //Definición de la raíz del documento
                    Element usuarioXML = miDocumento.createElement("usuario"); //Definición del primer elemento "global"
                    usuarioXML.setAttribute("retraso", String.valueOf(numDiasRetraso)); //Asignación de un atributo al elemento "global"

                    Element nombreUsuarioXML = miDocumento.createElement("nombre_usuario"); //Definición del primer elemento dentro del elemento coche
                    Text textoNombreUsuarioXML = miDocumento.createTextNode(nombreUsuario); //Definición del valor del elemento creado
                    nombreUsuarioXML.appendChild(textoNombreUsuarioXML); //Asignación del valor al elemento
                    usuarioXML.appendChild(nombreUsuarioXML); //Asignación del elemento al elemento "global"

                    Element apellidoUsuarioXML = miDocumento.createElement("apellido_usuario"); //Definición del segundo elemento dentro del elemento coche
                    Text textoApellidoUsuarioXML = miDocumento.createTextNode(apellidoUsuario); //Definición del valor del elemento creado
                    apellidoUsuarioXML.appendChild(textoApellidoUsuarioXML); //Asignación del valor al elemento
                    usuarioXML.appendChild(apellidoUsuarioXML); //Asignación del elemento al elemento "global"

                    Element nombreLibroXML = miDocumento.createElement("nombre_libro"); //Definición del segundo elemento dentro del elemento coche
                    Text textoNombreLibroXML = miDocumento.createTextNode(nombreLibro); //Definición del valor del elemento creado
                    nombreLibroXML.appendChild(textoNombreLibroXML); //Asignación del valor al elemento
                    usuarioXML.appendChild(nombreLibroXML); //Asignación del elemento al elemento "global"

                    usuariosXML.appendChild(usuarioXML); //Asignación del elemento "global" a la raíz
                    miDocumento.getDocumentElement().appendChild(usuariosXML); //Asignación de la raíz al documento
                }
            } catch (EOFException e) {
                System.out.println("Se ha terminado de leer el fichero");
            }

            Source source = new DOMSource(miDocumento);
            Result resultado = new StreamResult(new File(Datos.RUTA_SANCIONES_XML));
            Transformer miTransformer = TransformerFactory.newInstance().newTransformer();
            miTransformer.transform(source, resultado);


            System.out.println("\n============= Comprobamos que la base de datos se ha creado bien =============\n");

            Objects<Sancion> sanciones = odb.getObjects(Sancion.class);
            for (Sancion sancion : sanciones) {
                System.out.println("Nombre libro --> " + sancion.nombreLibro);
                System.out.println("Nombre usuario --> " + sancion.nombreUsuario);
                System.out.println("Apellido usuario --> " + sancion.apellidoUsuario);
                System.out.println("Número de días con retraso --> " + sancion.numDiasRetraso);
                System.out.println();
            }

            odb.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Error al convertir la fecha");
        } catch (IOException e) {
            System.err.println("Fallo con el fichero");
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
