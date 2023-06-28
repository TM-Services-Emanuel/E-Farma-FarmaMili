package Modelo;

public class DetalleCompra {
    
    private int codArticulo;
    private int codCompra;
    private int cant;
    private int precio;
    private int monto;
    
    //Constructor sin codigo de Salida
    public DetalleCompra(int codArticulo, int cant, int precio, int monto) {
        this.codArticulo = codArticulo;
        this.cant = cant;
        this.precio = precio;
        this.monto = monto;
    }
    
    public DetalleCompra(int codArticulo) {
        this.codArticulo = codArticulo;
    }
    

    //Constructor Completo
    public DetalleCompra(int codArticulo, int codCompra, int cant, int precio, int monto) {
        this.codArticulo = codArticulo;
        this.codCompra = codCompra;
        this.cant = cant;
        this.precio = precio;
        this.monto = monto;
    }

    //Constructor Vacio
    public DetalleCompra() {
    }
    
    //Getter y Setter
    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public int getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(int codArticulo) {
        this.codArticulo = codArticulo;
    }

    public int getCodCompra() {
        return codCompra;
    }

    public void setCodCompra(int codCompra) {
        this.codCompra = codCompra;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
}
