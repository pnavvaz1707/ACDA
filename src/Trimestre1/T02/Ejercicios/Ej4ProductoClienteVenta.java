package Trimestre1.T02.Ejercicios;

import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class Ej4ProductoClienteVenta {
    public static void main(String[] args) {
        try {
            Scanner teclado = new Scanner(System.in);
            Class.forName("com.mysql.jdbc.Driver");

            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo", "root", "");
            Statement sentencia = conexion.createStatement();
            StringBuilder sql = new StringBuilder();

            imprimirTitulo("TABLA PRODUCTOS");

            System.out.println("Introduzca el id");
            int idProducto = teclado.nextInt();
            System.out.println("Introduzca la descripción");
            String descProducto = teclado.next();
            System.out.println("Introduzca el stock actual");
            int stockActual = teclado.nextInt();
            System.out.println("Introduzca el stock mínimo");
            int stockMinimo = teclado.nextInt();
            System.out.println("Introduzca el pvp");
            int pvp = teclado.nextInt();

            sql.append("INSERT INTO PRODUCTOS VALUES (");
            sql.append(idProducto).append(", ");
            sql.append("'").append(descProducto).append("', ");
            sql.append(stockActual).append(", ");
            sql.append(stockMinimo).append(", ");
            sql.append(pvp).append(")");

            System.out.println("Inserción productos --> " + sentencia.execute(sql.toString()));

            imprimirTitulo("TABLA CLIENTES");

            sql = new StringBuilder();

            System.out.println("Introduzca el id");
            int idCliente = teclado.nextInt();
            System.out.println("Introduzca el nombre");
            String nombreCliente = teclado.next();
            System.out.println("Introduzca la dirección");
            String direccionCliente = teclado.next();
            teclado.nextLine();
            System.out.println("Introduzca el población");
            String poblacionCliente = teclado.next();
            System.out.println("Introduzca el teléfono");
            String telefonoCliente = teclado.next();
            System.out.println("Introduzca el nif");
            String nifCliente = teclado.next();

            sql.append("INSERT INTO CLIENTES VALUES (");
            sql.append(idCliente).append(", ");
            sql.append("'").append(nombreCliente).append("', ");
            sql.append("'").append(direccionCliente).append("', ");
            sql.append("'").append(poblacionCliente).append("', ");
            sql.append("'").append(telefonoCliente).append("', ");
            sql.append("'").append(nifCliente).append("')");

            System.out.println("Inserción clientes --> " + sentencia.execute(sql.toString()));

            imprimirTitulo("TABLA VENTAS");

            sql = new StringBuilder();

            System.out.println("Introduzca el id de la venta");
            int idVenta = teclado.nextInt();
            System.out.println("Introduzca el id del cliente");
            int idClienteVentas = teclado.nextInt();
            System.out.println("Introduzca el id del producto");
            int idProductoVentas = teclado.nextInt();
            System.out.println("Introduzca la cantidad de las ventas");
            int cantidadVentas = teclado.nextInt();

            sql.append("INSERT INTO VENTAS VALUES (");
            sql.append(idVenta).append(", ");
            sql.append("NOW(), ");
            sql.append(idClienteVentas).append(", ");
            sql.append(idProductoVentas).append(", ");
            sql.append(cantidadVentas).append(")");

            System.out.println("Inserción ventas --> " + sentencia.execute(sql.toString()));

            sql = new StringBuilder();
            sql.append("SELECT * FROM PRODUCTOS");
            ResultSet rs = sentencia.executeQuery(sql.toString());
            while (rs.next()) {
                System.out.println("ID --> " + rs.getInt(1));
                System.out.println("DESCRIPCION --> " + rs.getString(2));
                System.out.println("STOCK ACTUAL --> " + rs.getInt(3));
                System.out.println("STOCK MINIMO --> " + rs.getInt(4));
                System.out.println("PVP --> " + rs.getInt(5));
            }

            sql = new StringBuilder();
            sql.append("SELECT * FROM CLIENTES");
            rs = sentencia.executeQuery(sql.toString());
            while (rs.next()) {
                System.out.println("ID --> " + rs.getInt(1));
                System.out.println("NOMBRE --> " + rs.getString(2));
                System.out.println("DIRECCION --> " + rs.getString(3));
                System.out.println("POBLACION --> " + rs.getString(4));
                System.out.println("TELEFONO --> " + rs.getString(5));
                System.out.println("NIF --> " + rs.getString(6));
            }

            sql = new StringBuilder();
            sql.append("SELECT * FROM VENTAS");
            rs = sentencia.executeQuery(sql.toString());
            while (rs.next()) {
                System.out.println("ID --> " + rs.getInt(1));
                System.out.println("FECHA VENTA --> " + rs.getString(2));
                System.out.println("ID CLIENTE --> " + rs.getInt(3));
                System.out.println("ID PRODUCTO --> " + rs.getInt(4));
                System.out.println("CANTIDAD VENTAS --> " + rs.getInt(5));
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void imprimirTitulo(String msg) {
        System.out.println("------------------------------- " + msg + " -------------------------------");
    }
}
