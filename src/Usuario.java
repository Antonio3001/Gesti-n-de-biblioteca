import java.util.ArrayList;
import java.util.Scanner;

class Usuario {

    Scanner teclado = new Scanner(System.in);

    ArrayList<String> usuarios = new ArrayList<>();

    void menuUsuarios() {

        int opcion;

        do {

            System.out.println("\n--- GESTIÓN DE USUARIOS ---");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Eliminar usuario");
            System.out.println("3. Mostrar usuarios");
            System.out.println("4. Volver");
            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombre = teclado.nextLine();

                    usuarios.add(nombre);

                    System.out.println("Usuario registrado correctamente.");
                    break;

                case 2:

                    System.out.print("Ingrese el nombre del usuario a eliminar: ");
                    String eliminar = teclado.nextLine();

                    if (usuarios.remove(eliminar)) {
                        System.out.println("Usuario eliminado.");
                    } else {
                        System.out.println("Usuario no existe.");
                    }

                    break;

                case 3:

                    System.out.println("\n--- USUARIOS REGISTRADOS ---");

                    if (usuarios.isEmpty()) {
                        System.out.println("No hay usuarios registrados.");
                    } else {
                        for (String usuario : usuarios) {
                            System.out.println("- " + usuario);
                        }
                    }

                    break;

                case 4:
                    System.out.println("Regresando...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 4);
    }
}