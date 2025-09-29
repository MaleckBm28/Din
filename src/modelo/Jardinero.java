/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 2dam
 */
public class Jardinero {    
    private String nombre;
    private String apellido;
    private String contrasena;
    private String email;
    private Float sueldo;

    public Jardinero() {
    }

    public Jardinero(String nombre, String apellido, String contrasena, String gmail, Float sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.email = email;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getEmail() {
        return email;
    }

    public Float getSueldo() {
        return sueldo;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public void setApellido(String Apellido) {
        this.apellido = Apellido;
    }

    public void setContrasena(String Contrasena) {
        this.contrasena = Contrasena;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public void setSueldo(Float sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "jardinero{" + "Nombre=" + nombre + ", Apellido=" + apellido + ", Contrasena=" + contrasena + ", Email=" + email + ", sueldo=" + sueldo + '}';
    }
    
    
    
}
