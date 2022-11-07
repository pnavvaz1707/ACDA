package Trimestre1.T03.Clase;

import Trimestre1.Rutas;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class EjemploConsulta {
    public static void main(String[] args) {
        ODB odb = ODBFactory.open(Rutas.RUTA_JUGADORES_NEODATIS);


        IQuery query = new CriteriaQuery(JugadorEjemplo.class, Where.equal("deporte","tenis"));
        query.orderByAsc("nombre,edad");

        Objects<JugadorEjemplo> objects = odb.getObjects(query);
        System.out.printf("%d Jugadores: %n", objects.size());

        int i = 1;
        for (JugadorEjemplo object : objects) {
            System.out.printf("%d: %s, %s, %s, %d %n", i++, object.getNombre(), object.getDeporte(), object.getCiudad(), object.getEdad());
        }
        odb.close();
    }
}
