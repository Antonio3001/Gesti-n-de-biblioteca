import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Libro {

    Scanner teclado = new Scanner(System.in);
    ArrayList<String> libros = new ArrayList<>();

    // 🎨 PALETA UNIFICADA (Cian, Blanco y Gris)
    public static final String RESET = "\u001B[0m";
    public static final String CIAN = "\u001B[36m";
    public static final String CIAN_OSCURO = "\u001B[38;5;30m";
    public static final String BLANCO = "\u001B[37m";
    public static final String NEGRITA = "\u001B[1m";
    public static final String GRIS = "\u001B[38;5;240m";
    public static final String VERDE = "\u001B[32m";
    public static final String ROJO = "\u001B[31m";

    public void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    void menuLibros() {
        int opcion = 0;

        do {
            limpiarPantalla();
            System.out.println("\n");

            // ===== CAJA CON ESTILO ARMONIOSO (TONOS CIAN/AZUL) =====
            System.out.println(CIAN + "╔════════════════════════════════════════════════════════╗" + RESET);
            System.out.println(CIAN + "║" + NEGRITA + BLANCO + "                 GESTIÓN DE LIBROS 📚                   " + CIAN + "║" + RESET);
            System.out.println(CIAN + "╠════════════════════════════════════════════════════════╣" + RESET);
            System.out.println(CIAN + "║" + CIAN_OSCURO + "  [1] " + BLANCO + "Agregar libro                                     " + CIAN + "║" + RESET);
            System.out.println(CIAN + "║" + CIAN_OSCURO + "  [2] " + BLANCO + "Ver libros agregados                              " + CIAN + "║" + RESET);
            System.out.println(CIAN + "║" + ROJO + "  [3] " + BLANCO + "Volver al menú principal                          " + CIAN + "║" + RESET);
            System.out.println(CIAN + "╚════════════════════════════════════════════════════════╝" + RESET);

            System.out.print(CIAN + NEGRITA + " ➤ Seleccione una opción: " + RESET);

            try {
                opcion = teclado.nextInt();
                teclado.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(ROJO + "\n[!] Error: Debe ingresar un número válido." + RESET);
                teclado.next();
                opcion = 0;
                pausa();
                continue;
            }

            switch (opcion) {
                case 1:
                    limpiarPantalla();
                    System.out.println(CIAN + "╔════════════════════════════════════════════════════════╗" + RESET);
                    System.out.println(CIAN + "║" + NEGRITA + BLANCO + "                  REGISTRAR NUEVO LIBRO                 " + CIAN + "║" + RESET);
                    System.out.println(CIAN + "╚════════════════════════════════════════════════════════╝" + RESET);
                    
                    System.out.print(CIAN + "\n ✍ Ingrese el nombre del libro: " + RESET);
                    String nombre = teclado.nextLine();

                    libros.add(nombre);

                    System.out.println(VERDE + "\n ✔ ¡Libro agregado correctamente!" + RESET);
                    pausa();
                    break;

                case 2:
                    limpiarPantalla();
                    System.out.println(CIAN + "╔════════════════════════════════════════════════════════╗" + RESET);
                    System.out.println(CIAN + "║" + NEGRITA + BLANCO + "                 LISTA DE LIBROS REGISTRADOS            " + CIAN + "║" + RESET);
                    System.out.println(CIAN + "╚════════════════════════════════════════════════════════╝\n" + RESET);

                    if (libros.isEmpty()) {
                        System.out.println(ROJO + " [!] No hay libros registrados en el sistema." + RESET);
                    } else {
                        for (int i = 0; i < libros.size(); i++) {
                            System.out.println(CIAN + "  [" + (i + 1) + "] " + BLANCO + libros.get(i) + RESET);
                        }
                    }
                    pausa();
                    break;

                case 3:
                    System.out.println(VERDE + "\nRegresando al menú principal..." + RESET);
                    try { Thread.sleep(600); } catch (Exception e) {}
                    break;

                default:
                    System.out.println(ROJO + "\n[!] Opción no válida. Intente de nuevo." + RESET);
                    pausa();
            }

        } while (opcion != 3);
    }

    private void pausa() {
        System.out.print(GRIS + "\nPresione ENTER para continuar..." + RESET);
        teclado.nextLine();
    }
}