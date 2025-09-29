package controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import modelo.Jardinero;

public class FXMLDocumentController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private AnchorPane rootPane; // contenedor principal

    private DaoImplementacionBd dao = new DaoImplementacionBd();

    @FXML
    private void loginBd() {
        String email = txtUsuario.getText();
        String password = txtPassword.getText();

        if (email.isEmpty() || password.isEmpty()) {
            mostrarAlerta("Debe completar todos los campos.");
            return;
        }

        Jardinero jardinero = dao.login(email, password);

        if (jardinero != null) {
            try {
                // Cargar otraVentana.fxml y reemplazar el contenido del rootPane
                AnchorPane nuevaVista = FXMLLoader.load(getClass().getResource("/vista/MostrarDatos.fxml"));
                rootPane.getChildren().setAll(nuevaVista);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            mostrarAlerta("Correo o contraseña incorrectos.");
        }
    }

    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
