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
    private String Nombre;
    private String Apellido;
    private String Contrasena;
    private String Email;
    private Float sueldo;

    public Jardinero() {
    }

    public Jardinero(String Nombre, String Apellido, String Email, Float sueldo) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Email = Email;
        this.sueldo = sueldo;
    }
    
    

    public Jardinero(String string, String string0, String contrasena, String string1, float aFloat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public String getEmail() {
        return Email;
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

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setSueldo(Float sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "jardinero{" + "Nombre=" + Nombre + ", Apellido=" + Apellido + ", Contrasena=" + Contrasena + ", Email=" + Email + ", sueldo=" + sueldo + '}';
    }
    
    
    
}
