package Trimestre1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilidades {

    public static void crearMenuCon0(String[] MENU_OPCIONES) {
        for (int i = 0; i < MENU_OPCIONES.length - 1; i++) {
            Colores.imprimirAzul((i + 1) + ". " + MENU_OPCIONES[i]);
        }
        Colores.imprimirAzul("0. " + MENU_OPCIONES[MENU_OPCIONES.length - 1]);
    }
    public static void crearMenu(String[] MENU_OPCIONES) {
        for (int i = 0; i < MENU_OPCIONES.length; i++) {
            Colores.imprimirAzul((i + 1) + ". " + MENU_OPCIONES[i]);
        }
    }

    public static void imprimirOpcion(String opcion) {
        Colores.imprimirAzul("Has seleccionado " + opcion);
    }

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
                Colores.imprimirRojo("Debe introducir un número entero");
                teclado.nextLine();

            } catch (Exception e) {
                Colores.imprimirRojo(e.getMessage());
            }
        }
        return num;
    }
}
