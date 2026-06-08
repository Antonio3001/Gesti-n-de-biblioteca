import java.util.ArrayList;
import java.util.Scanner;

class Prestamo {

    Scanner teclado = new Scanner(System.in);

    ArrayList<String> historial = new ArrayList<>();

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
            teclado.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Nombre del usuario: ");
                    String usuario = teclado.nextLine();

                    System.out.print("Nombre del libro: ");
                    String libro = teclado.nextLine();

                    historial.add(usuario + " -> " + libro);

                    System.out.println("Libro prestado correctamente.");
                    break;

                case 2:

                    System.out.print("Nombre del libro a devolver: ");
                    String devolver = teclado.nextLine();

                    boolean encontrado = false;

                    for (int i = 0; i < historial.size(); i++) {

                        if (historial.get(i).contains(devolver)) {

                            historial.remove(i);

                            encontrado = true;

                            System.out.println("Libro devuelto correctamente.");
                            break;
                        }
                    }

                    if (!encontrado) {

                        System.out.println("No se encontró ese préstamo.");

                    }

                    break;

                case 3:

                    System.out.println("\n--- HISTORIAL DE PRÉSTAMOS ---");

                    if (historial.isEmpty()) {

                        System.out.println("No hay préstamos registrados.");

                    } else {

                        for (String prestamo : historial) {

                            System.out.println(prestamo);

                        }
                    }

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