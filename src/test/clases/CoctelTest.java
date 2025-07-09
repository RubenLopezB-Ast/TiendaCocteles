package clases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//Pruebas Coctel.

public class CoctelTest {

    private Coctel coctel;

    @BeforeEach
    void setUp() {
        coctel = new Coctel("Margarita", "Tequila, Limón, Sal", 5.7, 5);
    }

    @Test
    void testGetters() {
        assertEquals("Margarita", coctel.getNombre());
        assertEquals("Tequila, Limón, Sal", coctel.getIngredientes());
        assertEquals(5.7, coctel.getPrecio(), 0.01);
        assertEquals(5, coctel.getStock());
    }

    @Test
    void testSetters() {
        coctel.setNombre("Caipirinha");
        coctel.setIngredientes("Cachaza, Lima, Azúcar");
        coctel.setPrecio(5.9);
        coctel.setStock(19);

        assertEquals("Caipirinha", coctel.getNombre());
        assertEquals("Cachaza, Lima, Azúcar", coctel.getIngredientes());
        assertEquals(5.9, coctel.getPrecio(), 0.01);
        assertEquals(19, coctel.getStock());
    }

    @Test
    void testDisminuirStockConStockDisponible() {
        boolean resultado = coctel.disminuirStock();
        assertTrue(resultado);
        assertEquals(4, coctel.getStock());
    }

    @Test
    void testDisminuirStockSinStock() {
        coctel.setStock(0);
        boolean resultado = coctel.disminuirStock();
        assertFalse(resultado);
        assertEquals(0, coctel.getStock());
    }

    @Test
    void testToString() {
        String salida = coctel.toString();
        assertTrue(salida.contains("Cóctel: Margarita"));
        assertTrue(salida.contains("Ingredientes: Tequila, Limón, Sal"));
        assertTrue(salida.contains("Precio: 5.7"));
        assertTrue(salida.contains("Quedan en Stock: 5"));
    }
}
