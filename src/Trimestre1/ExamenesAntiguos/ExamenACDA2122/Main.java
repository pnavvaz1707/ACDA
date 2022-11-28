package Trimestre1.ExamenesAntiguos.ExamenACDA2122;

import Trimestre1.AuxiliarExamen.Auxiliar;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import java.io.*;
import java.sql.*;
import java.time.LocalDate;

public class Main {

    private static final String[] MENU_OPCIONES = {
            "Volcar datos del fichero \"nuevosHermanos.txt\"", // case 1
            "Mostrar listado de las procesiones del Jueves Santo", //case 2
            "Obtener número de hermanos que procesionan cada día de la Semana Santa", //case 3
            "Actualizar el párroco de las iglesias de aquellas cofradías que pertenecen al distrito centro como " +
                    "“Jesús Catalá”", //case 4
            "Crear una base de datos orientada a objetos en Neodatis llamada hermandades.neo", //case 5
            "Crear un fichero de objetos con el nombre hermandad.obj", //case 6
            "Visualizar los datos del fichero anteriormente creado por pantalla", //case 7
            "Salir" //case 8
    };

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/" + Datos.DB_NAME, Datos.DB_USER, Datos.DB_PASSWORD);
            Statement sentencia = conexion.createStatement();
            int respuesta;
            do {
                //Creamos el menú y solicitamos al usuario que seleccione una opción
                Auxiliar.crearMenu(MENU_OPCIONES);
                respuesta = Auxiliar.solicitarEnteroEnUnRango(1, MENU_OPCIONES.length, "Seleccione una opción");
                System.out.println("Has seleccionado --> " + MENU_OPCIONES[respuesta - 1]);


                switch (respuesta) {
                    case 1:
                        try {
                            File f = new File(Datos.RUTA_FICHERO_NUEVOS_HERMANOS);
                            FileReader fr = new FileReader(f);
                            BufferedReader br = new BufferedReader(fr);

                            String linea;
                            br.readLine();

                            while ((linea = br.readLine()) != null) {
                                try {
                                    String[] datos = linea.split("#");
                                    String dni = datos[0];
                                    String nombre = datos[1];
                                    String apellidos = datos[2];
                                    String direccion = datos[3];
                                    int antiguedad = LocalDate.now().getYear();
                                    int hermandad = Integer.parseInt(datos[4]);

                                    String sql = "INSERT INTO HERMANOS VALUES ('" + dni + "', '" +
                                            nombre + "', '" +
                                            apellidos + "', '" +
                                            direccion + "', " +
                                            antiguedad + ", " +
                                            hermandad + ")";

                                    System.out.println(sql);

                                    sentencia.executeUpdate(sql);
                                } catch (MySQLIntegrityConstraintViolationException e) {
                                    System.out.println("Error en la sentencia sql " + e.getMessage());
                                }
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 2:
                        String sql = "SELECT NOMBRE,VULGO,BARRIO FROM HERMANDADES WHERE DIAPROCESION = 'JUEVES SANTO'";
                        ResultSet resultSet = sentencia.executeQuery(sql);
                        while (resultSet.next()) {
                            System.out.println("Nombre: " + resultSet.getString(1));
                            System.out.println("Vulgo: " + resultSet.getString(2));
                            System.out.println("Barrio: " + resultSet.getString(3));
                        }
                        break;

                    case 3:
                        sql = "SELECT COUNT(*),DIAPROCESION FROM HERMANDADES GROUP BY DIAPROCESION";
                        resultSet = sentencia.executeQuery(sql);
                        while (resultSet.next()) {
                            System.out.println("Número de procesiones: " + resultSet.getInt(1));
                            System.out.println("Día de procesión: " + resultSet.getString(2));
                        }
                        break;

                    case 4:

                        break;

                    case 5:
                        ODB odb = ODBFactory.open(Datos.RUTA_NEODATIS_HERMANDADES);
                        sql = "SELECT * FROM HERMANOS";
                        resultSet = sentencia.executeQuery(sql);
                        while (resultSet.next()) {
                            String dni = resultSet.getString(1);
                            String nombre = resultSet.getString(2);
                            String apellidos = resultSet.getString(3);
                            String direccion = resultSet.getString(4);
                            int antiguedad = resultSet.getInt(5);
                            int hermandad = resultSet.getInt(6);

                            odb.store(new Hermanos(dni, nombre, apellidos, direccion, antiguedad, hermandad));
                            odb.commit();
                        }

                        sql = "SELECT * FROM TITULARES";
                        resultSet = sentencia.executeQuery(sql);
                        while (resultSet.next()) {
                            int codigo = resultSet.getInt(1);
                            String nombre = resultSet.getString(2);
                            String autor = resultSet.getString(3);
                            String antiguedad = resultSet.getString(4);
                            int hermandad = resultSet.getInt(5);

                            odb.store(new Titulares(codigo, nombre, autor, antiguedad, hermandad));
                            odb.commit();
                        }

                        sql = "SELECT * FROM HERMANDADES";
                        resultSet = sentencia.executeQuery(sql);
                        while (resultSet.next()) {
                            int codigo = resultSet.getInt(1);
                            String nombre = resultSet.getString(2);
                            String vulgo = resultSet.getString(3);
                            String casahermandad = resultSet.getString(4);
                            String hermanomayor = resultSet.getString(5);
                            int cuotahermano = resultSet.getInt(6);
                            int fundacion = resultSet.getInt(7);
                            String diaprocesion = resultSet.getString(8);
                            int sedecanonica = resultSet.getInt(9);
                            String barrio = resultSet.getString(10);

                            odb.store(new Hermandades(codigo, nombre, vulgo, casahermandad, hermanomayor, cuotahermano, fundacion, diaprocesion, sedecanonica, barrio));
                            odb.commit();
                        }

                        sql = "SELECT * FROM SEDESCANONICAS";
                        resultSet = sentencia.executeQuery(sql);
                        while (resultSet.next()) {
                            int codigo = resultSet.getInt(1);
                            String nombre = resultSet.getString(2);
                            String direccion = resultSet.getString(3);
                            String parroco = resultSet.getString(4);

                            odb.store(new SedesCanonicas(codigo, nombre, direccion, parroco));
                            odb.commit();
                        }
                        odb.close();
                        break;

                    case 6:
                        File f = new File(Datos.RUTA_FICHERO_BINARIO_HERMANDADES);
                        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(f));

                        odb = ODBFactory.open(Datos.RUTA_NEODATIS_HERMANDADES);

                        IQuery query = new CriteriaQuery(Hermanos.class);
                        Objects<Hermanos> hermanos = odb.getObjects(query);

                        for (Hermanos hermano : hermanos) {
                            os.writeObject(hermano);
                        }

                        query = new CriteriaQuery(Titulares.class);
                        Objects<Titulares> titulares = odb.getObjects(query);

                        for (Titulares titular : titulares) {
                            os.writeObject(titular);
                        }

                        query = new CriteriaQuery(Hermandades.class);
                        Objects<Hermandades> hermandades = odb.getObjects(query);

                        for (Hermandades hermandad : hermandades) {
                            os.writeObject(hermandad);
                        }

                        query = new CriteriaQuery(SedesCanonicas.class);
                        Objects<SedesCanonicas> sedesCanonicas = odb.getObjects(query);

                        for (SedesCanonicas sedeCanonica : sedesCanonicas) {
                            os.writeObject(sedeCanonica);
                        }
                        os.close();

                        break;

                    case 7:
                        File f1 = new File(Datos.RUTA_FICHERO_BINARIO_HERMANDADES);
                        ObjectInputStream is = new ObjectInputStream(new FileInputStream(f1));
                        try {
                            while (true) {
                                System.out.println(is.readObject().toString());
                            }
                        } catch (IOException e) {
                            System.out.println("Ha terminado de leer el fichero");
                        }
                        is.close();
                        break;
                }
            } while (respuesta != MENU_OPCIONES.length);
            System.out.println("Has salido del programa con éxito");
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
