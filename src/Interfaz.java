import java.util.Scanner;

class Interfaz {

    Scanner teclado = new Scanner(System.in);

    // ===== PALETA CELESTE Y BLANCO =====
    public static final String RESET = "\u001B[0m";
    public static final String NEGRITA = "\u001B[1m";
    
    public static final String CELESTE = "\u001B[38;5;51m";   // Marcos y titulo en celeste
    public static final String BLANCO = "\u001B[37m";                // Textos interiores en blanco

    // Ancho interno fijo para garantizar simetria exacta en Eclipse
    private final int ANCHO = 74;

    public void limpiarPantalla() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
    }

    void mostrarMenu() {
        // ===== PANTALLA INICIAL: IDENTIFICACION =====
        limpiarPantalla();
        String nombreUsuario = "";

        while (true) {
            System.out.println(CELESTE + "╔" + repetirCaracter("═", ANCHO) + "╗" + RESET);
            System.out.println(CELESTE + "║" + NEGRITA + BLANCO + centrar("IDENTIFICACION DE USUARIO", ANCHO) + CELESTE + "║" + RESET);
            System.out.println(CELESTE + "╚" + repetirCaracter("═", ANCHO) + "╝" + RESET);
            System.out.print(BLANCO + " > Ingrese su nombre (ej. alejandro434): " + RESET);
            
            nombreUsuario = teclado.nextLine().trim();

            if (nombreUsuario.isEmpty()) {
                nombreUsuario = "Invitado";
                break;
            } 
            else if (!nombreUsuario.matches("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]+$") || !nombreUsuario.matches(".*[a-zA-ZáéíóúÁÉÍÓÚñÑ].*")) {
                limpiarPantalla();
                System.out.println(BLANCO + "[!] Error: El nombre solo puede incluir letras y numeros (ej. alejandro434).\n" + RESET);
            } else {
                break; 
            }
        }

        // ===== REPRODUCIR MUSICA =====
        try {
            Musica musica = new Musica();
            musica.reproducir();
        } catch (Exception e) {}

        int opcion = 0;

        do {
            limpiarPantalla();

            // ===== BLOQUE SUPERIOR: TITULO EN ARTE ASCII (Perfectamente alineado) =====
            System.out.println(CELESTE + "╔" + repetirCaracter("═", ANCHO) + "╗" + RESET);
            System.out.println(CELESTE + "║" + CELESTE + alinearIzquierda("  ██████╗ ██╗██████╗ ██╗     ██╗ ██████╗ ████████╗███████╗ ██████╗ █████╗  ", ANCHO) + CELESTE + "║" + RESET);
            System.out.println(CELESTE + "║" + CELESTE + alinearIzquierda("  ██╔══██╗██║██╔══██╗██║     ██║██╔═══██╗╚══██╔══╝██╔════╝██╔════╝██╔══██╗ ", ANCHO) + CELESTE + "║" + RESET);
            System.out.println(CELESTE + "║" + CELESTE + alinearIzquierda("  ██████╔╝██║██████╔╝██║     ██║██║   ██║   ██║   █████╗  ██║     ███████║ ", ANCHO) + CELESTE + "║" + RESET);
            System.out.println(CELESTE + "║" + CELESTE + alinearIzquierda("  ██╔══██╗██║██╔══██╗██║     ██║██║   ██║   ██║   ██╔══╝  ██║     ██╔══██║ ", ANCHO) + CELESTE + "║" + RESET);
            System.out.println(CELESTE + "║" + CELESTE + alinearIzquierda("  ██████╔╝██║██████╔╝███████╗██║╚██████╔╝   ██║   ███████╗╚██████╗██║  ██║ ", ANCHO) + CELESTE + "║" + RESET);
            System.out.println(CELESTE + "║" + CELESTE + alinearIzquierda("  ╚═════╝ ╚═╝╚═════╝ ╚══════╝╚═╝ ╚═════╝    ╚═╝   ╚══════╝ ╚═════╝╚═╝  ╚═╝ ", ANCHO) + CELESTE + "║" + RESET);
            System.out.println(CELESTE + "╠" + repetirCaracter("═", ANCHO) + "╣" + RESET);
            System.out.println(CELESTE + "║" + NEGRITA + BLANCO + centrar("SISTEMA DE GESTION DE BIBLIOTECA", ANCHO) + CELESTE + "║" + RESET);
            System.out.println(CELESTE + "╠" + repetirCaracter("═", ANCHO) + "╣" + RESET);
            System.out.println(CELESTE + "║" + NEGRITA + BLANCO + centrar("PROYECTO FINAL JAVA", ANCHO) + CELESTE + "║" + RESET);
            System.out.println(CELESTE + "╚" + repetirCaracter("═", ANCHO) + "╝" + RESET);
            
            // ===== BLOQUE INFERIOR: USUARIO Y OPCIONES =====
            System.out.println(CELESTE + "╔" + repetirCaracter("═", ANCHO) + "╗" + RESET);
            System.out.println(CELESTE + "║" + BLANCO + alinearIzquierda("  Usuario: " + nombreUsuario, ANCHO) + CELESTE + "║" + RESET);
            System.out.println(CELESTE + "╠" + repetirCaracter("═", ANCHO) + "╣" + RESET);
            System.out.println(CELESTE + "║" + BLANCO + alinearIzquierda("  [1] Gestion de Libros", ANCHO) + CELESTE + "║" + RESET);
            System.out.println(CELESTE + "║" + BLANCO + alinearIzquierda("  [2] Gestion de Usuarios", ANCHO) + CELESTE + "║" + RESET);
            System.out.println(CELESTE + "║" + BLANCO + alinearIzquierda("  [3] Gestion de Prestamos", ANCHO) + CELESTE + "║" + RESET);
            System.out.println(CELESTE + "║" + BLANCO + alinearIzquierda("  [4] Salir", ANCHO) + CELESTE + "║" + RESET);
            System.out.println(CELESTE + "╚" + repetirCaracter("═", ANCHO) + "╝" + RESET);
            System.out.print(BLANCO + " > Seleccione una opcion: " + RESET);

            try {
                opcion = teclado.nextInt();
                teclado.nextLine(); 
            } catch (Exception e) {
                System.out.println(BLANCO + "\n[!] Error: Debe ingresar un numero valido." + RESET);
                teclado.next(); 
                opcion = 0;
                
                System.out.println(BLANCO + "\nPresione ENTER para continuar..." + RESET);
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
                    // ===== PANTALLA DE DESPEDIDA ESTILIZADA =====
                    System.out.println(CELESTE + "╔" + repetirCaracter("═", ANCHO) + "╗" + RESET);
                    System.out.println(CELESTE + "║" + NEGRITA + BLANCO + centrar("SISTEMA DE GESTION DE BIBLIOTECA", ANCHO) + CELESTE + "║" + RESET);
                    System.out.println(CELESTE + "╠" + repetirCaracter("═", ANCHO) + "╣" + RESET);
                    System.out.println(CELESTE + "║" + BLANCO + centrar("¡Gracias por utilizar nuestro sistema, " + nombreUsuario + "!", ANCHO) + CELESTE + "║" + RESET);
                    System.out.println(CELESTE + "║" + NEGRITA + CELESTE + centrar("¡Hasta pronto!", ANCHO) + CELESTE + "║" + RESET);
                    System.out.println(CELESTE + "╚" + repetirCaracter("═", ANCHO) + "╝" + RESET);
                    try { Thread.sleep(2500); } catch (Exception ex) {}
                    break;
                default:
                    System.out.println(BLANCO + "\n[!] Opcion no valida. Intente de nuevo." + RESET);
                    try { Thread.sleep(900); } catch (Exception ex) {}
            }

        } while (opcion != 4);
    }

    // Metodos auxiliares compatibles con cualquier version de Java
    private String repetirCaracter(String caracter, int veces) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < veces; i++) {
            sb.append(caracter);
        }
        return sb.toString();
    }

    private String alinearIzquierda(String texto, int ancho) {
        if (texto.length() >= ancho) return texto.substring(0, ancho);
        StringBuilder sb = new StringBuilder(texto);
        while (sb.length() < ancho) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private String centrar(String texto, int ancho) {
        if (texto.length() >= ancho) return texto.substring(0, ancho);
        int totalEspacios = ancho - texto.length();
        int izq = totalEspacios / 2;
        int der = totalEspacios - izq;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < izq; i++) sb.append(" ");
        sb.append(texto);
        for (int i = 0; i < der; i++) sb.append(" ");
        return sb.toString();
    }
}