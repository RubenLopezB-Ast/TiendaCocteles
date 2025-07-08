package controlador;

import clases.Cliente;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.text.Collator;
import java.util.Locale;

public class ControladorClientes {
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void menuClientes(Scanner sc) {
        int opcion = -1;
        do {
            System.out.println("=||= MENÚ PARA LA GESTIÓN DE CLIENTES =||=");
            System.out.println("*** 1 *** Alta");
            System.out.println("*** 2 *** Baja");
            System.out.println("*** 3 *** Modificación");
            System.out.println("*** 4 *** Búsqueda (DNI)");
            System.out.println("*** 5 *** Listar todos los clientes");
            System.out.println("*** 6 *** Ordenar clientes");
            System.out.println("*** 7 *** Volver");
            System.out.print("Opción: ");

            try {
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        altaCliente(sc);
                        break;
                    case 2:
                        bajaCliente(sc);
                        break;
                    case 3:
                        modificarCliente(sc);
                        break;
                    case 4:
                        buscarCliente(sc);
                        break;
                    case 5:
                        listarClientes();
                        break;
                    case 6:
                        ordenarClientes(sc);
                        break;
                    case 7:
                        System.out.println("....Volvemos al menú principal....");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("====ERROR====");
                System.out.println("====(Introduce un número)===");
                sc.nextLine(); // Limpiar para que no se quede pillado
            }
        } while (opcion != 7);
    }

    public static void altaCliente(Scanner sc) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = sc.nextLine();
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        System.out.print("Dirección: ");
        String direccion = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        clientes.add(new Cliente(nombre, apellidos, dni, direccion, telefono, email));
        System.out.println("=== CLIENTE AÑADIDO ===");
    }

    public static void bajaCliente(Scanner sc) {
        System.out.print("Introduce el DNI del cliente a eliminar: ");
        String dni = sc.nextLine();
        Cliente cliente = buscarPorDni(dni);
        if (cliente != null) {
            clientes.remove(cliente);
            System.out.println("=== CLIENTE ELIMINADO ===");
        } else {
            System.out.println("=== CLIENTE NO ENCONTRADO ===");
        }
    }

    public static void modificarCliente(Scanner sc) {
        System.out.print("Introduce el DNI del cliente a modificar: ");
        String dni = sc.nextLine();
        Cliente cliente = buscarPorDni(dni);
        if (cliente != null) {
            System.out.print("Nuevo nombre: ");
            cliente.setNombre(sc.nextLine());
            System.out.print("Nuevos apellidos: ");
            cliente.setApellidos(sc.nextLine());
            System.out.print("Nueva dirección: ");
            cliente.setDireccion(sc.nextLine());
            System.out.print("Nuevo teléfono: ");
            cliente.setTelefono(sc.nextLine());
            System.out.print("Nuevo email: ");
            cliente.setEmail(sc.nextLine());
            System.out.println("=== CLIENTE MODIFICADO ===");
        } else {
            System.out.println("=== CLIENTE NO ENCONTRADO ===");
        }
    }

    public static void buscarCliente(Scanner sc) {
        System.out.print("Introduce el DNI del cliente a buscar: ");
        String dni = sc.nextLine();
        Cliente cliente = buscarPorDni(dni);
        if (cliente != null) {
            System.out.println(cliente);
        } else {
            System.out.println("=== CLIENTE NO ENCONTRADO ===");
        }
    }

    public static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (Cliente c : clientes) {
                System.out.println(c);
            }
        }
    }

    public static void ordenarClientes(Scanner sc) {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes");
            System.out.println("No se puede ordenar");
            return;
        }

        System.out.println("--> ELIGE LA OPCIÓN PARA ORDENAR TUS CLIENTES <--");
        System.out.println("**** 1 **** Nombre (Orden alfabético)");
        System.out.println("**** 2 **** Apellidos (Oden alfabético)");
        System.out.println("**** 3 **** DNI (Orden numérico)");
        System.out.println("__________________________________________________");
        System.out.print("Opción: ");
        try {
            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar

            switch (opcion) {
                case 1:
                    Collator nombreOrden = Collator.getInstance(new Locale("es", "ES"));
                    nombreOrden.setStrength(Collator.PRIMARY); // Ignora tildes y mayúsculas/minúsculas

                    clientes.sort((c1, c2) -> nombreOrden.compare(c1.getNombre(), c2.getNombre()));

                    break;
                case 2:
                    Collator apellidosOrden = Collator.getInstance(new Locale("es", "ES"));
                    apellidosOrden.setStrength(Collator.PRIMARY); // Ignora tildes y mayúsculas/minúsculas
                    clientes.sort((c1, c2) -> apellidosOrden.compare(c1.getApellidos(), c2.getApellidos()));

                    break;
                case 3:
                    clientes.sort(Comparator.comparing(Cliente::getDni));
                    break;
                default:
                    System.out.println("===ERROR===");
                    System.out.println("===(El número debe ser ente 1 y 3 inclusive)===");
                    return;
                }
            System.out.println("Lista de clientes ordenados alfabéticamente: ");
            listarClientes();
        }catch (InputMismatchException e){
            System.out.println("====ERROR====");
            System.out.println("====(Introduce un número)===");
            sc.nextLine(); // Limpiar para que no se quede pillado
        }
    }
    public static Cliente buscarPorDni(String dni) {
        for (Cliente c : clientes) {
            if (c.getDni().equalsIgnoreCase(dni)) {
                return c;
            }
        }
        return null;
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }
}
