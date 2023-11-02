package Componentes;

import IU.dlgArticulos;
import IU.dlgClientes;
import IU.dlgCompras;
import IU.dlgProveedores;
import IU.dlgTransferencia;
import IU.dlgVentas;
import IU.frmPrincipal;
import ds.desktop.notify.DesktopNotify;
import java.awt.event.ActionEvent;

public class Notif {

    //Se trata de una notificación.
    //con DS Desktop Notify, la visualización de notificaciones en la pantalla es rápida y sencilla.
    /*public static void NotifySuccess(String titulo, String mensaje) {
        DesktopNotify.showDesktopMessage(
                titulo,
                mensaje,
                DesktopNotify.SUCCESS);
    }*/
    //Nótese que esta notificación no se puede cerrar con el ratón, esto se debe a que no todas las notificaciones se cierran con un clic. 
    //Se puede optar por darles un tiempo de expiración en milisegundos, de modo que las notificaciones permanezcan un tiempo determinado en la pantalla.
    public static void NotifyTip(String titulo, String mensaje) {
        DesktopNotify.showDesktopMessage(
                titulo,
                mensaje, DesktopNotify.TIP, 6000L);
    }

    //Este es un mensaje de información, para propósito general. Se brinda un ícono por defecto para este tipo de mensajes, pero puede usar el que usted prefiera en su lugar.
    public static void NotifyInformation(String titulo, String mensaje) {
        DesktopNotify.showDesktopMessage(
                titulo,
                mensaje,
                DesktopNotify.INFORMATION, 10000L);
    }

    //Este es un mensaje de advertencia. Se brinda un ícono por defecto para este tipo de mensajes, pero puede usar el que usted prefiera en su lugar.
    public static void NotifyWarning(String titulo, String mensaje) {
        DesktopNotify.showDesktopMessage(
                titulo,
                mensaje,
                DesktopNotify.WARNING, 6000L);

    }

//Este es un mensaje de error. Se brinda un ícono por defecto para este tipo de mensajes, pero puede usar el que usted prefiera en su lugar.
    public static void NotifyError(String titulo, String mensaje) {
        DesktopNotify.showDesktopMessage(
                titulo,
                mensaje,
                DesktopNotify.ERROR, 6000L);
    }

    //Este es un mensaje de éxito, útil para informar que un proceso o tarea se ha concluido sin problemas. 
    //Se brinda un ícono por defecto para este tipo de mensajes, pero puede usar el que usted prefiera en su lugar.
    public static void NotifySuccess(String titulo, String mensaje) {
        DesktopNotify.showDesktopMessage(
                titulo,
                mensaje,
                DesktopNotify.SUCCESS, 3000L);

    }

    //Este es un mensaje de fallo, útil para informar que un proceso o tarea se ha concluido con un resultado desalentador. 
    //Se brinda un ícono por defecto para este tipo de mensajes, pero puede usar el que usted prefiera en su lugar.
    public static void NotifyFail(String titulo, String mensaje) {
        DesktopNotify.showDesktopMessage(
                titulo,
                mensaje,
                DesktopNotify.FAIL, 6000L);

    }

    //Este es un mensaje de ayuda. Se brinda un ícono por defecto para este tipo de mensajes, pero puede usar el que usted prefiera en su lugar.
    public static void NotifyTouch(String titulo, String mensaje) {
        DesktopNotify.showDesktopMessage(
                titulo,
                mensaje,
                DesktopNotify.HELP, 6000L);
    }

    //Este es un tip. Se brinda un ícono por defecto para este tipo de mensajes, pero puede usar el que usted prefiera en su lugar.
    public static void NotifyTip_sTimer(String titulo, String mensaje) {
        DesktopNotify.showDesktopMessage(
                titulo,
                mensaje,
                DesktopNotify.TIP);
    }

    /*DesktopNotify.showDesktopMessage("Mensaje de Pedido de Entrada", "Este es un mensaje de pedido de entrada, úselo para solicitar datos (redirigiendo a algún formulario de ingreso, por supuesto). Se brinda un ícono por defecto para este tipo de mensajes, pero puede usar el que usted prefiera en su lugar.", DesktopNotify.INPUT_REQUEST, new ActionListener(){@Override public void actionPerformed(ActionEvent evt){
            //Podemos utilizar un formulario Frame o cualquier otro
            //new Formulario().setVisible(true);
            
            //Tambien podemos mostrar mensajes simples, sin iconos
           // DesktopNotify.setDefaultTheme(NotifyTheme.Light);
            DesktopNotify.showDesktopMessage("", "También puede mostrar mensajes sin un título, sin un ícono, con un ícono personalizado, un tema de color diferente, o con la combinación de elementos que desee.", DesktopNotify.INFORMATION);
            
            //Tambien puede mostrar un Mensaje de Dialogo
            //String texto = JOptionPane.showInputDialog(null, "Ingrese Texto");
            //System.out.println(texto);
        }});*/
 /*
        DesktopNotify.showDesktopMessage("Un mensaje sin ícono", "Mensaje", DesktopNotify.TIP, new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent evt){
            //Eventos al hacer click
            DesktopNotify.showDesktopMessage("Mensaje de Ayuda", "Este es un mensaje de ayuda. Se brinda un ícono por defecto para este tipo de mensajes, pero puede usar el que usted prefiera en su lugar.", DesktopNotify.HELP, new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent evt){
            //Eventos al hacer click

            System.out.println("Notificacion 2");
        }});
            
        }});
     */
    //DesktopNotify.setDefaultTheme(NotifyTheme.Dark);
    //"También puede añadir un ActionListener para especificar una acción a llevarse a cabo en caso el usuario haga clic sobre la notificación. 
    //Por ejemplo, esta notificación trae un evento. Haga clic para ejecutarlo.
    public static void Notify_Minim_dlgArticulos(String titulo, String mensaje) {
        DesktopNotify.showDesktopMessage(titulo,
                mensaje,
                DesktopNotify.HELP, (ActionEvent evt) -> {
                    if (frmPrincipal.PrincipalMinimizado != 1) {
                        if (dlgArticulos.min == 1) {
                            try {
                                dlgArticulos.btnEvento1.doClick();
                            } catch (Exception e) {
                                System.out.println("Error Notify_Minim_dlgArticulos: " + e.getMessage());
                            }
                        }
                    }
                });
    }
    
    public static void Notify_Minim_dlgVentas(String titulo, String mensaje) {
        DesktopNotify.showDesktopMessage(titulo,
                mensaje,
                DesktopNotify.HELP, (ActionEvent evt) -> {
                    if (frmPrincipal.PrincipalMinimizado != 1) {
                        if (dlgVentas.min == 1) {
                            try {
                                dlgVentas.btnEvento1.doClick();
                            } catch (Exception e) {
                                System.out.println("Error Notify_Minim_dlgVentas: " + e.getMessage());
                            }
                        }
                    }
                });
    }
    
    public static void Notify_Minim_dlgCompras(String titulo, String mensaje) {
        DesktopNotify.showDesktopMessage(titulo,
                mensaje,
                DesktopNotify.HELP, (ActionEvent evt) -> {
                    if (frmPrincipal.PrincipalMinimizado != 1) {
                        if (dlgCompras.min == 1) {
                            try {
                                dlgCompras.btnEvento1.doClick();
                            } catch (Exception e) {
                                System.out.println("Error Notify_Minim_dlgCompras: " + e.getMessage());
                            }
                        }
                    }
                });
    }
    
    public static void Notify_Minim_dlgTransferencia(String titulo, String mensaje) {
        DesktopNotify.showDesktopMessage(titulo,
                mensaje,
                DesktopNotify.HELP, (ActionEvent evt) -> {
                    if (frmPrincipal.PrincipalMinimizado != 1) {
                        if (dlgTransferencia.min == 1) {
                            try {
                                dlgTransferencia.btnEvento1.doClick();
                            } catch (Exception e) {
                                System.out.println("Error Notify_Minim_dlgTransferencia: " + e.getMessage());
                            }
                        }
                    }
                });
    }
    
    public static void Notify_Minim_dlgProveedores(String titulo, String mensaje) {
        DesktopNotify.showDesktopMessage(titulo,
                mensaje,
                DesktopNotify.HELP, (ActionEvent evt) -> {
                    if (frmPrincipal.PrincipalMinimizado != 1) {
                        if (dlgProveedores.min == 1) {
                            try {
                                dlgProveedores.btnEvento1.doClick();
                            } catch (Exception e) {
                                System.out.println("Error Notify_Minim_dlgProveedores: " + e.getMessage());
                            }
                        }
                    }
                });
    }
    
    public static void Notify_Minim_dlgClientes(String titulo, String mensaje) {
        DesktopNotify.showDesktopMessage(titulo,
                mensaje,
                DesktopNotify.HELP, (ActionEvent evt) -> {
                    if (frmPrincipal.PrincipalMinimizado != 1) {
                        if (dlgClientes.min == 1) {
                            try {
                                dlgClientes.btnEvento1.doClick();
                            } catch (Exception e) {
                                System.out.println("Error Notify_Minim_dlgClientes: " + e.getMessage());
                            }
                        }
                    }
                });
    }

    /*
        DesktopNotify.showDesktopMessage("¿No pasa nada con los clics?", "Nótese que esta notificación no se puede cerrar con el ratón, esto se debe a que no todas las notificaciones se cierran con un clic. Se puede optar por darles un tiempo de expiración en milisegundos, de modo que las notificaciones permanezcan un tiempo determinado en la pantalla.", DesktopNotify.TIP, 10000L);
     */
 /*
        DesktopNotify.showDesktopMessage("Mensaje de Información", "Cuerpo del texto", DesktopNotify.INFORMATION, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent evt){
            System.out.println("Hicistes clic en la Notificación de Información");
        }
        }
        );
     */
}
