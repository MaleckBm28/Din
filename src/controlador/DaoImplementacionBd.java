/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import modelo.Jardinero;

/**
 *
 * @author 2dam
 */
public class DaoImplementacionBd implements Dao {

    private ResourceBundle configFile;
	private String urlBD;
	private String userBD;
	private String passwordBD;

	private Connection con;
	private PreparedStatement stmt;
        private CallableStatement cs;
        
        final String LOGIN ="SELECT * FROM jardinero WHERE email = ? AND contrasena = ? ";
        
        public DaoImplementacionBd() {
		this.configFile = ResourceBundle.getBundle("modelo.configClass");
		this.urlBD = this.configFile.getString("Conn");
		this.userBD = this.configFile.getString("DBUser");
		this.passwordBD = this.configFile.getString("DBPass");
	}
    
        private void openConnection() {

		try {
                    con = DriverManager.getConnection(urlBD, this.userBD, this.passwordBD);
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/futbol_americano?serverTimezone=Europe/Madrid&useSSL=false", "root",
//				"abcd*1234");
		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
		}
	}
        
        
        private void closeConnection() throws SQLException {

		if (stmt != null) {
			stmt.close();
		}
		if (con != null) {
			con.close();
		}
		if (cs != null) {
			cs.close();
		}
	}
        
        @Override
        public Jardinero login(String email, String contrasena) {
        Jardinero jardinero = null;
        try {
        openConnection();
        stmt = con.prepareStatement(LOGIN);
        stmt.setString(1, email);
        stmt.setString(2, contrasena);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            jardinero = new Jardinero(
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("contrasena"),
                    rs.getString("email"),
                    rs.getFloat("sueldo")
            );
        }
        rs.close();
        closeConnection();
    } catch (SQLException e) {
        System.out.println("Error en login: " + e.getMessage());
    }
    return jardinero;
}

    
}
