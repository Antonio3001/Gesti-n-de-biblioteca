import java.util.Scanner;

class Interfaz {

    Scanner teclado = new Scanner(System.in);

    void mostrarMenu() {

        int opcion;

        do {

            System.out.println("\n===== GESTIÓN DE BIBLIOTECA =====");
            System.out.println("1. Gestión de Libros");
            System.out.println("2. Gestión de Usuarios");
            System.out.println("3. Gestión de Préstamos");
            System.out.println("4. Música");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextInt();

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
                    Musica musica = new Musica();
                    musica.reproducir();
                    break;

                case 5:
                    System.out.println("Gracias por usar el sistema.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);
    }
}