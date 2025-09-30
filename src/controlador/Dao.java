package controlador;

import modelo.Jardinero;

public interface Dao {

    boolean autenticar(String gmail, String password);

    Jardinero mostrarDatos(String gmail);
}
