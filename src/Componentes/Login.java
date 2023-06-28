/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

public class Login {

    /**
     * @return the UsuarioLogueado
     */
    public static String getUsuarioLogueado() {
        return UsuarioLogueado;
    }

    /**
     * @param aUsuarioLogueado the UsuarioLogueado to set
     */
    public static void setUsuarioLogueado(String aUsuarioLogueado) {
        UsuarioLogueado = aUsuarioLogueado;
    }
    
    public static String getPasswordLogeado() {
        return PasswordLogeado;
    }

    /**
     * @param aPasswordLogeado the PasswordLogeado to set
     */
    public static void setPasswordLogeado(String aPasswordLogeado) {
        PasswordLogeado = aPasswordLogeado;
    }

    /**
     * @return the idLogueado
     */
    public static String getIdLogueado() {
        return idLogueado;
    }

    /**
     * @param aIdLogueado the idLogueado to set
     */
    public static void setIdLogueado(String aIdLogueado) {
        idLogueado = aIdLogueado;
    }
    
    private static String UsuarioLogueado="";
    private static String PasswordLogeado="";
    private static String idLogueado="";
}
