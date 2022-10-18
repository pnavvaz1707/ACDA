package Trimestre1.T02.Clase;

import java.sql.*;

public class E2MySQL {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo", "root", "");
            Statement sentencia = conexion.createStatement();
//            String sql = "SELECT * FROM DEPARTAMENTOS";
//            ResultSet rs = sentencia.executeQuery(sql);
//            while (rs.next()) {
//                System.out.printf("%d,%s,%s,%n", rs.getInt(1), rs.getString(2), rs.getString(3));
//            }
//            rs.close();
//            String sql = "UPDATE DEPARTAMENTOS d SET d.loc = 'Malaga' WHERE d.loc = 'Málaga'";
//            String sql = "DELETE FROM DEPARTAMENTOS WHERE loc = 'Sevilla'";
            String sql = "INSERT INTO DEPARTAMENTOS VALUES (2,'GESTIÓN','Sevilla')";
            int filas = sentencia.executeUpdate(sql);
            System.out.println("Filas afectadas --> " + filas);
            sentencia.close();
            conexion.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
