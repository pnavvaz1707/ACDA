package Trimestre1.T03.Clase;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class E1LeerDatos {
    final static String BDPer = "C:/Users/pablo/Downloads/DBE1Persona.yap";

    public static void main(String[] args) {
        ObjectContainer db = Db4oEmbedded.openFile(BDPer);

        //LEER TODOS LOS REGISTROS
        System.out.println("Todas las personas son:");

        E1Persona per = new E1Persona(null, null);
        prueba(db,per);

        //LEER SÓLO LOS REGISROS DE AQUELLOS LLAMADOS Enrique
        System.out.println("Todos los Enrique son...");

        per = new E1Persona("Enrique", null);
        prueba(db, per);

        //LEER SÓLO LOS REGISTROS DE AQUELLAS PERSONAS QUE VIVAN EN Madrid
        System.out.println("En Guadalajara viven...");

        per = new E1Persona(null, "Guadalajara");
        prueba(db, per);
        //CIERRA LA BASE DE DATOS
        db.close();
    }

    private static void prueba(ObjectContainer db, E1Persona per) {
        ObjectSet<E1Persona> result;
        result = db.queryByExample(per);

        if (result.size() == 0) {
            System.out.println("No existen Registros de Personas.. ");

        } else {
            System.out.println("Número de registros: " + result.size());

            while (result.hasNext()) {
                E1Persona p = result.next();
                System.out.println("Nombre: " + p.getNombre() + ", Ciudad:" + p.getCiudad());
            }
        }
    }
}
