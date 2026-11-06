import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Prestamo {

    Scanner teclado = new Scanner(System.in);
    ArrayList<String> historial = new ArrayList<>();

    // 🎨 PALETA UNIFICADA
    public static final String RESET = "\u001B[0m";
    public static final String CIAN = "\u001B[36m";
    public static final String BLANCO = "\u001B[37m";
    public static final String NEGRITA = "\u001B[1m";
    public static final String VERDE = "\u001B[32m";
    public static final String ROJO = "\u001B[31m";

    // 📌 Ancho estricto de 84 caracteres para perfecta simetría en la consola
    private final int ANCHO = 84;

    public void limpiarPantalla() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
    }

    private ArrayList<String> obtenerUsuariosDisponibles() {
        ArrayList<String> usuariosEjemplo = new ArrayList<>();
        usuariosEjemplo.add("Ana Gomez");
        usuariosEjemplo.add("Carlos Ruiz");
        usuariosEjemplo.add("Maria Perez");
        return usuariosEjemplo;
    }

    private ArrayList<String> obtenerLibrosDisponibles() {
        ArrayList<String> librosEjemplo = new ArrayList<>();
        librosEjemplo.add("Don Quijote - M. de Cervantes");
        librosEjemplo.add("Cien anos de soledad - G. Garcia");
        librosEjemplo.add("El Principito - A. de Saint-Exupery");
        librosEjemplo.add("Crimen y castigo - F. Dostoyevski");
        return librosEjemplo;
    }

    void menuPrestamos() {
        int opcion = 0;

        do {
            limpiarPantalla();

            // ===== MENU DE GESTION DE PRESTAMOS =====
            System.out.println(CIAN + "╔" + repetirCaracter("═", ANCHO) + "╗" + RESET);
            System.out.println(CIAN + "║" + NEGRITA + BLANCO + centrar("GESTION DE PRESTAMOS", ANCHO) + CIAN + "║" + RESET);
            System.out.println(CIAN + "╠" + repetirCaracter("═", ANCHO) + "╣" + RESET);
            System.out.println(CIAN + "║" + BLANCO + alinearIzquierda("  [1] Prestar libro", ANCHO) + CIAN + "║" + RESET);
            System.out.println(CIAN + "║" + BLANCO + alinearIzquierda("  [2] Devolver libro", ANCHO) + CIAN + "║" + RESET);
            System.out.println(CIAN + "║" + BLANCO + alinearIzquierda("  [3] Ver historial de prestamos", ANCHO) + CIAN + "║" + RESET);
            System.out.println(CIAN + "║" + BLANCO + alinearIzquierda("  [4] Volver al menu principal", ANCHO) + CIAN + "║" + RESET);
            System.out.println(CIAN + "╚" + repetirCaracter("═", ANCHO) + "╝" + RESET);

            System.out.print(CIAN + NEGRITA + " > Seleccione una opcion: " + RESET);

            try {
                opcion = teclado.nextInt();
                teclado.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(ROJO + "\n[!] Error: Debe ingresar un numero valido." + RESET);
                teclado.next();
                opcion = 0;
                try { Thread.sleep(900); } catch (Exception ex) {}
                continue;
            }

            switch (opcion) {
                case 1:
                    limpiarPantalla();
                    System.out.println(CIAN + "╔" + repetirCaracter("═", ANCHO) + "╗" + RESET);
                    System.out.println(CIAN + "║" + NEGRITA + BLANCO + centrar("REGISTRAR PRESTAMO - SELECCION DE USUARIO", ANCHO) + CIAN + "║" + RESET);
                    System.out.println(CIAN + "╠" + repetirCaracter("═", ANCHO) + "╣" + RESET);

                    ArrayList<String> listaUsuarios = obtenerUsuariosDisponibles();
                    for (int i = 0; i < listaUsuarios.size(); i++) {
                        String itemUsuario = "  - [" + (i + 1) + "] " + listaUsuarios.get(i);
                        System.out.println(CIAN + "║" + BLANCO + alinearIzquierda(itemUsuario, ANCHO) + CIAN + "║" + RESET);
                    }
                    System.out.println(CIAN + "╚" + repetirCaracter("═", ANCHO) + "╝" + RESET);

                    System.out.print(CIAN + "\n > Ingrese el numero del usuario: " + RESET);
                    int indexUsuario = -1;
                    try {
                        indexUsuario = teclado.nextInt();
                        teclado.nextLine();
                    } catch (InputMismatchException e) {
                        teclado.next();
                        System.out.println(ROJO + "\n[!] Entrada no valida." + RESET);
                        try { Thread.sleep(1200); } catch (Exception ex) {}
                        break;
                    }

                    if (indexUsuario < 1 || indexUsuario > listaUsuarios.size()) {
                        System.out.println(ROJO + "\n[!] Error: Numero de usuario fuera de rango." + RESET);
                        try { Thread.sleep(1500); } catch (Exception e) {}
                        break;
                    }
                    String usuarioSeleccionado = listaUsuarios.get(indexUsuario - 1);

                    // --- SELECCION DE LIBRO ---
                    limpiarPantalla();
                    System.out.println(CIAN + "╔" + repetirCaracter("═", ANCHO) + "╗" + RESET);
                    System.out.println(CIAN + "║" + NEGRITA + BLANCO + centrar("REGISTRAR PRESTAMO - SELECCION DE LIBRO", ANCHO) + CIAN + "║" + RESET);
                    System.out.println(CIAN + "╠" + repetirCaracter("═", ANCHO) + "╣" + RESET);

                    ArrayList<String> listaLibros = obtenerLibrosDisponibles();
                    for (int i = 0; i < listaLibros.size(); i++) {
                        String itemLibro = "  - [" + (i + 1) + "] " + listaLibros.get(i);
                        System.out.println(CIAN + "║" + BLANCO + alinearIzquierda(itemLibro, ANCHO) + CIAN + "║" + RESET);
                    }
                    System.out.println(CIAN + "╚" + repetirCaracter("═", ANCHO) + "╝" + RESET);

                    System.out.print(CIAN + "\n > Ingrese el numero del libro a prestar: " + RESET);
                    int indexLibro = -1;
                    try {
                        indexLibro = teclado.nextInt();
                        teclado.nextLine();
                    } catch (InputMismatchException e) {
                        teclado.next();
                        System.out.println(ROJO + "\n[!] Entrada no valida." + RESET);
                        try { Thread.sleep(1200); } catch (Exception ex) {}
                        break;
                    }

                    if (indexLibro < 1 || indexLibro > listaLibros.size()) {
                        System.out.println(ROJO + "\n[!] Error: Numero de libro fuera de rango." + RESET);
                        try { Thread.sleep(1500); } catch (Exception e) {}
                        break;
                    }
                    String libroSeleccionado = listaLibros.get(indexLibro - 1);

                    historial.add(usuarioSeleccionado + " -> " + libroSeleccionado);
                    System.out.println(VERDE + "\n [OK] Libro prestado correctamente a " + usuarioSeleccionado + "!" + RESET);
                    try { Thread.sleep(1800); } catch (Exception e) {}
                    break;

                case 2:
                    limpiarPantalla();
                    System.out.println(CIAN + "╔" + repetirCaracter("═", ANCHO) + "╗" + RESET);
                    System.out.println(CIAN + "║" + NEGRITA + BLANCO + centrar("DEVOLUCION DE LIBRO - PRESTAMOS ACTIVOS", ANCHO) + CIAN + "║" + RESET);
                    System.out.println(CIAN + "╠" + repetirCaracter("═", ANCHO) + "╣" + RESET);

                    if (historial.isEmpty()) {
                        String vacioItem = "  - No hay prestamos activos en este momento.";
                        System.out.println(CIAN + "║" + BLANCO + alinearIzquierda(vacioItem, ANCHO) + CIAN + "║" + RESET);
                        System.out.println(CIAN + "╚" + repetirCaracter("═", ANCHO) + "╝" + RESET);
                        try { Thread.sleep(1500); } catch (Exception e) {}
                        break;
                    } else {
                        for (int i = 0; i < historial.size(); i++) {
                            String itemPrestamo = "  - [" + (i + 1) + "] " + historial.get(i);
                            System.out.println(CIAN + "║" + BLANCO + alinearIzquierda(itemPrestamo, ANCHO) + CIAN + "║" + RESET);
                        }
                    }
                    System.out.println(CIAN + "╚" + repetirCaracter("═", ANCHO) + "╝" + RESET);

                    System.out.print(CIAN + "\n > Ingrese el numero del prestamo a devolver: " + RESET);
                    try {
                        int indexDevolucion = teclado.nextInt();
                        teclado.nextLine();

                        if (indexDevolucion >= 1 && indexDevolucion <= historial.size()) {
                            String devuelto = historial.remove(indexDevolucion - 1);
                            System.out.println(VERDE + "\n [OK] Libro devuelto correctamente!" + RESET);
                        } else {
                            System.out.println(ROJO + "\n [!] Numero de prestamo no valido." + RESET);
                        }
                    } catch (InputMismatchException e) {
                        teclado.next();
                        System.out.println(ROJO + "\n [!] Debe ingresar un numero valido." + RESET);
                    }
                    try { Thread.sleep(1500); } catch (Exception e) {}
                    break;

                case 3:
                    limpiarPantalla();
                    System.out.println(CIAN + "╔" + repetirCaracter("═", ANCHO) + "╗" + RESET);
                    System.out.println(CIAN + "║" + NEGRITA + BLANCO + centrar("HISTORIAL DE PRESTAMOS", ANCHO) + CIAN + "║" + RESET);
                    System.out.println(CIAN + "╠" + repetirCaracter("═", ANCHO) + "╣" + RESET);

                    if (historial.isEmpty()) {
                        String vacioItem = "  - No hay prestamos registrados en el sistema.";
                        System.out.println(CIAN + "║" + BLANCO + alinearIzquierda(vacioItem, ANCHO) + CIAN + "║" + RESET);
                    } else {
                        for (int i = 0; i < historial.size(); i++) {
                            String item = "  - " + historial.get(i);
                            System.out.println(CIAN + "║" + BLANCO + alinearIzquierda(item, ANCHO) + CIAN + "║" + RESET);
                        }
                    }
                    System.out.println(CIAN + "╠" + repetirCaracter("═", ANCHO) + "╣" + RESET);
                    System.out.println(CIAN + "║" + BLANCO + alinearIzquierda("  [1] Regresar al menu anterior", ANCHO) + CIAN + "║" + RESET);
                    System.out.println(CIAN + "╚" + repetirCaracter("═", ANCHO) + "╝" + RESET);

                    int subOpcion = -1;
                    while (subOpcion != 1) {
                        System.out.print(CIAN + NEGRITA + " > Ingrese 1 para regresar: " + RESET);
                        try {
                            subOpcion = teclado.nextInt();
                            teclado.nextLine();
                            if (subOpcion != 1) {
                                System.out.println(ROJO + "[!] Ingrese 1 para volver." + RESET);
                            }
                        } catch (InputMismatchException e) {
                            teclado.next();
                            System.out.println(ROJO + "[!] Debe ingresar un numero valido." + RESET);
                        }
                    }
                    break;

                case 4:
                    System.out.println(VERDE + "\nRegresando al menu principal..." + RESET);
                    try { Thread.sleep(600); } catch (Exception e) {}
                    break;

                default:
                    System.out.println(ROJO + "\n[!] Opcion no valida. Intente de nuevo." + RESET);
                    try { Thread.sleep(900); } catch (Exception e) {}
            }

        } while (opcion != 4);
    }

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