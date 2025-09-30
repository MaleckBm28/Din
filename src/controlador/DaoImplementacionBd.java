package controlador;

import modelo.Jardinero;
import java.sql.*;
import java.util.ResourceBundle;

public class DaoImplementacionBd implements Dao {

    private Connection con;
    private PreparedStatement stmt;
    private ResourceBundle configFile;
    private String urlBD;
    private String userBD;
    private String passwordBD;

    // Consultas
    private static final String LOGIN =
        "SELECT 1 FROM jardineros WHERE gmail=? AND contrasena=?";

    private static final String MOSTRAR_DATOS =
        "SELECT nombre, apellido, gmail, sueldo, contrasena FROM jardineros WHERE gmail=?";

    private static final String COUNT =
        "SELECT COUNT(*) FROM jardineros";

    private static final String INSERT =
        "INSERT INTO jardineros (nombre, apellido, contrasena, gmail, sueldo) VALUES (?, ?, ?, ?, ?)";

    public DaoImplementacionBd() {
        this.configFile = ResourceBundle.getBundle("modelo.configClass");
        this.urlBD = this.configFile.getString("Conn");
        this.userBD = this.configFile.getString("DBUser");
        this.passwordBD = this.configFile.getString("DBPass");

        // Insertar datos iniciales si la tabla está vacía
        inicializarDatos();
    }

    private void openConnection() throws SQLException {
        con = DriverManager.getConnection(urlBD, userBD, passwordBD);
    }

    private void closeConnection() throws SQLException {
        if (stmt != null) stmt.close();
        if (con != null) con.close();
    }

    /**
     * Método que inserta datos de ejemplo si la tabla está vacía
     */
    private void inicializarDatos() {
        try {
            openConnection();

            // Verificar si la tabla tiene registros
            stmt = con.prepareStatement(COUNT);
            ResultSet rs = stmt.executeQuery();
            int count = 0;
            if (rs.next()) {
                count = rs.getInt(1);
            }
            rs.close();
            stmt.close();

            if (count == 0) {
                stmt = con.prepareStatement(INSERT);

                stmt.setString(1, "Admin");
                stmt.setString(2, "Principal");
                stmt.setString(3, "admin");
                stmt.setString(4, "admin@jardin.com");
                stmt.setFloat(5, 2000.0f);
                stmt.executeUpdate();

                stmt.setString(1, "Juan");
                stmt.setString(2, "Pérez");
                stmt.setString(3, "1234");
                stmt.setString(4, "juan@jardin.com");
                stmt.setFloat(5, 1500.0f);
                stmt.executeUpdate();

                stmt.setString(1, "María");
                stmt.setString(2, "López");
                stmt.setString(3, "abcd");
                stmt.setString(4, "maria@jardin.com");
                stmt.setFloat(5, 1800.0f);
                stmt.executeUpdate();

                System.out.println("✅ Datos iniciales insertados en BD.");
            }

        } catch (SQLException e) {
            System.out.println("⚠️ Error en inicializarDatos: " + e.getMessage());
        } finally {
            try { closeConnection(); } catch (SQLException e) {}
        }
    }

    @Override
    public boolean autenticar(String gmail, String password) {
        ResultSet rs = null;
        boolean existe = false;
        try {
            openConnection();
            stmt = con.prepareStatement(LOGIN);
            stmt.setString(1, gmail);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            existe = rs.next();
        } catch (SQLException e) {
            System.out.println("⚠️ Error en autenticar BD: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                closeConnection();
            } catch (SQLException e) {}
        }
        return existe;
    }

    @Override
    public Jardinero mostrarDatos(String gmail) {
        ResultSet rs = null;
        Jardinero jardinero = null;
        try {
            openConnection();
            stmt = con.prepareStatement(MOSTRAR_DATOS);
            stmt.setString(1, gmail);
            rs = stmt.executeQuery();
            if (rs.next()) {
                jardinero = new Jardinero(
                    rs.getString("nombre"),
                    rs.getString("contrasena"),
                    rs.getString("apellido"),
                    rs.getString("gmail"),
                    rs.getFloat("sueldo")
                );
            }
        } catch (SQLException e) {
            System.out.println("⚠️ Error en mostrarDatos BD: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                closeConnection();
            } catch (SQLException e) {}
        }
        return jardinero;
    }
}
