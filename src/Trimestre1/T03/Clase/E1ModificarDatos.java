package Trimestre1.T03.Clase;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class E1ModificarDatos {
    final static String BDPer = "C:/Users/pablo/Downloads/DBE1Persona.yap";

    public static void main(String[] args) {
        ObjectContainer db = Db4oEmbedded.openFile(BDPer);
        //CAMBIAR LA CIUDAD DONDE VIVE JUAN POR TOLEDO

        E1Persona perJuan = new E1Persona("Juan", null);
        ObjectSet<E1Persona> resultJuan = db.queryByExample(perJuan);

        if (resultJuan.size() == 0) {
            System.out.println("No existen Juan...");
        } else {
            E1Persona existe = (E1Persona) resultJuan.next();
            existe.setCiudad("Toledo");
            db.store(existe); //ciudad modificada

            //consultar los datos
            ObjectSet<E1Persona> result = db.queryByExample(new E1Persona(null, null));
            while (result.hasNext()) {
                E1Persona p = result.next();
                System.out.println("Nombre: " + p.getNombre() + ", Ciudad:" + p.getCiudad());
            }
        }
        //CIERRA LA BASE DE DATOS
        db.close();
    }
}
