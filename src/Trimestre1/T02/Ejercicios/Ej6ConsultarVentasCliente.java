package Trimestre1.T02.Ejercicios;

import java.sql.*;
import java.util.Scanner;

public class Ej6ConsultarVentasCliente {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner teclado = new Scanner(System.in);
        Class.forName("com.mysql.jdbc.Driver");

        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo", "root", "");
        Statement sentencia = conexion.createStatement();
        Statement sentencia2 = conexion.createStatement();

        StringBuilder sql = new StringBuilder();

        System.out.println("Introduzca el id");
        int idCliente = teclado.nextInt();

        sql.append("SELECT NOMBRE FROM CLIENTES WHERE ID = ").append(idCliente);
        ResultSet rs = sentencia.executeQuery(sql.toString());

        int totalVentas = 0;
        int totalImporte = 0;
        if (rs.next()) {

            System.out.println("Ventas del cliente : " + rs.getString(1));
            ResultSet ventasCliente = sentencia.executeQuery("SELECT IDVENTA,IDPRODUCTO,CANTIDAD FROM VENTAS WHERE IDCLIENTE = " + idCliente);

            while (ventasCliente.next()) {
                System.out.println("Venta : " + ventasCliente.getInt(1));

                ResultSet productoVentas = sentencia2.executeQuery("SELECT DESCRIPCION,PVP FROM PRODUCTOS WHERE ID = " + ventasCliente.getInt(2));
                productoVentas.next();

                System.out.println("\tProducto: " + productoVentas.getString(1) + " - PVP: " + productoVentas.getInt(2));
                System.out.println("\tCantidad: " + ventasCliente.getInt(3));
                int importe = (ventasCliente.getInt(3) * productoVentas.getInt(2));
                System.out.println("\tImporte: " + importe);
                totalVentas++;
                totalImporte += importe;
            }
            System.out.println("Total ventas: " + totalVentas);
            System.out.println("Total importe: " + totalImporte);
        }else {
            System.err.println("El cliente no existe");
        }
    }
}
