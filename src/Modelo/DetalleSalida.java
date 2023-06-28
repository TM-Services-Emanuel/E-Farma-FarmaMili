package Modelo;

import java.io.Serializable;

public class DetalleSalida implements Serializable{
    
    private int codArt;
    private int codSalida;
    private int codM;
    private int cant;
    private int prec;
    private int monto;

    public DetalleSalida() {}

    public DetalleSalida(int codArt, int codSalida, int codM, int cant, int prec, int monto) {
        this.codArt = codArt;
        this.codSalida = codSalida;
        this.codM = codM;
        this.cant = cant;
        this.prec = prec;
        this.monto = monto;
    }

    public DetalleSalida(int codArt, int codM, int prec,int cant, int monto) {
        this.codArt = codArt;
        this.codM = codM;
        this.cant = cant;
        this.prec = prec;
        this.monto = monto;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public int getCodArt() {
        return codArt;
    }

    public void setCodArt(int codArt) {
        this.codArt = codArt;
    }

    public int getCodM() {
        return codM;
    }

    public void setCodM(int codM) {
        this.codM = codM;
    }

    public int getCodSalida() {
        return codSalida;
    }

    public void setCodSalida(int codSalida) {
        this.codSalida = codSalida;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getPrec() {
        return prec;
    }

    public void setPrec(int prec) {
        this.prec = prec;
    }
    
}
