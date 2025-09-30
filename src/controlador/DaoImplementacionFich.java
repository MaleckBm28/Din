package controlador;

import modelo.Jardinero;
import java.io.*;
import java.util.*;

public class DaoImplementacionFich implements Dao {

    private final List<Jardinero> jardineros;
    private static final String FICHERO = "usuarios.dat";

    public DaoImplementacionFich() throws IOException, ClassNotFoundException {
        File f = new File(FICHERO);
        if (f.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
                jardineros = (List<Jardinero>) ois.readObject();
            }
        } else {
            jardineros = new ArrayList<>();
            cargaDatosFich(); // ✅ método que mete los datos de prueba
            guardar();
        }
    }

    /**
     * Carga unos datos iniciales en memoria.
     */
    private void cargaDatosFich() {
        jardineros.add(new Jardinero("Admin", "admin", "Principal", "admin@jardin.com", 2000.0f));
        jardineros.add(new Jardinero("Juan", "1234", "Pérez", "juan@jardin.com", 1500.0f));
        jardineros.add(new Jardinero("María", "abcd", "López", "maria@jardin.com", 1800.0f));
    }

    /**
     * Guarda la lista de jardineros en el fichero binario.
     */
    private void guardar() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {
            oos.writeObject(jardineros);
        }
    }

    @Override
    public boolean autenticar(String gmail, String password) {
        for (Jardinero j : jardineros) {
            if (j.getGmail().equalsIgnoreCase(gmail) && j.getContrasena().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Jardinero mostrarDatos(String gmail) {
        for (Jardinero j : jardineros) {
            if (j.getGmail().equalsIgnoreCase(gmail)) {
                return j;
            }
        }
        return null;
    }
}
