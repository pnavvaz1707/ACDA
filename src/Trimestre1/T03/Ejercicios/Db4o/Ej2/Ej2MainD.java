package Trimestre1.T03.Ejercicios.Db4o.Ej2;

import Trimestre1.Utilidades;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

import java.util.Scanner;

public class Ej2MainD {
    final static String BD = "src/Trimestre1/T03/DBs/EQUIPOS.YAP";

    final static String[] MENU_OPCIONES = {
            "Insertar jugador",
            "Insertar pais",
            "Consultar datos",
            "Consultar jugador por deporte",
            "Salir"
    };

    public static void main(String[] args) {
        ObjectContainer db = Db4oEmbedded.openFile(BD);
        Scanner teclado = new Scanner(System.in);
        int respuesta;
        do {
            Utilidades.crearMenu(MENU_OPCIONES);
            respuesta = Utilidades.solicitarEnteroEnUnRango(0, MENU_OPCIONES.length - 1, "Introduce una opción");
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

                    System.out.println("Introduce el nombre de pais");
                    String nombrePais = teclado.nextLine();

                    Ej2JugadorD jugador = new Ej2JugadorD(nombre, deporte, ciudad, edad, new Ej2PaisD(idPais, nombrePais));
                    db.store(jugador);
                }
                case 2 -> {

                }
                case 3 -> {


                }
                case 4 -> {

                }
            }
            db.close();
        } while (respuesta != 0);
    }
}
