package controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import modelo.Jardinero;

public class FXMLDocumentController {

    // ----------- Ventana Login -----------
    @FXML private TextField txtGmail;
    @FXML private PasswordField txtPassword;
    @FXML private Button btnEntrar;
    @FXML private Label lblMensaje;

    // ----------- Ventana MostrarJardinero -----------
    @FXML private Label lblNombre;
    @FXML private Label lblApellido;
    @FXML private Label lblGmail;
    @FXML private Label lblSueldo;

    @FXML
    private void onEntrar() {
        String u = txtGmail.getText();
        String p = txtPassword.getText();

        if (u == null || u.trim().isEmpty() || p == null || p.trim().isEmpty()) {
            lblMensaje.setText("Rellena usuario y contraseña");
            return;
        }

        try {
            Dao fich = new DaoImplementacionFich();
            Dao bd   = new DaoImplementacionBd();

            boolean valido = fich.autenticar(u, p);
            Jardinero jardinero = null;

            if (valido) {
                jardinero = fich.mostrarDatos(u);
            } else if (bd.autenticar(u, p)) {
                jardinero = bd.mostrarDatos(u);
            }

            if (jardinero != null) {
                abrirVentanaMostrar(jardinero);
                Stage loginStage = (Stage) btnEntrar.getScene().getWindow();
                loginStage.close();
            } else {
                lblMensaje.setText("Usuario o contraseña incorrectos");
            }
        } catch (Exception e) {
            mostrarError("No se pudo validar: " + e.getMessage());
        }
    }

    private void abrirVentanaMostrar(Jardinero jardinero) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/MostrarJardinero.fxml"));
            Parent root = loader.load();

            FXMLDocumentController controller = loader.getController();
            controller.mostrarDatosJardinero(jardinero);

            Stage stage = new Stage();
            stage.setTitle("Datos del Jardinero");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            mostrarError("No se pudo abrir la ventana de mostrar: " + e.getMessage());
        }
    }

    public void mostrarDatosJardinero(Jardinero j) {
        if (lblNombre != null) {
            lblNombre.setText("Nombre: " + j.getNombre());
            lblApellido.setText("Apellido: " + j.getApellido());
            lblGmail.setText("Correo: " + j.getGmail());
            lblSueldo.setText("Sueldo: " + j.getSueldo());
        }
    }

    private void mostrarError(String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR, msg, ButtonType.OK);
        a.setHeaderText("Error");
        a.showAndWait();
    }
}
