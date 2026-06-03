import java.util.Scanner;

class Prestamo {

    Scanner teclado = new Scanner(System.in);

    void menuPrestamos() {

        int opcion;

        do {

            System.out.println("\n--- GESTIÓN DE PRÉSTAMOS ---");
            System.out.println("1. Prestar libro");
            System.out.println("2. Devolver libro");
            System.out.println("3. Historial");
            System.out.println("4. Volver");
            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("Libro prestado.");
                    break;

                case 2:
                    System.out.println("Libro devuelto.");
                    break;

                case 3:
                    System.out.println("Historial de préstamos.");
                    break;

                case 4:
                    System.out.println("Regresando...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 4);
    }
}