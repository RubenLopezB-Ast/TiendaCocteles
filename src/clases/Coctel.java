package clases;

public class Coctel {
    private String nombre;
    private String ingredientes;
    private double precio;
    private int stock;

    public Coctel(String nombre, String ingredientes, double precio, int stock) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {

        this.precio = precio;
    }
    public int getStock(){ return stock;}
    public void setStock(int stock){
        this.stock = stock;}

    public boolean disminuirStock(){
        if (stock > 0){
            stock--;
            return true;
        }else{
            return false;
        }
    }

//Estoy sobre escribiendo a continuación
    public String toString() {
        return "Cóctel: " + nombre + " | Ingredientes: " + ingredientes + " | Precio: " + precio + " € \n Quedan en Stock: "+stock +" "+ nombre +"s";

    }
}

