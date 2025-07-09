package clases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Pruebas Venta.

import java.util.ArrayList;

public class VentaTest {

    private Cliente cliente;
    private Coctel coctel1;
    private Coctel coctel2;
    private Venta venta;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("Laura", "Gonzalez", "121212A", "Calle Tresmil 3", "606007008", "laura@tumail.com");
        coctel1 = new Coctel("Mojito", "Ron, Lima, Hierbabuena", 6.0, 3);
        coctel2 = new Coctel("Daiquiri", "Ron, Limón, Azúcar", 5.5, 2);
        venta = new Venta(cliente, "01/07/2025");
    }

    @Test
    void testGetCliente() {
        assertEquals("Laura", venta.getCliente().getNombre());
        assertEquals("121212A", venta.getCliente().getDni());
    }

    @Test
    void testAñadirCoctel() {
        venta.añadirCoctel(coctel1);
        venta.añadirCoctel(coctel2);
        ArrayList<Coctel> vendidos = venta.getCoctelesVendidos();

        assertEquals(2, vendidos.size());
        assertTrue(vendidos.contains(coctel1));
        assertTrue(vendidos.contains(coctel2));
    }

    @Test
    void testCalcularTotal() {
        venta.añadirCoctel(coctel1);
        venta.añadirCoctel(coctel2);

        double totalEsperado = coctel1.getPrecio() + coctel2.getPrecio();
        assertEquals(totalEsperado, venta.calcularTotal(), 0.01);
    }

    @Test
    void testToString() {
        venta.añadirCoctel(coctel1);
        String salida = venta.toString();
        assertTrue(salida.contains("=== VENTA ==="));
        assertTrue(salida.contains("Laura"));
        assertTrue(salida.contains("Mojito"));
        assertTrue(salida.contains("6.0"));
        assertTrue(salida.contains("01/07/2025"));
    }
}

