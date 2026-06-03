import java.util.Scanner;

class Usuario {

    Scanner teclado = new Scanner(System.in);

    void menuUsuarios() {

        int opcion;

        do {

            System.out.println("\n--- GESTIÓN DE USUARIOS ---");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Buscar usuario");
            System.out.println("3. Mostrar usuarios");
            System.out.println("4. Volver");
            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("Usuario registrado.");
                    break;

                case 2:
                    System.out.println("Buscar usuario.");
                    break;

                case 3:
                    System.out.println("Lista de usuarios.");
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