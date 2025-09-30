/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepcion;

/**
 *
 * @author as
 */
public class LoginException extends Exception {
    public LoginException(String mensaje) {
        super(mensaje);
    }

    public LoginException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
