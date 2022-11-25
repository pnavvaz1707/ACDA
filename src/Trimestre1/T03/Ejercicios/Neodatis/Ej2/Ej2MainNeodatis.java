package Trimestre1.T03.Ejercicios.Neodatis.Ej2;

import Trimestre1.Colores;
import Trimestre1.T03.Ejercicios.Neodatis.Ej2.Clases.Ej2Jugador;
import Trimestre1.T03.Ejercicios.Neodatis.Ej2.Clases.Ej2Pais;
import Trimestre1.Utilidades;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import java.util.Scanner;

public class Ej2MainNeodatis {
    final static String[] MENU_OPCIONES = {
            "Insertar jugador",
            "Insertar pais",
            "Consultar datos",
            "Consultar jugador por deporte",
            "Salir"
    };
    static Scanner teclado = new Scanner(System.in);
    static ODB odb = ODBFactory.open("src/Trimestre1/T03/Ejercicios/Neodatis/Ej2/DBs/EQUIPOS.NEO");
    static Objects<Ej2Pais> paises = odb.getObjects(Ej2Pais.class);

    public static void main(String[] args) {
        int respuesta;
        do {
            Utilidades.crearMenu(MENU_OPCIONES);
            respuesta = Utilidades.solicitarEnteroEnUnRango(1, MENU_OPCIONES.length, "Introduce una opción");
            Utilidades.imprimirOpcion(MENU_OPCIONES[respuesta - 1]);

            switch (respuesta) {
                case 1 -> {
                    if (paises.size() == 0) {
                        Colores.imprimirRojo("Debes crear un país nuevo antes de crear un jugador");
                    } else {
                        odb.store(crearJugador());
                        odb.commit();
                    }
                }
                case 2 -> {
                    Ej2Pais pais = crearPais();
                    paises.add(pais);
                    odb.store(pais);
                    odb.commit();
                }
                case 3 -> {

                    System.out.println("////////////////////// JUGADORES //////////////////////");

                    Objects<Ej2Jugador> objects = odb.getObjects(Ej2Jugador.class);

                    int i = 1;
                    for (Ej2Jugador object : objects) {
                        System.out.printf("%d: %s, %s, %s, %d, %s %n", i++, object.getNombre(), object.getDeporte(), object.getCiudad(), object.getEdad(), object.getPais());
                    }

                    System.out.println("////////////////////// PAISES //////////////////////");

                    i = 1;
                    for (Ej2Pais object : paises) {
                        System.out.printf("%d: %d, %s %n", i++, object.getId(), object.getNombrepais());
                    }
                }
                case 4 -> {
                    System.out.println("¿Cuál deporte deseas filtrar?");
                    String deporte = teclado.nextLine();

                    ICriterion criterion = Where.equal("deporte", deporte);
                    IQuery query = new CriteriaQuery(Ej2Jugador.class, criterion);

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

    private static Ej2Jugador crearJugador() {
        System.out.println("Introduce el nombre del jugador");
        String nombre = teclado.nextLine();

        System.out.println("Introduce el deporte del jugador");
        String deporte = teclado.nextLine();

        System.out.println("Introduce la ciudad del jugador");
        String ciudad = teclado.nextLine();

        System.out.println("Introduce la edad del jugador");
        int edad = teclado.nextInt();

        return new Ej2Jugador(nombre, deporte, ciudad, edad, solicitarPais());
    }

    private static Ej2Pais crearPais() {
        boolean sigue = true;
        int idPais = 0;
        String nombrePais = "";
        while (sigue) {
            try {
                System.out.println("Introduce el id del país");
                idPais = teclado.nextInt();
                teclado.nextLine();

                System.out.println("Introduce el nombre de país");
                nombrePais = teclado.nextLine();

                for (Ej2Pais pais : paises) {
                    if (pais.getId() <= 0) {
                        throw new Exception("El id del país no puede ser menor o igual que 0");
                    } else if (pais.getId() == idPais) {
                        throw new Exception("El id del país ya existe");
                    } else if (pais.getNombrepais().equals(nombrePais)) {
                        throw new Exception("El nombre de este país ya existe");
                    }
                }
                sigue = false;
            } catch (Exception e) {
                Colores.imprimirRojo(e.getMessage());
            }
        }
        return new Ej2Pais(idPais, nombrePais);
    }

    private static Ej2Pais solicitarPais() {
        boolean sigue = true;
        Ej2Pais pais = null;
        while (sigue) {
            try {
                System.out.println("Introduce el id del país");
                int id = teclado.nextInt();

                IQuery query = new CriteriaQuery(Ej2Pais.class, Where.equal("id", id));

                pais = (Ej2Pais) odb.getObjects(query).getFirst();
                System.out.println("Has seleccionado: " + pais.getNombrepais());

                sigue = false;
            } catch (IndexOutOfBoundsException e) {
                Colores.imprimirRojo("No existe ese pais");
            } catch (Exception e) {
                Colores.imprimirRojo(e.getMessage());
            }
        }
        return pais;
    }
}
