package Trimestre1.T03.Clase;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class E1EliminarDatos {
    final static String BDPer = "C:/Users/pablo/Downloads/DBE1Persona.yap";

    public static void main(String[] args) {
        ObjectContainer db = Db4oEmbedded.openFile(BDPer);

        //ELIMINAR LOS REGISTROS DE JUAN
        E1Persona perJuan = new E1Persona("Juan", null);
        ObjectSet<E1Persona> resultJuan = db.queryByExample(perJuan);

        if (resultJuan.size() == 0) {
            System.out.println("No existen Juan...");
        } else {
            E1Persona existe = (E1Persona) resultJuan.next();
            System.out.println("Registros a borrar: " + resultJuan.size());

            if (resultJuan.size() > 1) {
                while (resultJuan.hasNext()) {
                    E1Persona p = resultJuan.next();
                    db.delete(p);
                    System.out.println("Borrado...");
                }
            } else {
                db.delete(existe); //sólo hay un registro
            }
        }
        //CIERRA LA BASE DE DATOS
        db.close();
    }
}
