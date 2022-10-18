package Trimestre1.T02.Ejercicios;

import java.sql.*;

public class Ej2RecorrerBDD {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo", "root", "");
            Statement sentencia = conexion.createStatement();
            String sql = "SELECT * FROM DEPARTAMENTOS";
            ResultSet rs = sentencia.executeQuery(sql);
            while (rs.next()) {
                System.out.printf("%d,%s,%s,%n", rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
