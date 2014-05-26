/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexion;

import java.sql.*;
import java.math.*;

class Conexion {

    static public void main(String[] args) {
        Connection conn;
        Statement sentencia;
        ResultSet resultado;

        System.out.println("Conexi�n a la base de datos...");

        try { // Se carga el driver JDBC-ODBC
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            System.out.println("No se pudo cargar el driver JDBC");
            return;
        }
        try { // Se establece la conexi�n con la base de datos
            conn = DriverManager.getConnection("jdbc:oracle:thin:@cristhianOK:1521:xe", "system", "cristhian");
            sentencia = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("No hay conexi�n con la base de datos.");
            return;
        }

        try {
            System.out.println("Seleccionando...");
            resultado = sentencia.executeQuery("SELECT codigo,nom,salario FROM empleado");
            //Se recorren las tuplas retornadas
            while (resultado.next()) {
                System.out.println(resultado.getInt("codigo")
                        + "---" + resultado.getString("nom") + "---"
                        + resultado.getInt("salario"));
            }
            conn.close(); //Cierre de la conexi�n
        } catch (SQLException e) {
            System.out.println("Error: "
                    + e.getMessage());
        }
        System.out.println("Consulta finalizada.");
    } //Fin del main
} //Fin de la clase
