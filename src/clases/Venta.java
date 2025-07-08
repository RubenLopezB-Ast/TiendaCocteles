package clases;

import java.util.ArrayList;

public class Venta {
    private Cliente cliente;
    private ArrayList<Coctel> coctelesVendidos;
    private String fecha;

    public Venta(Cliente cliente, String fecha) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.coctelesVendidos = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Coctel> getCoctelesVendidos() {
        return coctelesVendidos;
    }

    public String getFecha() {
        return fecha;
    }

    public void añadirCoctel(Coctel coctel) {
        coctelesVendidos.add(coctel);
    }

    public double calcularTotal() {
        double total = 0;
        for (Coctel c : coctelesVendidos) {
            total += c.getPrecio();
        }
        return total;
    }

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
