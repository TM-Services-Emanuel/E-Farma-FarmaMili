package Modelo;

public class Vendedor {
    
    private int codVe;
    private String nombreV;
    private String direccion;
    private String telefono;
    private String celular;
    private int Sueldo;
    private double comision;
    public String Obs;

    //Constructor
    public Vendedor(int codVe, String nombreV, String direccion, String telefono, String celular, int Sueldo, double comision, String Obs) {
        this.codVe = codVe;
        this.nombreV = nombreV;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.Sueldo = Sueldo;
        this.comision = comision;
        this.Obs = Obs;
    }
    

    //Constructor Vacio
    public Vendedor() {
    }

    //Getter y Setter
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getCodVe() {
        return codVe;
    }

    public void setCodVe(int codVe) {
        this.codVe = codVe;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreV() {
        return nombreV;
    }

    public void setNombreV(String nombreV) {
        this.nombreV = nombreV;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getSueldo() {
        return Sueldo;
    }

    public void setSueldo(int Sueldo) {
        this.Sueldo = Sueldo;
    }

    public String getObs() {
        return Obs;
    }

    public void setObs(String Obs) {
        this.Obs = Obs;
    }
}
