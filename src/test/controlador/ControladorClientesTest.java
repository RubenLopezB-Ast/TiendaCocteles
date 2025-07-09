package controlador;

import clases.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

// Pruebas ControladorClientes.
public class ControladorClientesTest {

    @BeforeEach
    void setUp() {
        // Limpiar la lista de clientes antes de cada prueba
        ControladorClientes.getClientes().clear();
    }

    @Test
    void testAltaClienteYBuscarPorDni() {
        // Simular alta de cliente
        Cliente cliente = new Cliente("Bea", "Zur", "151515A", "Calle Cuatromil 4", "609010011", "zur@tumail.com");
        ControladorClientes.getClientes().add(cliente);

        Cliente resultado = ControladorClientes.buscarPorDni("151515A");
        assertNotNull(resultado);
        assertEquals("Bea", resultado.getNombre());
        assertEquals("Zur", resultado.getApellidos());
    }

    @Test
    void testBuscarPorDniInexistente() {
        Cliente resultado = ControladorClientes.buscarPorDni("999999X");
        assertNull(resultado);
    }

    @Test
    void testListarClientes() {
        assertTrue(ControladorClientes.getClientes().isEmpty());

        Cliente cliente1 = new Cliente("Joan", "Peré", "161616X", "Calle Cincomil 5", "610011012", "joan@tumail.com");
        Cliente cliente2 = new Cliente("Lucía", "Sánz", "171717B", "Calle Seismil 6", "611012013", "lsa@tumail.com");
        ControladorClientes.getClientes().add(cliente1);
        ControladorClientes.getClientes().add(cliente2);

        ArrayList<Cliente> lista = ControladorClientes.getClientes();
        assertEquals(2, lista.size());
        assertEquals("Joan", lista.get(0).getNombre());
        assertEquals("Lucía", lista.get(1).getNombre());
    }
}

