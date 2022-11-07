package Trimestre1.T03.Clase;

import Trimestre1.Rutas;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class EjemploModificarNeodatis {
    public static void main(String[] args) {
        ODB odb = ODBFactory.open(Rutas.RUTA_JUGADORES_NEODATIS);

        IQuery query = new CriteriaQuery(JugadorEjemplo.class, Where.equal("nombre","Alicia"));

        Objects<JugadorEjemplo> objects = odb.getObjects(query);
        JugadorEjemplo jug = (JugadorEjemplo) objects.getFirst();

        jug.setDeporte("Equitación");
        odb.store(jug);

        int i = 1;
        for (JugadorEjemplo object : objects) {
            System.out.printf("%d: %s, %s, %s, %d %n", i++, object.getNombre(), object.getDeporte(), object.getCiudad(), object.getEdad());
        }
        odb.commit();
        odb.close();
    }
}
