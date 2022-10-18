package Trimestre1.T02.Ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) {
        try {
            Scanner teclado = new Scanner(System.in);
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo", "root", "");
            Statement sentencia = conexion.createStatement();
            int num_Dpto = teclado.nextInt();
            String sql = "SELECT * FROM DEPARTAMENTOS WHERE dept_no = " + num_Dpto;
            sentencia.execute(sql);
            System.out.println("Prueba -->" + sentencia.getResultSet().next());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
