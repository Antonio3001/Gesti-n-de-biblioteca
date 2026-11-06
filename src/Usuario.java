import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Usuario {

    Scanner teclado = new Scanner(System.in);
    ArrayList<String> usuarios = new ArrayList<>();

    // 🎨 PALETA UNIFICADA
    public static final String RESET = "\u001B[0m";
    public static final String CIAN = "\u001B[36m";
    public static final String BLANCO = "\u001B[37m";
    public static final String NEGRITA = "\u001B[1m";
    public static final String VERDE = "\u001B[32m";
    public static final String ROJO = "\u001B[31m";

    // 📌 Ancho estricto de 84 caracteres para perfecta simetría
    private final int ANCHO = 84;

    public Usuario() {
        usuarios.add("Ana Gomez");
        usuarios.add("Carlos Ruiz");
        usuarios.add("Maria Perez");
    }

    public void limpiarPantalla() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
    }

    void menuUsuarios() {
        int opcion = 0;

        do {
            limpiarPantalla();

            // ===== MENU DE GESTION DE USUARIOS =====
            System.out.println(CIAN + "╔" + repetirCaracter("═", ANCHO) + "╗" + RESET);
            System.out.println(CIAN + "║" + NEGRITA + BLANCO + centrar("GESTION DE USUARIOS", ANCHO) + CIAN + "║" + RESET);
            System.out.println(CIAN + "╠" + repetirCaracter("═", ANCHO) + "╣" + RESET);
            System.out.println(CIAN + "║" + BLANCO + alinearIzquierda("  [1] Agregar usuario", ANCHO) + CIAN + "║" + RESET);
            System.out.println(CIAN + "║" + BLANCO + alinearIzquierda("  [2] Eliminar usuario", ANCHO) + CIAN + "║" + RESET);
            System.out.println(CIAN + "║" + BLANCO + alinearIzquierda("  [3] Mostrar usuarios", ANCHO) + CIAN + "║" + RESET);
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
                    System.out.println(CIAN + "║" + NEGRITA + BLANCO + centrar("AGREGAR NUEVO USUARIO", ANCHO) + CIAN + "║" + RESET);
                    System.out.println(CIAN + "╚" + repetirCaracter("═", ANCHO) + "╝" + RESET);

                    System.out.print(CIAN + "\n > Ingrese el nombre del usuario: " + RESET);
                    String nombre = teclado.nextLine().trim();

                    if (nombre.isEmpty()) {
                        System.out.println(ROJO + "\n[!] Error: El campo no puede estar vacio." + RESET);
                    } else {
                        // Verificamos si el usuario ya existe (ignorando mayusculas/minusculas)
                        boolean existe = false;
                        for (String u : usuarios) {
                            if (u.equalsIgnoreCase(nombre)) {
                                existe = true;
                                break;
                            }
                        }

                        if (existe) {
                            System.out.println(ROJO + "\n[!] Error: Ya existe un usuario registrado con ese nombre." + RESET);
                        } else {
                            usuarios.add(nombre);
                            System.out.println(VERDE + "\n [OK] Usuario agregado correctamente!" + RESET);
                        }
                    }
                    try { Thread.sleep(1500); } catch (Exception e) {}
                    break;

                case 2:
                    limpiarPantalla();
                    System.out.println(CIAN + "╔" + repetirCaracter("═", ANCHO) + "╗" + RESET);
                    System.out.println(CIAN + "║" + NEGRITA + BLANCO + centrar("ELIMINAR USUARIO - USUARIOS ACTIVOS", ANCHO) + CIAN + "║" + RESET);
                    System.out.println(CIAN + "╠" + repetirCaracter("═", ANCHO) + "╣" + RESET);

                    if (usuarios.isEmpty()) {
                        String vacioItem = "  - No hay usuarios registrados en el sistema.";
                        System.out.println(CIAN + "║" + BLANCO + alinearIzquierda(vacioItem, ANCHO) + CIAN + "║" + RESET);
                        System.out.println(CIAN + "╚" + repetirCaracter("═", ANCHO) + "╝" + RESET);
                        try { Thread.sleep(1500); } catch (Exception e) {}
                        break;
                    } else {
                        for (int i = 0; i < usuarios.size(); i++) {
                            String itemUsuario = "  - [" + (i + 1) + "] " + usuarios.get(i);
                            System.out.println(CIAN + "║" + BLANCO + alinearIzquierda(itemUsuario, ANCHO) + CIAN + "║" + RESET);
                        }
                    }
                    System.out.println(CIAN + "╚" + repetirCaracter("═", ANCHO) + "╝" + RESET);

                    System.out.print(CIAN + "\n > Ingrese el numero del usuario a eliminar: " + RESET);
                    try {
                        int indiceAEliminar = teclado.nextInt();
                        teclado.nextLine();

                        if (indiceAEliminar >= 1 && indiceAEliminar <= usuarios.size()) {
                            String eliminado = usuarios.remove(indiceAEliminar - 1);
                            System.out.println(VERDE + "\n [OK] Usuario (" + eliminado + ") eliminado correctamente!" + RESET);
                        } else {
                            System.out.println(ROJO + "\n [!] Numero de usuario no valido." + RESET);
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
                    System.out.println(CIAN + "║" + NEGRITA + BLANCO + centrar("USUARIOS REGISTRADOS", ANCHO) + CIAN + "║" + RESET);
                    System.out.println(CIAN + "╠" + repetirCaracter("═", ANCHO) + "╣" + RESET);

                    if (usuarios.isEmpty()) {
                        String vacioItem = "  - No hay usuarios registrados en el sistema.";
                        System.out.println(CIAN + "║" + BLANCO + alinearIzquierda(vacioItem, ANCHO) + CIAN + "║" + RESET);
                    } else {
                        for (int i = 0; i < usuarios.size(); i++) {
                            String item = "  - " + usuarios.get(i);
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