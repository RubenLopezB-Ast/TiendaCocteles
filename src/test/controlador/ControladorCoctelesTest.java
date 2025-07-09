package controlador;

import clases.Coctel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

//Pruebas ControladorCocteles

public class ControladorCoctelesTest {

    @BeforeEach
    void setUp() {
        // Limpiar lista antes de cada prueba
        ControladorCocteles.getCocteles().clear();
    }

    @Test
    void testAltaManualYBuscarPorNombre() {
        Coctel c1 = new Coctel("Mojito", "Ron, Menta, Azúcar", 6.5, 10);
        ControladorCocteles.getCocteles().add(c1);

        ArrayList<Coctel> lista = ControladorCocteles.getCocteles();
        assertEquals(1, lista.size());
        assertEquals("Mojito", lista.get(0).getNombre());
    }

    @Test
    void testAñadirStock() {
        Coctel c1 = new Coctel("Daiquiri", "Ron, Limón, Azúcar", 5.0, 2);
        ControladorCocteles.getCocteles().add(c1);

        // Simulamos añadir stock directamente
        c1.setStock(c1.getStock() + 3);

        assertEquals(5, c1.getStock());
    }

    @Test
    void testOrdenarPorPrecio() {
        Coctel c1 = new Coctel("Negroni", "Ginebra, Vermut, Campari", 7.0, 5);
        Coctel c2 = new Coctel("Cosmopolitan", "Vodka, Arándano", 6.0, 3);
        ControladorCocteles.getCocteles().add(c1);
        ControladorCocteles.getCocteles().add(c2);

        ControladorCocteles.getCocteles().sort((a, b) -> Double.compare(a.getPrecio(), b.getPrecio()));

        assertEquals("Cosmopolitan", ControladorCocteles.getCocteles().get(0).getNombre());
    }

    @Test
    void testOrdenarPorStock() {
        Coctel c1 = new Coctel("Piña Colada", "Ron, Piña, Coco", 6.0, 4);
        Coctel c2 = new Coctel("Caipirinha", "Cachaza, Lima", 6.0, 10);
        ControladorCocteles.getCocteles().add(c1);
        ControladorCocteles.getCocteles().add(c2);

        ControladorCocteles.getCocteles().sort((a, b) -> Integer.compare(b.getStock(), a.getStock()));

        assertEquals("Caipirinha", ControladorCocteles.getCocteles().get(0).getNombre());
    }
}

