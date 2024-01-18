package Datos;

import Modelo.DetalleTransferencia;
import java.util.ArrayList;

public class ArregloTransferencia {
    
    private final ArrayList<DetalleTransferencia> dt; //Arreglo de objetos para las lineas de la factura
    
    //Constructor
    public ArregloTransferencia()
    {
        dt = new ArrayList(); //Creamos el objeto
    }
    //Agregamos una nueva fila al detalle
    public void agregar(DetalleTransferencia nuevo)
    {
        dt.add(nuevo);
    }
    
    //Obtenemo una fila del detalle
    public DetalleTransferencia getFila(int i)
    {
        return dt.get(i);
    }
    
    //Remplazamos la informacion de la linea
    public void update(int i, DetalleTransferencia act)
    {
        dt.set(i, act);
    }
    
    //Elimina todas la lineas del detalle
    public void vaciar()
    {
        for(int i=0;i<numFilas();i++)
        {
            //df.remove(0);
            dt.clear();
        }
    }
    
    //Elimina una linea del detalle
    public void eliminar(int i)
    {
        dt.remove(i);
    }
    
    //Obtiene el numero de filas registradas
    public int numFilas()
    {
        return dt.size();
    }
    
    //Buscar y validar que el objeto no se repita
    public int busca(int codigo)
    {
        for(int i=0;i<numFilas();i++)
        {
            if(codigo == getFila(i).getCodArticulo())
                return i; //Retorna indice
        }
        return -1; //No se encontro objeto
    }
    
}
