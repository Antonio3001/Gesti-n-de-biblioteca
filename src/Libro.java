import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Libro {

    Scanner teclado = new Scanner(System.in);
    
    // Lista estatica para mantener los libros registrados entre instancias
    private static ArrayList<String> listaLibros = new ArrayList<>();
    private static ArrayList<String> listaAutores = new ArrayList<>();
    private static ArrayList<String> listaGeneros = new ArrayList<>();

    // Bloque estatico para inicializar los libros de ejemplo por defecto
    static {
        if (listaLibros.isEmpty()) {
            listaLibros.add("Don Quijote de la Mancha");
            listaAutores.add("M. de Cervantes");
            listaGeneros.add("Clasico");

            listaLibros.add("Cien anos de soledad");
            listaAutores.add("G. Garcia Marquez");
            listaGeneros.add("Realismo Magico");

            listaLibros.add("El Principito");
            listaAutores.add("A. de Saint-Exupery");
            listaGeneros.add("Fabula");

            listaLibros.add("Crimen y castigo");
            listaAutores.add("Fiodor Dostoyevski");
            listaGeneros.add("Psicologica");
        }
    }

    // 🎨 PALETA UNIFICADA
    public static final String RESET = "\u001B[0m";
    public static final String CIAN = "\u001B[36m";
    public static final String BLANCO = "\u001B[37m";
    public static final String NEGRITA = "\u001B[1m";
    public static final String VERDE = "\u001B[32m";
    public static final String ROJO = "\u001B[31m";

    // 📌 Ancho estricto de 84 caracteres para perfecta simetria
    private final int ANCHO = 84;

    public void limpiarPantalla() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
    }

    void menuLibros() {
        int opcion = 0;

        do {
            limpiarPantalla();

            // ===== MENU DE GESTION DE LIBROS =====
            System.out.println(CIAN + "╔" + repetirCaracter("═", ANCHO) + "╗" + RESET);
            System.out.println(CIAN + "║" + NEGRITA + BLANCO + centrar("GESTION DE LIBROS", ANCHO) + CIAN + "║" + RESET);
            System.out.println(CIAN + "╠" + repetirCaracter("═", ANCHO) + "╣" + RESET);
            System.out.println(CIAN + "║" + BLANCO + alinearIzquierda("  [1] Agregar o crear libro", ANCHO) + CIAN + "║" + RESET);
            System.out.println(CIAN + "║" + BLANCO + alinearIzquierda("  [2] Ver libros agregados", ANCHO) + CIAN + "║" + RESET);
            System.out.println(CIAN + "║" + BLANCO + alinearIzquierda("  [3] Volver al menu principal", ANCHO) + CIAN + "║" + RESET);
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
                    System.out.println(CIAN + "║" + NEGRITA + BLANCO + centrar("REGISTRAR NUEVO LIBRO", ANCHO) + CIAN + "║" + RESET);
                    System.out.println(CIAN + "╚" + repetirCaracter("═", ANCHO) + "╝" + RESET);

                    System.out.print(CIAN + "\n > Ingrese el nombre del libro: " + RESET);
                    String titulo = teclado.nextLine().trim();

                    System.out.print(CIAN + " > Ingrese el autor del libro: " + RESET);
                    String autor = teclado.nextLine().trim();

                    System.out.print(CIAN + " > Ingrese el tipo o genero: " + RESET);
                    String genero = teclado.nextLine().trim();

                    if (titulo.isEmpty() || autor.isEmpty() || genero.isEmpty()) {
                        System.out.println(ROJO + "\n[!] Error: Todos los campos son obligatorios." + RESET);
                    } else {
                        listaLibros.add(titulo);
                        listaAutores.add(autor);
                        listaGeneros.add(genero);
                        System.out.println(VERDE + "\n [OK] ¡Libro creado y registrado correctamente!" + RESET);
                    }
                    try { Thread.sleep(1500); } catch (Exception e) {}
                    break;

                case 2:
                    limpiarPantalla();
                    System.out.println(CIAN + "╔" + repetirCaracter("═", ANCHO) + "╗" + RESET);
                    System.out.println(CIAN + "║" + NEGRITA + BLANCO + centrar("LISTA DE LIBROS REGISTRADOS", ANCHO) + CIAN + "║" + RESET);
                    System.out.println(CIAN + "╠" + repetirCaracter("═", ANCHO) + "╣" + RESET);

                    if (listaLibros.isEmpty()) {
                        String vacioItem = "  - No hay libros registrados en el sistema.";
                        System.out.println(CIAN + "║" + BLANCO + alinearIzquierda(vacioItem, ANCHO) + CIAN + "║" + RESET);
                    } else {
                        for (int i = 0; i < listaLibros.size(); i++) {
                            String item = "  - " + listaLibros.get(i) + " | Autor: " + listaAutores.get(i) + " | Genero: " + listaGeneros.get(i);
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

                case 3:
                    System.out.println(VERDE + "\nRegresando al menu principal..." + RESET);
                    try { Thread.sleep(600); } catch (Exception e) {}
                    break;

                default:
                    System.out.println(ROJO + "\n[!] Opcion no valida. Intente de nuevo." + RESET);
                    try { Thread.sleep(900); } catch (Exception e) {}
            }

        } while (opcion != 3);
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