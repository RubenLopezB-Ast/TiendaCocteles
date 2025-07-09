package controlador;

import clases.Cliente;
import clases.Coctel;
import clases.Venta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

//Pruebas ControladorVentas
public class ControladorVentasTest {

    private Cliente cliente;
    private Coctel coctel1;
    private Coctel coctel2;

    @BeforeEach
    void setUp() {
        // Limpiar listas antes de cada prueba
        ControladorClientes.getClientes().clear();
        ControladorCocteles.getCocteles().clear();
        ControladorVentas.getVentas().clear();

        // Crear cliente y cócteles
        cliente = new Cliente("Eva", "Martínez", "343434B", "Calle Dosmil 2", "602003004", "evl@tumail.com");
        coctel1 = new Coctel("Mojito", "Ron, Menta", 6.0, 3);
        coctel2 = new Coctel("Daiquiri", "Ron, Limón", 5.0, 2);

        // Añadir a listas globales
        ControladorClientes.getClientes().add(cliente);
        ControladorCocteles.getCocteles().add(coctel1);
        ControladorCocteles.getCocteles().add(coctel2);
    }

    @Test
    void testCrearVentaManual() {
        Venta venta = new Venta(cliente, "01/07/2025");
        venta.añadirCoctel(coctel1);
        venta.añadirCoctel(coctel2);

        assertEquals(2, venta.getCoctelesVendidos().size());
        assertEquals(11.0, venta.calcularTotal(), 0.01);
    }

    @Test
    void testAgregarVentaALista() {
        Venta venta = new Venta(cliente, "01/07/2025");
        venta.añadirCoctel(coctel1);

        ControladorVentas.getVentas().add(venta);
        assertEquals(1, ControladorVentas.getVentas().size());
    }

    @Test
    void testMostrarVentasPorClienteExiste() {
        Venta venta = new Venta(cliente, "02/07/2025");
        venta.añadirCoctel(coctel2);
        ControladorVentas.getVentas().add(venta);

        boolean encontrada = false;
        for (Venta v : ControladorVentas.getVentas()) {
            if (v.getCliente().getDni().equalsIgnoreCase("343434B")) {
                encontrada = true;
                break;
            }
        }
        assertTrue(encontrada);
    }

    @Test
    void testMostrarVentasPorClienteInexistente() {
        boolean encontrada = false;
        for (Venta v : ControladorVentas.getVentas()) {
            if (v.getCliente().getDni().equalsIgnoreCase("999999Z")) {
                encontrada = true;
                break;
            }
        }
        assertFalse(encontrada);
    }
}

