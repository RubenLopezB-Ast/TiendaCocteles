package controlador;

import clases.Cliente;
import clases.Coctel;
import clases.Venta;

import java.util.ArrayList;
import java.util.Scanner;

public class ControladorVentas {
    private static ArrayList<Venta> ventas = new ArrayList<>();

    public static void realizarVenta(Scanner sc) {
        try {
            System.out.println("Introduce el DNI del cliente que realiza la compra:");
            String dni = sc.nextLine();
            Cliente cliente = ControladorClientes.buscarPorDni(dni);

            if (cliente == null) {
                System.out.println("=== CLIENTE NO ENCONTRADO ===");
                return;
            }

            System.out.print("Introduce la fecha de la venta (dd/mm/yyyy): ");
            String fecha = sc.nextLine();
            Venta venta = new Venta(cliente, fecha);

            ArrayList<Coctel> disponibles = ControladorCocteles.getCocteles();
            if (disponibles.isEmpty()) {
                System.out.println("\n=== CATÁLOGO VACÍO ===");
                System.out.println("\n No hay cócteles en el catálogo");
                System.out.println("\n (debes de añadir antes cocteles al catálogo)");
                System.out.println("\n ====================================================");
                return;
            }

            int opcion;
            do {
                System.out.println("\nElige un cóctel (por número) o 0 para terminar:");
                for (int i = 0; i < disponibles.size(); i++) {
                    System.out.println((i + 1) + ". " + disponibles.get(i));
                }
                System.out.print("Opción: ");
                opcion = sc.nextInt(); sc.nextLine();

                if (opcion > 0 && opcion <= disponibles.size()) {
                    Coctel seleccionado = disponibles.get(opcion - 1);
                    if (seleccionado.getStock() > 0) {
                        seleccionado.disminuirStock();
                        venta.añadirCoctel(seleccionado);
                        System.out.println("=== COCTEL AÑADIDO A LA VENTA ===");
                    } else {
                        System.out.println("\n#### == SIN STOCK == ####");
                        System.out.println("\nNo hay stock; de este coctel || Debes de reponer antes para poder realizar la venta");
                    }
                } else if (opcion != 0) {
                    System.out.println("Opción no válida, introduce # 0 # ");
                }
            } while (opcion != 0);

            if (venta.getCoctelesVendidos().isEmpty()) {
                System.out.println("No hay ninguna venta de coctail");
                System.out.println("\n ===== VENTA CANCELADA =====");
            } else {
                ventas.add(venta);
                System.out.println("=== VENTA REGISTRADA CORRECTAMENTE ===");
            }
        } catch (Exception e) {
            System.out.println("===== ERROR =====");
            System.out.println("Se produjo un error al registrar la venta");
            sc.nextLine(); // limpiar entrada
        }
    }
    public static void menuVentas(Scanner sc) {
        int opcion;
        do {
            System.out.println("=||= MENÚ DE VENTAS =||=");
            System.out.println("*** 1 *** Mostrar todas las ventas");
            System.out.println("*** 2 *** Mostrar ventas por cliente (DNI)");
            System.out.println("*** 3 *** Volver");
            System.out.print("Opción: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1 -> mostrarTodasLasVentas();
                case 2 -> mostrarVentasPorCliente(sc);
                case 3 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("==== OPCIÓN NO VÁLIDA ====");
            }
        } while (opcion != 3);
    }

    public static void mostrarTodasLasVentas() {
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas");
        } else {
            for (Venta v : ventas) {
                System.out.println(v);
            }
        }
    }

    public static void mostrarVentasPorCliente(Scanner sc) {
        System.out.print("Introduce el DNI del cliente: ");
        String dni = sc.nextLine();
        boolean encontrado = false;
        for (Venta v : ventas) {
            if (v.getCliente().getDni().equalsIgnoreCase(dni)) {
                System.out.println(v);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("=== NO SE ENCUENTRAN VENTAS === \nNo hay ventas para ese cliente");
        }
    }

    public static ArrayList<Venta> getVentas() {
        return ventas;
    }
}

