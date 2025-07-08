package clases;
/**
 * Ventas realizadas a clientes (lista cocteles y fechas de las operaciones)
 *
 * @author Rubén López
 * @version 1
 */

import java.util.ArrayList;

public class Venta {
    private Cliente cliente;
    private ArrayList<Coctel> coctelesVendidos;
    private String fecha;

    /**
     * Creacion de nueva venta
     * @param cliente
     * @param fecha
     */
    public Venta(Cliente cliente, String fecha) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.coctelesVendidos = new ArrayList<>();
    }

    /**
     * Saca al cliente al que se le hizo la venta
     * @return Cliente
     */

    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Saca listado de cocteles vendido
     * @return lista cocteles vendidos
     */
    public ArrayList<Coctel> getCoctelesVendidos() {
        return coctelesVendidos;
    }

    /**
     * Saca fecha de la venta
     * @return fecha de venta
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Pone un cóctel más a la lista de coctles vendido
     * @param coctel añadido
     */

    public void añadirCoctel(Coctel coctel) {
        coctelesVendidos.add(coctel);
    }

    /**
     * Total de la venta sumando precio cocteles
     * @return total venta
     */
    public double calcularTotal() {
        double total = 0;
        for (Coctel c : coctelesVendidos) {
            total += c.getPrecio();
        }
        return total;
    }

    /**
     * Saca datos completos de la venta
     * @return Información completa de la venta
     */
    // Sobreescribir
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n=== VENTA ===");
        sb.append("\nCliente: ").append(cliente.getNombre()).append(" ").append(cliente.getApellidos());
        sb.append("\nDNI: ").append(cliente.getDni());
        sb.append("\nFecha: ").append(fecha);
        sb.append("\nCócteles vendidos:");
        for (Coctel c : coctelesVendidos) {
            sb.append("\n - ").append(c.getNombre()).append(" (").append(c.getPrecio()).append(" €)");
        }
        sb.append("\nTotal: ").append(calcularTotal()).append(" €\n");
        return sb.toString();
    }
}
