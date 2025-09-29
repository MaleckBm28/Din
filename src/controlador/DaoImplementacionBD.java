/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import modelo.Jardinero;

/**
 *
 * @author 2dam
 */
public class DaoImplementacionBD implements Dao {

    private Connection con;
    private PreparedStatement stmt;
    private ResourceBundle configFile;
    private String urlBD;
    private String userBD;
    private String passwordBD;

    final String OBTENER_DATOS = "SELECT * FROM jardineros WHERE email = ? AND contrasena = ?";
    final String MOSTRAR_DATOS = "SELECT nombre, apellido, email, sueldo FROM jardineros WHERE email = ?";

    public boolean obtenerJardinero(String email, String contrasena) {
        ResultSet rs = null;
        boolean existe = false;

        openConnection();
        try {
            stmt = con.prepareStatement(OBTENER_DATOS);
            stmt.setString(1, email);
            stmt.setString(2, contrasena);
            rs = stmt.executeQuery();

            existe = rs.next();
        } catch (SQLException e) {
            System.out.println("Error en obtenerJardinero: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
            }
            closeConnection();
        }
        return existe;
    }

    public Jardinero mostrarDatos(Jardinero jardinero) {
        ResultSet rs = null;
        Jardinero resultado = null;

        openConnection();
        try {
            stmt = con.prepareStatement(MOSTRAR_DATOS);
            stmt.setString(1, jardinero.getEmail());
            rs = stmt.executeQuery();

            if (rs.next()) {
                resultado = new Jardinero(
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getFloat("sueldo")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error en mostrarDatos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
            }
            closeConnection();
        }
        return resultado;
    }

    private void openConnection() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void closeConnection() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
