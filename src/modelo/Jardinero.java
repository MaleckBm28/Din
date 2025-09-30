/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author as
 */
public class Jardinero implements Serializable {

    private static final long serialVersionUID = 1L;

    private String Nombre;
    private String Apellido;
    private String Contrasena;
    private String Gmail;
    private Float sueldo;

    public Jardinero() {
    }

    // Constructor con parámetros básicos
    public Jardinero(String nombre, String contrasena, String apellido, String gmail, Float sueldo) {
        this.Nombre = nombre;
        this.Contrasena = contrasena;
        this.Apellido = apellido;
        this.Gmail = gmail;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public String getGmail() {
        return Gmail;
    }

    public Float getSueldo() {
        return sueldo;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public void setGmail(String Gmail) {
        this.Gmail = Gmail;
    }

    public void setSueldo(Float sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Jardinero{"
                + "Nombre='" + Nombre + '\''
                + ", Apellido='" + Apellido + '\''
                + ", Contrasena='" + Contrasena + '\''
                + ", Gmail='" + Gmail + '\''
                + ", sueldo=" + sueldo
                + '}';
    }
}
