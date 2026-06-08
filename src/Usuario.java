import java.util.ArrayList;
import java.util.Scanner;

class Usuario {

    Scanner teclado = new Scanner(System.in);

    ArrayList<String> usuarios = new ArrayList<>();

    // 🎨 Colores ANSI
    String RESET = "\u001B[0m";
    String ROJO = "\u001B[31m";
    String VERDE = "\u001B[32m";
    String AMARILLO = "\u001B[33m";
    String AZUL = "\u001B[34m";
    String CIAN = "\u001B[36m";
    String VINO = "\u001B[38;5;52m";

    void menuUsuarios() {

        int opcion;

        do {

            System.out.println("\n");
            System.out.println(VINO + "====================================" + RESET);
            System.out.println(VINO + "       GESTIÓN DE USUARIOS 👤" + RESET);
            System.out.println(VINO + "====================================" + RESET);

            System.out.println(VERDE + "1. Registrar usuario" + RESET);
            System.out.println(VERDE + "2. Eliminar usuario" + RESET);
            System.out.println(VERDE + "3. Mostrar usuarios" + RESET);
            System.out.println(ROJO + "4. Volver" + RESET);

            System.out.print(AZUL + "Seleccione una opción: " + RESET);

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print(AMARILLO + "Ingrese el nombre del usuario: " + RESET);
                    String nombre = teclado.nextLine();

                    usuarios.add(nombre);

                    System.out.println(VERDE + "Usuario registrado correctamente." + RESET);
                    break;

                case 2:

                    System.out.print(AMARILLO + "Ingrese el nombre del usuario a eliminar: " + RESET);
                    String eliminar = teclado.nextLine();

                    if (usuarios.remove(eliminar)) {
                        System.out.println(VERDE + "Usuario eliminado correctamente." + RESET);
                    } else {
                        System.out.println(ROJO + "Usuario no existe." + RESET);
                    }

                    break;

                case 3:

                    System.out.println(VINO + "\n--- USUARIOS REGISTRADOS ---" + RESET);

                    if (usuarios.isEmpty()) {
                        System.out.println(ROJO + "No hay usuarios registrados." + RESET);
                    } else {
                        for (String usuario : usuarios) {
                            System.out.println(CIAN + "- " + usuario + RESET);
                        }
                    }

                    break;

                case 4:
                    System.out.println(ROJO + "Regresando..." + RESET);
                    break;

                default:
                    System.out.println(ROJO + "Opción no válida." + RESET);
            }

        } while (opcion != 4);
    }
}