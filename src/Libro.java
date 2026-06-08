import java.util.ArrayList;
import java.util.Scanner;

class Libro {

    Scanner teclado = new Scanner(System.in);
    ArrayList<String> libros = new ArrayList<>();

    void menuLibros() {

        int opcion;

        do {

            System.out.println("\n--- GESTIÓN DE LIBROS ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Ver libros agregados");
            System.out.println("3. Volver");
            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Ingrese el nombre del libro: ");
                    String nombre = teclado.nextLine();

                    libros.add(nombre);

                    System.out.println("Libro agregado correctamente.");
                    break;

                case 2:

                    System.out.println("\n--- LIBROS AGREGADOS ---");

                    if (libros.size() == 0) {
                        System.out.println("No hay libros registrados.");
                    } else {

                        for (int i = 0; i < libros.size(); i++) {
                            System.out.println((i + 1) + ". " + libros.get(i));
                        }

                    }
                    break;

                case 3:
                    System.out.println("Regresando...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 3);
    }
}