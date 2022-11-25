package Trimestre1.T03.Clase;

import Trimestre1.Rutas;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.oid.OIDFactory;

public class EjemploOID {
    public static void main(String[] args) {
        ODB odb = ODBFactory.open(Rutas.RUTA_JUGADORES_NEODATIS);
        OID oid = OIDFactory.buildObjectOID(5);

        JugadorEjemplo jug = (JugadorEjemplo) odb.getObjectFromId(oid);
        System.out.println(jug.getNombre() + "*" + jug.getDeporte() + "*" + jug.getCiudad() + "*" + jug.getEdad());
        odb.delete(jug);

        Objects<JugadorEjemplo> objects = odb.getObjects(JugadorEjemplo.class);
        int i = 1;
        for (JugadorEjemplo object : objects) {
            System.out.printf("%d: %s, %s, %s, %d %n", i++, object.getNombre(), object.getDeporte(), object.getCiudad(), object.getEdad());
        }
        System.out.println("///////////// COMMIT /////////////");
        odb.commit();
        objects = odb.getObjects(JugadorEjemplo.class);
        i = 1;
        for (JugadorEjemplo object : objects) {
            System.out.printf("%d: %s, %s, %s, %d %n", i++, object.getNombre(), object.getDeporte(), object.getCiudad(), object.getEdad());
        }
        odb.close();
    }
}
