import controlador.ControladorClientes;
import controlador.ControladorCocteles;
import controlador.ControladorVentas;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main de la tienda de cocteles menú principal
 * @author Rubén López
 * @version 1
 */
public class Main {
    /**
     * Metodo para el menú principal
     * @param args argumentos desde el menú principal se accede a otros menús
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        do{
            System.out.println("=|||= MENÚ PRINCIPAL =|||=");
            System.out.println("*** 1 *** Gestión Clientes");
            System.out.println("*** 2 *** Gestión Cócteles");
            System.out.println("*** 3 *** Realizar venta");
            System.out.println("*** 4 *** Mostrar ventas");
            System.out.println("*** 5 *** Salir");
            System.out.println("===== Selecciona tu opción =====");

            try {
                opcion = sc.nextInt();
                sc.nextLine(); // Para que no se quede pillado

                switch (opcion) {
                    case 1:
                        ControladorClientes.menuClientes(sc);
                        break;
                    case 2:
                        ControladorCocteles.menuCocteles(sc);
                        break;
                    case 3:
                        ControladorVentas.realizarVenta(sc);
                        break;
                    case 4:
                        ControladorVentas.menuVentas(sc);
                        break;
                    case 5:
                        System.out.println("Gracias por disfrutar de nuestra coktelería. ¡Vuelve pronto!");
                        break;
                    default:
                        System.out.println("===ERROR===");
                        System.out.println("===(El número debe ser ente 1 y 5 inclusive)===");
                }
            }catch (InputMismatchException e){
                System.out.println("====ERROR====");
                System.out.println("====(Introduce un número)===");
                sc.nextLine(); // Limpiar para que no se quede pillado
            }
        }while (opcion != 5);
        sc.close();
    }
}

