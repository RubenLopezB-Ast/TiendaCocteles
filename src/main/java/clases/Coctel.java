package clases;

/**
 * Creación y visualización de los cocteles, precios y stock
 * @author Rubén López
 * @version 1
 */
public class Coctel {
    private String nombre;
    private String ingredientes;
    private double precio;
    private int stock;

    /**
     * Datos del nuevo coctel
     * @param nombre
     * @param ingredientes
     * @param precio
     * @param stock
     */
    public Coctel(String nombre, String ingredientes, double precio, int stock) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.precio = precio;
        this.stock = stock;
    }

    /**
     * Saca el nombre del cóctel
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Mete nombre del cóctel o modifica
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve ingredienres del coctel
     * @return Ingredientes
     */
    public String getIngredientes() {
        return ingredientes;
    }

    /**
     * Mete ingredientes del cóctel
     * @param ingredientes
     */
    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    /**
     * Saca el precio del cóctel
     * @return precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Mete precio de cóctel o lo modifica
     * @param precio
     */
    public void setPrecio(double precio) {

        this.precio = precio;
    }

    /**
     * saca Stock disponible
     * @return stock
     */
    public int getStock(){ return stock;}

    /**
     * Modifica el stock
     * @param stock
     */
    public void setStock(int stock){
        this.stock = stock;}

    /**
     * Resta stock
     * @return true si se ha disminuido stock false si no hay ya stock
     */
    public boolean disminuirStock(){
        if (stock > 0){
            stock--;
            return true;
        }else{
            return false;
        }
    }

    /**
     * Muestra la ficha del cocktel
     * @return ficha cóctel
     */
//Estoy sobre escribiendo a continuación
    public String toString() {
        return "Cóctel: " + nombre + " | Ingredientes: " + ingredientes + " | Precio: " + precio + " € \n Quedan en Stock: "+stock +" "+ nombre +"s";

    }
}

