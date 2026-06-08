import java.util.ArrayList;
import java.util.Scanner;

class Libro {

    Scanner teclado = new Scanner(System.in);
    ArrayList<String> libros = new ArrayList<>();

    // 🎨 Colores ANSI
    String RESET = "\u001B[0m";
    String ROJO = "\u001B[31m";
    String VERDE = "\u001B[32m";
    String AMARILLO = "\u001B[33m";
    String AZUL = "\u001B[34m";
    String CIAN = "\u001B[36m";
    String VINO = "\u001B[38;5;52m";

    void menuLibros() {

        int opcion;

        do {

            System.out.println("\n");
            System.out.println(VINO + "====================================" + RESET);
            System.out.println(VINO + "        GESTIÓN DE LIBROS 📚" + RESET);
            System.out.println(VINO + "====================================" + RESET);

            // 🟢 TODAS LAS OPCIONES EN VERDE
            System.out.println(VERDE + "1. Agregar libro" + RESET);
            System.out.println(VERDE + "2. Ver libros agregados" + RESET);

            // 🔴 VOLVER EN ROJO
            System.out.println(ROJO + "3. Volver" + RESET);

            System.out.print(AZUL + "Seleccione una opción: " + RESET);

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print(AMARILLO + "Ingrese el nombre del libro: " + RESET);
                    String nombre = teclado.nextLine();

                    libros.add(nombre);

                    System.out.println(VERDE + "Libro agregado correctamente." + RESET);
                    break;

                case 2:

                    System.out.println(VINO + "\n--- LIBROS AGREGADOS ---" + RESET);

                    if (libros.isEmpty()) {
                        System.out.println(ROJO + "No hay libros registrados." + RESET);
                    } else {

                        for (int i = 0; i < libros.size(); i++) {
                            System.out.println(CIAN + (i + 1) + ". " + libros.get(i) + RESET);
                        }
                    }
                    break;

                case 3:
                    System.out.println(ROJO + "Regresando al menú principal..." + RESET);
                    break;

                default:
                    System.out.println(ROJO + "Opción no válida." + RESET);
            }

        } while (opcion != 3);
    }
}