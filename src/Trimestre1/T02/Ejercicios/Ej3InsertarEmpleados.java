package Trimestre1.T02.Ejercicios;

import Trimestre1.AuxiliarExamen.Auxiliar;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Ej3InsertarEmpleados {//del 2 al 7
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo", "root", "");
//            Statement sentencia = conexion.createStatement();
            PreparedStatement sentencia = conexion.prepareStatement("INSERT INTO EMPLEADOS VALUES(?,?,?,?,?,?,?,?)");
            int num_emp = tecladoInt("Introduce el número de empleado");
            String apellido = tecladoString("Introduce el apellido"); //no null
            String profesion = tecladoString("Introduce la profesión"); //no null
            String director = tecladoString("Introduce el apellido del director"); //debe existir
            float salario = tecladoFloat("Introduce el salario"); //mayor que 0
            float comision = tecladoFloat("Introduce la comisión"); //mayor que 0
            int depto_no = tecladoInt("Introduce el número de departamento"); // debe existir en departamentos
            java.util.Date prueba = Auxiliar.solicitarFecha("Pon la fecha");
            Date fecha = new Date(prueba.getTime());

            sentencia.setInt(1, num_emp);
            sentencia.setString(2, apellido);
            sentencia.setString(3, profesion);
            sentencia.setString(4, director);
            sentencia.setFloat(5, salario);
            sentencia.setFloat(6, comision);
            sentencia.setInt(7, depto_no);
            sentencia.setDate(8, fecha);
            sentencia.executeUpdate();


//            comprobarErrores(sentencia, num_emp, apellido, profesion, director, salario, comision, depto_no);
//
//
//            StringBuilder sql = new StringBuilder();
//            sql.append("INSERT INTO EMPLEADOS VALUES (");
//            sql.append(num_emp).append(", ");
//            sql.append("'").append(apellido).append("', ");
//            sql.append("'").append(profesion).append("', ");
//            sql.append("'").append(director).append("', ");
//            sql.append(salario).append(", ");
//            sql.append(comision).append(", ");
//            sql.append(depto_no).append(", ");
//            sql.append(fecha).append(")");
//
//            System.out.println("Sentencia --> " + sql);
//            sentencia.execute(sql.toString());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static int tecladoInt(String msg) {
        System.out.println(msg);
        return teclado.nextInt();
    }

    private static String tecladoString(String msg) {
        System.out.println(msg);
        String resultado = null;
        String respuesta = teclado.next();
        if (!respuesta.equals("-")) {
            resultado = respuesta;
        }
        return resultado;
    }

    private static float tecladoFloat(String msg) {
        System.out.println(msg);
        return teclado.nextFloat();
    }

    private static void comprobarErrores(Statement sentencia, int num_emp, String apellido, String profesion, String director, float salario, float comision, int depto_no) throws Exception {
        if (apellido == null) {
            throw new Exception("Apellido vacío");
        }
        if (profesion == null) {
            throw new Exception("Profesión vacía");
        }
        if (salario < 0) {
            throw new Exception("El salario debe ser mayor o igual que 0");
        }
        if (comision < 0) {
            throw new Exception("La comisión debe ser mayor o igual que 0");
        }

        ResultSet rs = sentencia.executeQuery("SELECT * FROM EMPLEADOS WHERE emp_no = " + num_emp);
        if (rs.next()) {
            throw new Exception("Número de empleado repetido");
        }
        rs.close();
        if (director != null) {
            rs = sentencia.executeQuery("SELECT * FROM EMPLEADOS WHERE apellido = '" + director + "'");

            if (!rs.next()) {
                throw new Exception("El director no existe en la tabla empleados");
            }
            rs.close();
        }
        rs = sentencia.executeQuery("SELECT * FROM DEPARTAMENTOS WHERE dept_no = " + depto_no);
        if (!rs.next()) {
            throw new Exception("El departamento introducido no existe");
        }
        rs.close();
    }
}
