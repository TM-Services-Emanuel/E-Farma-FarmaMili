package Modelo;

public class Stock {
    
    private int cod;
    private int stock;

    //Constructor
    public Stock(int cod, int stock) {
        this.cod = cod;
        this.stock = stock;
    }

    //Constructor Vacio
    public Stock() {
    }

    //Getter y Setter
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
    
}
