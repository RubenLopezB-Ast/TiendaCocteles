package clases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Pruebas cliente.

public class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("Rubén", "López", "212121T", "Calle Mil 1", "600001002", "rlb@tumail.com");
    }

    @Test
    void testGetters() {
        assertEquals("Rubén", cliente.getNombre());
        assertEquals("López", cliente.getApellidos());
        assertEquals("212121T", cliente.getDni());
        assertEquals("Calle Mil 1", cliente.getDireccion());
        assertEquals("600001002", cliente.getTelefono());
        assertEquals("rlb@tumail.com", cliente.getEmail());
    }

    @Test
    void testSetters() {
        cliente.setNombre("Eva");
        cliente.setApellidos("Martínez");
        cliente.setDni("343434B");
        cliente.setDireccion("Calle Dosmil 2");
        cliente.setTelefono("602003004");
        cliente.setEmail("evl@tumail.com");

        assertEquals("Eva", cliente.getNombre());
        assertEquals("Martínez", cliente.getApellidos());
        assertEquals("343434B", cliente.getDni());
        assertEquals("Calle Dosmil 2", cliente.getDireccion());
        assertEquals("602003004", cliente.getTelefono());
        assertEquals("evl@tumail.com", cliente.getEmail());
    }

    @Test
    void testToString() {
        String salida = cliente.toString();
        assertTrue(salida.contains("CLIENTE: Rubén"));
        assertTrue(salida.contains("Buscado por: 212121T"));
        assertTrue(salida.contains("Email: rlb@tumail.com"));
    }
}
