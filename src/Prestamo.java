import java.util.ArrayList;
import java.util.Scanner;

class Prestamo {

    Scanner teclado = new Scanner(System.in);

    ArrayList<String> historial = new ArrayList<>();

    // 🎨 Colores ANSI
    String RESET = "\u001B[0m";
    String ROJO = "\u001B[31m";
    String VERDE = "\u001B[32m";
    String AMARILLO = "\u001B[33m";
    String AZUL = "\u001B[34m";
    String CIAN = "\u001B[36m";
    String MORADO = "\u001B[35m";
    String VINO = "\u001B[38;5;52m";

    void menuPrestamos() {

        int opcion;

        do {

            System.out.println("\n");
            System.out.println(VINO + "====================================" + RESET);
            System.out.println(VINO + "       GESTIÓN DE PRÉSTAMOS 📦" + RESET);
            System.out.println(VINO + "====================================" + RESET);

            System.out.println(VERDE + "1. Prestar libro" + RESET);
            System.out.println(VERDE + "2. Devolver libro" + RESET);
            System.out.println(VERDE + "3. Historial" + RESET);
            System.out.println(ROJO + "4. Volver" + RESET);

            System.out.print(AZUL + "Seleccione una opción: " + RESET);

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print(AMARILLO + "Nombre del usuario: " + RESET);
                    String usuario = teclado.nextLine();

                    System.out.print(AMARILLO + "Nombre del libro: " + RESET);
                    String libro = teclado.nextLine();

                    historial.add(usuario + " -> " + libro);

                    System.out.println(VERDE + "Libro prestado correctamente." + RESET);
                    break;

                case 2:

                    System.out.print(AMARILLO + "Nombre del libro a devolver: " + RESET);
                    String devolver = teclado.nextLine();

                    boolean encontrado = false;

                    for (int i = 0; i < historial.size(); i++) {

                        if (historial.get(i).contains(devolver)) {

                            historial.remove(i);
                            encontrado = true;

                            System.out.println(VERDE + "Libro devuelto correctamente." + RESET);
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println(ROJO + "No se encontró ese préstamo." + RESET);
                    }

                    break;

                case 3:

                    System.out.println(VINO + "\n--- HISTORIAL DE PRÉSTAMOS ---" + RESET);

                    if (historial.isEmpty()) {

                        System.out.println(ROJO + "No hay préstamos registrados." + RESET);

                    } else {

                        for (String prestamo : historial) {
                            System.out.println(CIAN + prestamo + RESET);
                        }
                    }

                    break;

                case 4:

                    System.out.println(ROJO + "Regresando al menú principal..." + RESET);
                    break;

                default:

                    System.out.println(ROJO + "Opción no válida." + RESET);
            }

        } while (opcion != 4);
    }
}