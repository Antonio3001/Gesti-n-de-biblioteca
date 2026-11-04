import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Usuario {

    Scanner teclado = new Scanner(System.in);
    ArrayList<String> usuarios = new ArrayList<>();

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

    void menuUsuarios() {
        int opcion = 0;

        do {
            limpiarPantalla();
            System.out.println("\n");

            System.out.println(CIAN + "╔════════════════════════════════════════════════════════╗" + RESET);
            System.out.println(CIAN + "║" + NEGRITA + BLANCO + "               GESTIÓN DE USUARIOS 👤                   " + CIAN + "║" + RESET);
            System.out.println(CIAN + "╠════════════════════════════════════════════════════════╣" + RESET);
            System.out.println(CIAN + "║" + CIAN_OSCURO + "  [1] " + BLANCO + "Registrar usuario                                 " + CIAN + "║" + RESET);
            System.out.println(CIAN + "║" + CIAN_OSCURO + "  [2] " + BLANCO + "Eliminar usuario                                  " + CIAN + "║" + RESET);
            System.out.println(CIAN + "║" + CIAN_OSCURO + "  [3] " + BLANCO + "Mostrar usuarios                                  " + CIAN + "║" + RESET);
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
                    System.out.println(CIAN + "║" + NEGRITA + BLANCO + "                  REGISTRAR NUEVO USUARIO               " + CIAN + "║" + RESET);
                    System.out.println(CIAN + "╚════════════════════════════════════════════════════════╝" + RESET);

                    System.out.print(CIAN + "\n ✍ Ingrese el nombre del usuario: " + RESET);
                    String nombre = teclado.nextLine();

                    usuarios.add(nombre);

                    System.out.println(VERDE + "\n ✔ ¡Usuario registrado correctamente!" + RESET);
                    pausa();
                    break;

                case 2:
                    limpiarPantalla();
                    System.out.println(CIAN + "╔════════════════════════════════════════════════════════╗" + RESET);
                    System.out.println(CIAN + "║" + NEGRITA + BLANCO + "                     ELIMINAR USUARIO                   " + CIAN + "║" + RESET);
                    System.out.println(CIAN + "╚════════════════════════════════════════════════════════╝" + RESET);

                    System.out.print(CIAN + "\n 🗑 Ingrese el nombre del usuario a eliminar: " + RESET);
                    String eliminar = teclado.nextLine();

                    if (usuarios.remove(eliminar)) {
                        System.out.println(VERDE + "\n ✔ ¡Usuario eliminado correctamente!" + RESET);
                    } else {
                        System.out.println(ROJO + "\n [!] El usuario no existe en el sistema." + RESET);
                    }

                    pausa();
                    break;

                case 3:
                    limpiarPantalla();
                    System.out.println(CIAN + "╔════════════════════════════════════════════════════════╗" + RESET);
                    System.out.println(CIAN + "║" + NEGRITA + BLANCO + "                USUARIOS REGISTRADOS                    " + CIAN + "║" + RESET);
                    System.out.println(CIAN + "╚════════════════════════════════════════════════════════╝\n" + RESET);

                    if (usuarios.isEmpty()) {
                        System.out.println(ROJO + " [!] No hay usuarios registrados en el sistema." + RESET);
                    } else {
                        for (int i = 0; i < usuarios.size(); i++) {
                            System.out.println(CIAN + "  [" + (i + 1) + "] " + BLANCO + usuarios.get(i) + RESET);
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