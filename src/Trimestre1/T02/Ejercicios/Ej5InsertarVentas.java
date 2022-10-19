package Trimestre1.T02.Ejercicios;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Ej5InsertarVentas {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner teclado = new Scanner(System.in);
        Class.forName("com.mysql.jdbc.Driver");

        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo", "root", "");
        Statement sentencia = conexion.createStatement();
        StringBuilder sql = new StringBuilder();

        System.out.println("Introduzca el id de la venta");
        int idVenta = teclado.nextInt();
        System.out.println("Introduzca la fecha de la venta (YYYY-MM-DD)");
        Date fechaVenta = Date.valueOf(teclado.next());
        System.out.println("Introduzca el id del cliente");
        int idClienteVentas = teclado.nextInt();
        System.out.println("Introduzca el id del producto");
        int idProductoVentas = teclado.nextInt();
        System.out.println("Introduzca la cantidad de las ventas");
        int cantidadVentas = teclado.nextInt();

        try {
            comprobaciónCampos(sentencia, idVenta, idClienteVentas, cantidadVentas, fechaVenta);

            sql.append("INSERT INTO VENTAS VALUES (");
            sql.append(idVenta).append(", ");
            sql.append("NOW(), ");
            sql.append(idClienteVentas).append(", ");
            sql.append(idProductoVentas).append(", ");
            sql.append(cantidadVentas).append(")");

            sentencia.execute(sql.toString());
            System.out.println("Inserción ventas --> " + sentencia.getUpdateCount());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    private static void comprobaciónCampos(Statement sentencia, int idVenta, int idClienteVentas, int cantidadVentas, Date fechaVenta) throws Exception {

        if (cantidadVentas < 0) {
            throw new Exception("La cantidad de ventas debe ser mayor que 0");
        }
        if (!String.valueOf(fechaVenta).equals(String.valueOf(Date.valueOf(LocalDate.now())))) {
            throw new Exception("La fecha introducida no coincide con la actual");
        }

        String sqlComprobacion = "SELECT * FROM VENTAS WHERE IDVENTA = " + idVenta;
        ResultSet comprobacion = sentencia.executeQuery(sqlComprobacion);

        if (comprobacion.next()) {
            throw new Exception("El id de venta ya existe");
        }

        sqlComprobacion = "SELECT * FROM CLIENTES WHERE ID = " + idClienteVentas;
        comprobacion = sentencia.executeQuery(sqlComprobacion);

        if (!comprobacion.next()) {
            throw new Exception("El id del cliente no existe");
        }

        sqlComprobacion = "SELECT * FROM PRODUCTOS WHERE ID = " + idClienteVentas;
        comprobacion = sentencia.executeQuery(sqlComprobacion);

        if (!comprobacion.next()) {
            throw new Exception("El id del producto no existe");
        }

    }
}
