import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Prestamo {

    Scanner teclado = new Scanner(System.in);
    ArrayList<String> historial = new ArrayList<>();

    // 🎨 PALETA ARMONIOSA (Cian, Blanco y Gris)
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

    void menuPrestamos() {
        int opcion = 0;

        do {
            limpiarPantalla();
            System.out.println("\n");

            System.out.println(CIAN + "╔════════════════════════════════════════════════════════╗" + RESET);
            System.out.println(CIAN + "║" + NEGRITA + BLANCO + "              GESTIÓN DE PRÉSTAMOS 📦                   " + CIAN + "║" + RESET);
            System.out.println(CIAN + "╠════════════════════════════════════════════════════════╣" + RESET);
            System.out.println(CIAN + "║" + CIAN_OSCURO + "  [1] " + BLANCO + "Prestar libro                                     " + CIAN + "║" + RESET);
            System.out.println(CIAN + "║" + CIAN_OSCURO + "  [2] " + BLANCO + "Devolver libro                                    " + CIAN + "║" + RESET);
            System.out.println(CIAN + "║" + CIAN_OSCURO + "  [3] " + BLANCO + "Ver historial de préstamos                        " + CIAN + "║" + RESET);
            System.out.println(CIAN + "║" + ROJO + "  [4] " + BLANCO + "Volver al menú principal                          " + CIAN + "║" + RESET);
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
                    System.out.println(CIAN + "║" + NEGRITA + BLANCO + "                    REGISTRAR PRÉSTAMO                  " + CIAN + "║" + RESET);
                    System.out.println(CIAN + "╚════════════════════════════════════════════════════════╝" + RESET);

                    System.out.print(CIAN + "\n 👤 Nombre del usuario: " + RESET);
                    String usuario = teclado.nextLine();

                    System.out.print(CIAN + " 📚 Nombre del libro: " + RESET);
                    String libro = teclado.nextLine();

                    historial.add(usuario + " -> " + libro);

                    System.out.println(VERDE + "\n ✔ ¡Libro prestado correctamente!" + RESET);
                    pausa();
                    break;

                case 2:
                    limpiarPantalla();
                    System.out.println(CIAN + "╔════════════════════════════════════════════════════════╗" + RESET);
                    System.out.println(CIAN + "║" + NEGRITA + BLANCO + "                    DEVOLUCIÓN DE LIBRO                 " + CIAN + "║" + RESET);
                    System.out.println(CIAN + "╚════════════════════════════════════════════════════════╝" + RESET);

                    System.out.print(CIAN + "\n 🔍 Nombre del libro a devolver: " + RESET);
                    String devolver = teclado.nextLine();

                    boolean encontrado = false;

                    for (int i = 0; i < historial.size(); i++) {
                        if (historial.get(i).contains(devolver)) {
                            historial.remove(i);
                            encontrado = true;
                            System.out.println(VERDE + "\n ✔ ¡Libro devuelto correctamente!" + RESET);
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println(ROJO + "\n [!] No se encontró ningún préstamo con ese libro." + RESET);
                    }

                    pausa();
                    break;

                case 3:
                    limpiarPantalla();
                    System.out.println(CIAN + "╔════════════════════════════════════════════════════════╗" + RESET);
                    System.out.println(CIAN + "║" + NEGRITA + BLANCO + "                 HISTORIAL DE PRÉSTAMOS                 " + CIAN + "║" + RESET);
                    System.out.println(CIAN + "╚════════════════════════════════════════════════════════╝\n" + RESET);

                    if (historial.isEmpty()) {
                        System.out.println(ROJO + " [!] No hay préstamos registrados en el sistema." + RESET);
                    } else {
                        for (int i = 0; i < historial.size(); i++) {
                            System.out.println(CIAN + "  [" + (i + 1) + "] " + BLANCO + historial.get(i) + RESET);
                        }
                    }

                    pausa();
                    break;

                case 4:
                    System.out.println(VERDE + "\nRegresando al menú principal..." + RESET);
                    try { Thread.sleep(600); } catch (Exception e) {}
                    break;

                default:
                    System.out.println(ROJO + "\n[!] Opción no válida. Intente de nuevo." + RESET);
                    pausa();
            }

        } while (opcion != 4);
    }

    private void pausa() {
        System.out.print(GRIS + "\nPresione ENTER para continuar..." + RESET);
        teclado.nextLine();
    }
}