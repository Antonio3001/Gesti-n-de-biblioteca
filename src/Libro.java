import java.util.Scanner;

class Libro {

    Scanner teclado = new Scanner(System.in);

    void menuLibros() {

        int opcion;

        do {

            System.out.println("\n--- GESTIÓN DE LIBROS ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Buscar libro");
            System.out.println("3. Eliminar libro");
            System.out.println("4. Volver");
            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("Libro agregado.");
                    break;

                case 2:
                    System.out.println("Buscar libro.");
                    break;

                case 3:
                    System.out.println("Libro eliminado.");
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