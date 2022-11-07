package Trimestre1.T03.Clase;

import Trimestre1.Rutas;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class EjemploNeodatis {
    public static void main(String[] args) {
        JugadorEjemplo j1 = new JugadorEjemplo("María", "voleibol", "Madrid", 14);
        JugadorEjemplo j2 = new JugadorEjemplo("Miguel", "tenis", "Madrid", 15);
        JugadorEjemplo j3 = new JugadorEjemplo("Mario", "baloncesto", "Guadalajara", 15);
        JugadorEjemplo j4 = new JugadorEjemplo("Alicia", "tenis", "Madrid", 14);

        ODB odb = ODBFactory.open(Rutas.RUTA_JUGADORES_NEODATIS);

        odb.store(j1);
        odb.store(j2);
        odb.store(j3);
        odb.store(j4);

        Objects<JugadorEjemplo> objects = odb.getObjects(JugadorEjemplo.class);
        System.out.printf("%d Jugadores: %n", objects.size());

        int i = 1;
        for (JugadorEjemplo object : objects) {
            System.out.printf("%d: %s, %s, %s, %d %n", i++, object.getNombre(), object.getDeporte(), object.getCiudad(), object.getEdad());
        }
        odb.close();
    }
}
