package Componentes;

import Datos.GestionarArticulos;
import IU.dlgTransferencia;
import IU.dlgVentas;
import Modelo.Articulo;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class Mensajes {

    public static void informacion(String mensaje)//Mensaje de informacion
    {
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void error(String mensaje)//Mensaje de Error
    {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static int confirmar(String mensaje)//Mensaje de confirmacion
    {
        int res = JOptionPane.showConfirmDialog(null, mensaje, "Confirmar", 0, JOptionPane.OK_CANCEL_OPTION);
        return res;
    }

    public static void Sistema(String mensaje)//Mensaje de informacion
    {
        JOptionPane.showMessageDialog(null, mensaje, "Sistema FAST-FARMA", JOptionPane.INFORMATION_MESSAGE);
    }

    public static int ingresarNumerosV(int ca)//JoptionPane que solo acepte numeros
    {
        int numero = ca;
        //boolean bandera = false;
        //do
        {
            try {
                numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad", 1));
                if (numero <= 0) {
                    numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad", 1));
                } else {
                    int x = dlgVentas.tbDetalle.getSelectedRow();
                    String cod = dlgVentas.tbDetalle.getValueAt(x, 0).toString();
                    Articulo Ar = GestionarArticulos.busArticulo(cod);
                    if (numero > Ar.getStock()) {
                        numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad", Ar.getStock()));
                    }
                    //bandera = true;
                }
            } catch (HeadlessException | NumberFormatException e) {
                //informacion("Solo se permiten números");
                //bandera = false;
            }
        }//while(!bandera);
        return numero;
    }

    public static int ingresarNumerosT(int ca, String tipo) {
        int numero = ca;
        {
            try {
                numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad", 1));
                if (numero <= 0) {
                    numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad", 1));
                } else {
                    if (tipo.equals("S")) {
                        int x = dlgTransferencia.tbDetalle.getSelectedRow();
                        String cod = dlgTransferencia.tbDetalle.getValueAt(x, 0).toString();
                        Articulo Ar = GestionarArticulos.busArticulo(cod);
                        if (numero > Ar.getStock()) {
                            numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad", Ar.getStock()));
                        }
                    }
                }
            } catch (HeadlessException | NumberFormatException e) {
            }
        }
        return numero;
    }

    public static int ingresarNumerosC(int ca)//JoptionPane que solo acepte numeros
    {
        int numero = ca;
        //boolean bandera = false;
        //do
        {
            try {
                numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad", 1));
                if (numero <= 0) {
                    numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad", 1));
                }
            } catch (HeadlessException | NumberFormatException e) {
                //informacion("Solo se permiten números");
                //bandera = false;
            }
        }//while(!bandera);
        return numero;
    }

    public static int ingresarPrecioC(int pre)//JoptionPane que solo acepte numeros
    {
        int precio = pre;
        //boolean bandera = false;
        //do
        {
            try {
                precio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo precio", pre));
                if (precio <= 0) {
                    precio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo precio", pre));
                }
            } catch (HeadlessException | NumberFormatException e) {
                //informacion("Solo se permiten números");
                //bandera = false;
            }
        }//while(!bandera);
        return precio;
    }

    public static int ingresarNumeros()//JoptionPane que solo acepte numeros
    {
        int numero = 0;
        boolean bandera = false;
        do {
            try {
                numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad", 1));
                if (numero <= 0) {
                    numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad", 1));
                } else {
                    int x = dlgVentas.tbDetalle.getSelectedRow();
                    String cod = dlgVentas.tbDetalle.getValueAt(x, 0).toString();
                    Articulo Ar = GestionarArticulos.busArticulo(cod);
                    if (numero > Ar.getStock()) {
                        numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad", Ar.getStock()));
                    }
                    bandera = true;
                }
            } catch (HeadlessException | NumberFormatException e) {
                informacion("Solo se permiten números");
                bandera = false;
            }
        } while (!bandera);
        return numero;
    }

    public static double ingresarDecimales()//JoptionPane que solo acepte decimales
    {
        double numero = 0;
        boolean bandera = false;
        do {
            try {
                numero = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio"));
                bandera = true;
            } catch (HeadlessException | NumberFormatException e) {
                informacion("Solo se permiten números");
                bandera = false;
            }
        } while (!bandera);
        return numero;
    }

}
