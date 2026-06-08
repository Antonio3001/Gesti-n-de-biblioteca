import java.util.Scanner;

class Interfaz {

    Scanner teclado = new Scanner(System.in);

    void mostrarMenu() {

        Musica musica = new Musica();
        musica.reproducir();

        int opcion;

        do {

            System.out.println("\n");
            System.out.println("██████╗ ██╗██████╗ ██╗     ██╗ ██████╗ ████████╗███████╗ ██████╗ █████╗ ");
            System.out.println("██╔══██╗██║██╔══██╗██║     ██║██╔═══██╗╚══██╔══╝██╔════╝██╔════╝██╔══██╗");
            System.out.println("██████╔╝██║██████╔╝██║     ██║██║   ██║   ██║   █████╗  ██║     ███████║");
            System.out.println("██╔══██╗██║██╔══██╗██║     ██║██║   ██║   ██║   ██╔══╝  ██║     ██╔══██║");
            System.out.println("██████╔╝██║██████╔╝███████╗██║╚██████╔╝   ██║   ███████╗╚██████╗██║  ██║");
            System.out.println("╚═════╝ ╚═╝╚═════╝ ╚══════╝╚═╝ ╚═════╝    ╚═╝   ╚══════╝ ╚═════╝╚═╝  ╚═╝");

            System.out.println("\n====================================================");
            System.out.println("           SISTEMA DE GESTIÓN DE BIBLIOTECA");
            System.out.println("====================================================");
            System.out.println("               PROYECTO FINAL JAVA");
            System.out.println("----------------------------------------------------");
            System.out.println(" 1. Gestión de Libros");
            System.out.println(" 2. Gestión de Usuarios");
            System.out.println(" 3. Gestión de Préstamos");
            System.out.println(" 4. Salir");
            System.out.println("----------------------------------------------------");
            System.out.print(" Seleccione una opción: ");

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
                    System.out.println("\nGracias por usar el sistema.");
                    System.out.println("Hasta pronto.");
                    break;

                default:
                    System.out.println("\nOpción no válida.");
            }

        } while (opcion != 4);
    }
}