import java.util.Scanner;

public class Interfaz {

    Scanner teclado = new Scanner(System.in);

    // ===== COLORES ANSI =====
    public static final String RESET = "\u001B[0m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String MORADO = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BLANCO = "\u001B[37m";
    public static final String NEGRITA = "\u001B[1m";

    // COLOR VINO Y GRIS
    public static final String VINO = "\u001B[38;5;52m";
    public static final String GRIS = "\u001B[38;5;240m";

    // Método seguro para limpiar pantalla en Eclipse mediante saltos de línea
    public void limpiarPantalla() {
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
    }

    public void mostrarMenu() {
        // ===== PANTALLA INICIAL: INGRESAR NOMBRE =====
        limpiarPantalla();
        System.out.println(CYAN + "╔════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "║" + NEGRITA + BLANCO + "                 IDENTIFICACIÓN DE USUARIO              " + CYAN + "║" + RESET);
        System.out.println(CYAN + "╚════════════════════════════════════════════════════════╝" + RESET);
        System.out.print(AZUL + " ➤ Ingrese su nombre para continuar: " + RESET);
        
        String nombreUsuario = teclado.nextLine();
        if (nombreUsuario.trim().isEmpty()) {
            nombreUsuario = "Invitado";
        }

        // ===== REPRODUCIR MÚSICA JUSTO DESPUÉS DE INGRESAR EL NOMBRE =====
        try {
            Musica musica = new Musica();
            musica.reproducir();
        } catch (Exception e) {
            // Evita que falle si la clase Musica no está presente
        }

        int opcion = 0;

        do {
            limpiarPantalla();

            // ===== TÍTULO ESTABLE Y ENMARCADO CON USUARIO ARRIBA =====
            System.out.println(CYAN + "╔════════════════════════════════════════════════════════╗" + RESET);
            System.out.println(CYAN + "║" + NEGRITA + BLANCO + "             SISTEMA DE GESTIÓN DE BIBLIOTECA           " + CYAN + "║" + RESET);
            System.out.println(CYAN + "╠════════════════════════════════════════════════════════╣" + RESET);
            System.out.println(MORADO + "                      PROYECTO FINAL JAVA                 " + RESET);
            System.out.println(GRIS + "  👤 Usuario: " + BLANCO + nombreUsuario + RESET);
            System.out.println(VINO + "--------------------------------------------------------" + RESET);

            System.out.println(VERDE + "  [1] Gestión de Libros" + RESET);
            System.out.println(VERDE + "  [2] Gestión de Usuarios" + RESET);
            System.out.println(VERDE + "  [3] Gestión de Préstamos" + RESET);
            System.out.println(ROJO + "  [4] Salir del sistema" + RESET);

            System.out.println(VINO + "--------------------------------------------------------" + RESET);
            System.out.print(AZUL + " ➤ Seleccione una opción: " + RESET);

            try {
                opcion = teclado.nextInt();
                teclado.nextLine(); // Limpiar el buffer
            } catch (Exception e) {
                System.out.println(ROJO + "\n[!] Error: Debe ingresar un número válido." + RESET);
                teclado.next(); // Limpiar entrada errónea
                opcion = 0;
                
                System.out.println(AZUL + "\nPresione ENTER para continuar..." + RESET);
                teclado.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    Libro libro = new Libro();
                    libro.menuLibros();
                    break;

                case 2:
                    Usuario usuario = new Usuario();
                    usuario.menuUsuarios();
                    break;

                case 3:
                    Prestamo prestamo = new Prestamo();
                    prestamo.menuPrestamos();
                    break;

                case 4:
                    limpiarPantalla();
                    System.out.println(VERDE + "\n¡Gracias por usar el sistema, " + nombreUsuario + "!" + RESET);
                    System.out.println(VERDE + "Hasta pronto.\n" + RESET);
                    try { Thread.sleep(1000); } catch (Exception ex) {}
                    break;

                default:
                    System.out.println(ROJO + "\n[!] Opción no válida." + RESET);
                    System.out.println(AZUL + "\nPresione ENTER para continuar..." + RESET);
                    teclado.nextLine();
            }

        } while (opcion != 4);
    }
}