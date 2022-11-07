package Trimestre1.T03.Ejercicios.Db4o.Ej1;

import Trimestre1.Colores;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

import java.util.Scanner;

public class Ej1Main {

    final static String BD = "src/Trimestre1/T03/DBs/EMPLEDEP.YAP";

    final static String[] MENU_OPCIONES = {
            "Insertar registros",
            "Eliminar registros",
            "Actualizarlos",
            "Salir"
    };

    public static void main(String[] args) {
        ObjectContainer db = Db4oEmbedded.openFile(BD);
        Scanner teclado = new Scanner(System.in);
        String respuesta;
        do {
            crearMenu();
            respuesta = teclado.next();
            teclado.nextLine();

            switch (respuesta) {
                case "1" -> {
                    imprimirOpcion(respuesta);

                    System.out.println("Introduce el nombre del empleado");
                    String nombre = teclado.nextLine();

                    System.out.println("Indica el número de departamento al que está asociado");
                    int numDpto = teclado.nextInt();

                    Ej1Empleado empleado = new Ej1Empleado(nombre, numDpto);
                    db.store(empleado);

                    System.out.println("Introduce el número de departamento");
                    numDpto = teclado.nextInt();

                    System.out.println("Indica el nombre del departamento");
                    nombre = teclado.nextLine();

                    Ej1Departamento departamento = new Ej1Departamento(numDpto, nombre);
                    db.store(departamento);
                }
                case "2" -> {
                    imprimirOpcion(respuesta);

                }
                case "3" -> {
                    imprimirOpcion(respuesta);
                }
                case "0" -> {
                    Colores.imprimirVerde("Has salido del programa con éxito");
                }
                default -> Colores.imprimirRojo("Debes introducir un número asociado a alguna opción");
            }
            db.close();
        } while (!respuesta.equals("0"));
    }

    private static void crearMenu() {
        for (int i = 0; i < MENU_OPCIONES.length - 1; i++) {
            Colores.imprimirAzul((i + 1) + ". " + MENU_OPCIONES[i]);
        }
        Colores.imprimirAzul("0. " + MENU_OPCIONES[MENU_OPCIONES.length - 1]);
    }

    private static void imprimirOpcion(String eleccion) {
        Colores.imprimirAzul("Has seleccionado " + MENU_OPCIONES[Integer.parseInt(eleccion) - 1]);
    }
}
