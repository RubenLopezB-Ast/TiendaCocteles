package controlador;

import clases.Coctel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.Collator;
import java.util.Locale;

public class ControladorCocteles {
    private static ArrayList<Coctel> cocteles = new ArrayList<>();

    public static void menuCocteles(Scanner sc) {
        int opcion;
        do {
            System.out.println("=||= MENÚ DE GESTIÓN DE CÓCTELES =||=");
            System.out.println("**** 1 **** Alta de cóctel");
            System.out.println("**** 2 **** Listado del catálogo");
            System.out.println("**** 3 **** Búsqueda por nombre");
            System.out.println("**** 4 **** Ordenar cocteles");
            System.out.println("**** 5 **** Añadir Stock (Añadir stock de cocteles)");
            System.out.println("**** 6 **** Volver");
            System.out.println("____________________________________________");
            System.out.print("Opción: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1 -> altaCoctel(sc);
                case 2 -> listarCocteles();
                case 3 -> buscarCoctel(sc);
                case 4 -> ordenarCocteles(sc);
                case 5 -> añadirStock(sc);
                case 6 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("=== ERROR === \n Opción no válida");

            }
        } while (opcion != 6);
    }

    public static void altaCoctel(Scanner sc) {
        try {
            System.out.print("Nombre del cóctel: ");
            String nombre = sc.nextLine();
            System.out.print("Ingredientes: ");
            String ingredientes = sc.nextLine();
            System.out.print("Precio (€): ");
            double precio = sc.nextDouble();
            System.out.println("Disponibilidad de stock: ");
            int stock = sc.nextInt();
            sc.nextLine(); // Limpiar

            cocteles.add(new Coctel(nombre, ingredientes, precio, stock));
            System.out.println("=== CÓCTEL AÑADIDO AL CATÁLOGO ===");
        } catch (InputMismatchException e) {
            System.out.println("=== ERROR === \n === INCIDENCIA === \n Los datos introducidos no son válidos revísalo nuevamente");
            sc.nextLine(); // Limpiar
        }
    }
    public static void listarCocteles() {
        if (cocteles.isEmpty()) {
            System.out.println("=== ATENCIÓN === \n No hay cócteles en el catálogo");
        } else {
            System.out.println("\n=== CATÁLOGO DE CÓCTELES ===");
            for (Coctel c : cocteles) {
                System.out.println(c);
            }
        }
    }

    public static void buscarCoctel(Scanner sc) {
        System.out.print("Introduce el nombre del cóctel a buscar: ");
        String nombre = sc.nextLine();
        boolean encontrado = false;
        for (Coctel c : cocteles) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(c);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("=== COCTEL NO ENCONTRADO ===");
        }
    }

    public static ArrayList<Coctel> getCocteles() {
        return cocteles;
    }

    public static void añadirStock(Scanner sc) {
        System.out.print("Introduce el nombre del cóctel al que quieres añadir stock: ");
        String nombre = sc.nextLine();
        boolean encontrado = false;

        for (Coctel c : cocteles) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                System.out.print("UNIDADES A AÑADIR: ");
                try {
                    int cantidad = sc.nextInt();
                    sc.nextLine(); // Limpiar buffer

                    if (cantidad > 0) {
                        c.setStock(c.getStock() + cantidad);
                        System.out.println("Stock actualizado. Ahora hay " + c.getStock() + " unidades de " + c.getNombre() + "s.");
                    } else {
                        System.out.println("=== ERROR ===");
                        System.out.println("\n La cantidad debe ser mayor que cero.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("===ERROR===");
                    System.out.println("\n (Introduce datos correctos)");
                    sc.nextLine(); // Limpiar buffer
                }
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("=== COCTEL NO ENCONTRADO ===");
        }
    }

    public static void ordenarCocteles(Scanner sc){
        if (cocteles.isEmpty()){
            System.out.println("=== NO HAY COCTELES ===");
            System.out.println("No se puede ordenar");
            return;
        }
        System.out.println("--> ELIGE LA OPCIÓN PARA ORDENAR LOS COCTELES <--");
        System.out.println("**** 1 **** Nombre (Orden alfabético)");
        System.out.println("**** 2 **** Precio (Oden numérico)");
        System.out.println("**** 3 **** Stock (Cantidad)");
        System.out.println("__________________________________________________");
        System.out.print("Opción: ");
        try{
            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar
            switch (opcion){
                case 1:
                    Collator coctelOrden = Collator.getInstance(new Locale("es", "ES"));
                    coctelOrden.setStrength(Collator.PRIMARY); // Ignora tildes y mayúsculas/minúsculas

                    cocteles.sort((c1, c2) -> coctelOrden.compare(c1.getNombre(), c2.getNombre()));
                    break;
                case 2:
                    cocteles.sort(Comparator.comparingDouble(Coctel::getPrecio));
                    break;
                case 3:
                    cocteles.sort(Comparator.comparingInt(Coctel::getStock).reversed());
                    break;
                default:
                    System.out.println("=== ERROR ===");
                    System.out.println("=== (El número debe ser ente 1 y 4 inclusive) ===");
                    return;
            }
            System.out.println("Listado de cocteles ordenado correctamente: ");
            listarCocteles();
        }catch (InputMismatchException e){
            System.out.println("==== ERROR ====");
            System.out.println("==== (Introduce un número) ====");
            sc.nextLine(); // Limpiar para que no se quede pillado
        }
    }
}
