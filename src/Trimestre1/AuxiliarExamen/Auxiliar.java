package Trimestre1.AuxiliarExamen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase donde almaceno métodos útiles para la aplicación entero
 */
public class Auxiliar {

    /**
     * Cadena que indica el formato que deben cumplir las fechas
     */
    private static final String formato = "dd/MM/yyyy";

    /**
     * Objeto tipo SimpleDateFormat que permite formatear las fechas según el formato indicado
     */
    private static final SimpleDateFormat formatter = new SimpleDateFormat(formato);

    /**
     * Lista de opciones que contiene el menú de la aplicación
     */
    static String[] MENU_OPCIONES = {
            "Pasar base de datos de SQL a Neodatis",
            "Registrar un libro",
            "Eliminar un usuario",
            "Modificar un préstamo",
            "Ver los préstamos entregados tarde por un usuario específico",
            "Ver los libros de un género y precio determinados",
            "Ver los préstamos realizados en una provincia y período de tiempo determinados",
            "Salir"
    };

    /**
     * Método para crear el menú según las opciones pasadas por parámetro
     *
     * @param MENU_OPCIONES (Lista de opciones a imprimir como menú)
     */
    public static void crearMenu(String[] MENU_OPCIONES) {
        for (int i = 0; i < MENU_OPCIONES.length; i++) {
            System.out.println((i + 1) + ". " + MENU_OPCIONES[i]);
        }
    }

    /**
     * Método para solicitar al usuario un número entero en un rango determinado
     *
     * @param limiteInferior (Límite inferior del rango que debe cumplir el número solicitado al usuario)
     * @param limiteSuperior (Límite superior del rango que debe cumplir el número solicitado al usuario)
     * @param msg            (Pregunta que le realizará al programa al usuario para pedirle el número)
     * @return (Devuelve el número introducido por el usuario)
     */
    public static int solicitarEnteroEnUnRango(int limiteInferior, int limiteSuperior, String msg) {
        Scanner teclado = new Scanner(System.in);
        boolean sigue = true;
        int num = 0;

        while (sigue) {
            try {
                System.out.println(msg);
                num = teclado.nextInt();

                if (num < limiteInferior || num > limiteSuperior) {
                    throw new Exception("El número debe estar comprendido en el siguiente rango [" + limiteInferior + "," + limiteSuperior + "]");
                }
                sigue = false;

            } catch (InputMismatchException e) {
                System.err.println("Debe introducir un número entero");

            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return num;
    }

    /**
     * Método para solicitar al usuario una cadena de texto
     *
     * @param msg (Pregunta que le realizará al programa al usuario para pedirle la cadena de texto)
     * @return (Devuelve la cadena de texto introducida por el usuario)
     */
    public static String leerCadena(String msg) {
        Scanner teclado = new Scanner(System.in);
        String respuesta = "";
        boolean sigue = true;

        while (sigue) {
            try {
                System.out.println(msg);
                respuesta = teclado.nextLine();

                if (respuesta.equals("")) {
                    throw new Exception("No puedes dejar el campo vacío");
                }
                sigue = false;

            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return respuesta;
    }

    /**
     * Método para solicitar al usuario un número tipo double en un rango determinado
     *
     * @param limiteInferior (Límite inferior del rango que debe cumplir el número solicitado al usuario)
     * @param limiteSuperior (Límite superior del rango que debe cumplir el número solicitado al usuario)
     * @param msg            (Pregunta que le realizará al programa al usuario para pedirle el número)
     * @return (Devuelve el número introducido por el usuario)
     */
    public static double solicitarDoubleEnUnRango(double limiteInferior, double limiteSuperior, String msg) {
        Scanner teclado = new Scanner(System.in);
        boolean sigue = true;
        double num = 0;

        while (sigue) {
            try {
                System.out.println(msg);

                num = teclado.nextDouble();
                if (num < limiteInferior || num > limiteSuperior) {
                    throw new Exception("El número debe estar comprendido en el siguiente rango [" + limiteInferior + "," + limiteSuperior + "]");
                }
                sigue = false;

            } catch (InputMismatchException e) {
                System.err.println("Debe introducir un número (si es decimal debe llevar el separador ',')");

            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return num;
    }

    /**
     * Método que pregunta al usuario si desea ver los siguientes 10 elementos
     *
     * @return (Devuelve un booleano de valor true si el usuario desea seguir o false si no lo desea)
     */
    public static boolean sigPagina() {
        Scanner teclado = new Scanner(System.in);
        boolean sigue;
        boolean sigPagina = false;

        do {
            System.out.println("¿Desea ver los siguientes 10 números?");
            String respuesta = teclado.nextLine().toLowerCase();

            if (respuesta.equals("si") || respuesta.equals("sí")) {
                sigPagina = true;
                sigue = false;

            } else if (respuesta.equals("no")) {
                sigue = false;

            } else {
                System.err.println("Debe introducir la palabra 'si' o 'no'");
                sigue = true;
            }
        } while (sigue);

        return sigPagina;
    }

    /**
     * Método para leer una fecha por teclado y que cumpla el formato indicado
     *
     * @return (Devuelve la fecha en tipo String para poder almacenarla en la base de datos)
     */
    public static Date solicitarFecha(String msg) {
        Scanner teclado = new Scanner(System.in); //Escáner para leer por teclado la fecha

        //Declaramos las variables que vamos a usar
        Date fecha = null;
        boolean sigue = true;

        while (sigue) {
            try {
                System.out.println(msg);

                String fechaTeclado = teclado.nextLine();
                fecha = formatter.parse(fechaTeclado);

                sigue = false;
            } catch (ParseException e) {
                System.err.println("La fecha introducida es incorrecta, debe cumplir el formato (" + formato + ")");
            }
        }
        return fecha;
    }

    public static void main(String[] args) {
        int respuesta;
        do {
            //Creamos el menú y solicitamos al usuario que seleccione una opción
            Auxiliar.crearMenu(MENU_OPCIONES);
            respuesta = Auxiliar.solicitarEnteroEnUnRango(1, MENU_OPCIONES.length, "Seleccione una opción");
            System.out.println("Has seleccionado --> " + MENU_OPCIONES[respuesta - 1]);

            switch (respuesta) {
                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    break;
            }
        } while (respuesta != MENU_OPCIONES.length);
        System.out.println("Has salido del programa con éxito");
    }
}
