/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import modelo.Jardinero;

/**
 * FXML Controller class
 *
 * @author 2dam
 */
public class MostrarDatosController implements Initializable {

    @FXML
    private Label lblNombre, lblApellido, lblEmail, lblSueldo;

    @FXML
    private Button btnCerrar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnCerrar.setOnAction(e -> {
            Stage stage = (Stage) btnCerrar.getScene().getWindow();
            stage.close();
        });
    }
    
    public void mostrarDatos(Jardinero jardinero) {
        lblNombre.setText(jardinero.getNombre());
        lblApellido.setText(jardinero.getApellido());
        lblEmail.setText(jardinero.getEmail());
        lblSueldo.setText(String.valueOf(jardinero.getSueldo()));
    }
}

