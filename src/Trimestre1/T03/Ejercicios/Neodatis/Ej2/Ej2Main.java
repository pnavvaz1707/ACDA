package Trimestre1.T03.Ejercicios.Neodatis.Ej2;

import Trimestre1.T03.Clase.JugadorEjemplo;
import Trimestre1.T03.Ejercicios.Db4o.Ej2.Ej2JugadorD;
import Trimestre1.T03.Ejercicios.Db4o.Ej2.Ej2PaisD;
import Trimestre1.T03.Ejercicios.Neodatis.Ej2.Clases.Ej2Jugador;
import Trimestre1.T03.Ejercicios.Neodatis.Ej2.Clases.Ej2Pais;
import Trimestre1.Utilidades;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import java.util.Scanner;

public class Ej2Main {
    final static String[] MENU_OPCIONES = {
            "Insertar jugador",
            "Insertar pais",
            "Consultar datos",
            "Consultar jugador por deporte",
            "Salir"
    };

    public static void main(String[] args) {
        ODB odb = ODBFactory.open("src/Trimestre1/T03/Ejercicios/Neodatis/Ej2/DBs/EQUIPOS.NEO");
        Scanner teclado = new Scanner(System.in);
        int respuesta;
        do {
            Utilidades.crearMenu(MENU_OPCIONES);
            respuesta = Utilidades.solicitarEnteroEnUnRango(1, MENU_OPCIONES.length, "Introduce una opción");
            Utilidades.imprimirOpcion(MENU_OPCIONES[respuesta - 1]);
            switch (respuesta) {
                case 1 -> {
                    System.out.println("Introduce el nombre del jugador");
                    String nombre = teclado.nextLine();

                    System.out.println("Introduce el deporte del jugador");
                    String deporte = teclado.nextLine();

                    System.out.println("Introduce la ciudad del jugador");
                    String ciudad = teclado.nextLine();

                    System.out.println("Introduce la edad del jugador");
                    int edad = teclado.nextInt();

                    System.out.println("Introduce el id del pais");
                    int idPais = teclado.nextInt();
                    teclado.nextLine();

                    System.out.println("Introduce el nombre de pais");
                    String nombrePais = teclado.nextLine();

                    Ej2Jugador jugador = new Ej2Jugador(nombre, deporte, ciudad, edad, new Ej2PaisD(idPais, nombrePais));
                    odb.store(jugador);
                }
                case 2 -> {
                    System.out.println("Introduce el id del pais");
                    int idPais = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Introduce el nombre de pais");
                    String nombrePais = teclado.nextLine();

                    Ej2Pais pais = new Ej2Pais(idPais, nombrePais);
                    odb.store(pais);
                }
                case 3 -> {

                    System.out.println("////////////////////// JUGADORES //////////////////////");

                    Objects<Ej2Jugador> objects = odb.getObjects(Ej2Jugador.class);

                    int i = 1;
                    for (Ej2Jugador object : objects) {
                        System.out.printf("%d: %s, %s, %s, %d, %s %n", i++, object.getNombre(), object.getDeporte(), object.getCiudad(), object.getEdad(), object.getPais());
                    }

                    System.out.println("////////////////////// PAISES //////////////////////");

                    Objects<Ej2Pais> paises = odb.getObjects(Ej2Pais.class);

                    i = 1;
                    for (Ej2Pais object : paises) {
                        System.out.printf("%d: %d, %s %n", i++, object.getId(), object.getNombrepais());
                    }
                }
                case 4 -> {
                    System.out.println("¿Cuál deporte deseas filtrar?");
                    String deporte = teclado.nextLine();

                    IQuery query = new CriteriaQuery(Ej2Jugador.class, Where.equal("deporte", deporte));

                    Objects<Ej2Jugador> objects = odb.getObjects(query);

                    int i = 1;
                    for (Ej2Jugador object : objects) {
                        System.out.printf("%d: %s, %s, %s, %d, %s %n", i++, object.getNombre(), object.getDeporte(), object.getCiudad(), object.getEdad(), object.getPais());
                    }
                }
            }
        } while (respuesta != 5);
        odb.close();
    }
}
