package Modelo;

public class Vendedor {
    
    private int codVe;
    private int ci;
    private String nombreV;
    private String direccion;
    private String telefono;
    private String celular;
    private String fech_ingreso;
    private int Sueldo;
    private int per_pago;
    private String funcon;
    public String per_adelanto;
    private int frecuencia;
    private int monto_adelanto;

    //Constructor

    public Vendedor(int codVe, int ci, String nombreV, String direccion, String telefono, String celular, String fech_ingreso, int Sueldo, int per_pago, String funcon, String per_adelanto, int frecuencia, int monto_adelanto) {
        this.codVe = codVe;
        this.ci = ci;
        this.nombreV = nombreV;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.fech_ingreso = fech_ingreso;
        this.Sueldo = Sueldo;
        this.per_pago = per_pago;
        this.funcon = funcon;
        this.per_adelanto = per_adelanto;
        this.frecuencia = frecuencia;
        this.monto_adelanto = monto_adelanto;
    }
    
    

    //Constructor Vacio
    public Vendedor() {
    }

    //Getter y Setter

    public int getCodVe() {
        return codVe;
    }

    public void setCodVe(int codVe) {
        this.codVe = codVe;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getNombreV() {
        return nombreV;
    }

    public void setNombreV(String nombreV) {
        this.nombreV = nombreV;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFech_ingreso() {
        return fech_ingreso;
    }

    public void setFech_ingreso(String fech_ingreso) {
        this.fech_ingreso = fech_ingreso;
    }

    public int getSueldo() {
        return Sueldo;
    }

    public void setSueldo(int Sueldo) {
        this.Sueldo = Sueldo;
    }

    public int getPer_pago() {
        return per_pago;
    }

    public void setPer_pago(int per_pago) {
        this.per_pago = per_pago;
    }

    public String getFuncon() {
        return funcon;
    }

    public void setFuncon(String funcon) {
        this.funcon = funcon;
    }

    public String getPer_adelanto() {
        return per_adelanto;
    }

    public void setPer_adelanto(String per_adelanto) {
        this.per_adelanto = per_adelanto;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public int getMonto_adelanto() {
        return monto_adelanto;
    }

    public void setMonto_adelanto(int monto_adelanto) {
        this.monto_adelanto = monto_adelanto;
    }
    
}
