import java.util.Scanner;

class Interfaz {

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

// 🍷 COLOR VINO  
public static final String VINO = "\u001B[38;5;52m";  

void mostrarMenu() {  

    Musica musica = new Musica();  
    musica.reproducir();  

    int opcion;  

    do {  

        System.out.println("\n");  

        // ===== TÍTULO =====  
        System.out.println(CYAN + "██████╗ ██╗██████╗ ██╗     ██╗ ██████╗ ████████╗███████╗ ██████╗ █████╗ " + RESET);  
        System.out.println(CYAN + "██╔══██╗██║██╔══██╗██║     ██║██╔═══██╗╚══██╔══╝██╔════╝██╔════╝██╔══██╗" + RESET);  
        System.out.println(CYAN + "██████╔╝██║██████╔╝██║     ██║██║   ██║   ██║   █████╗  ██║     ███████║" + RESET);  
        System.out.println(CYAN + "██╔══██╗██║██╔══██╗██║     ██║██║   ██║   ██║   ██╔══╝  ██║     ██╔══██║" + RESET);  
        System.out.println(CYAN + "██████╔╝██║██████╔╝███████╗██║╚██████╔╝   ██║   ███████╗╚██████╗██║  ██║" + RESET);  
        System.out.println(CYAN + "╚═════╝ ╚═╝╚═════╝ ╚══════╝╚═╝ ╚═════╝    ╚═╝   ╚══════╝ ╚═════╝╚═╝  ╚═╝" + RESET);  

        System.out.println(VINO + "====================================================" + RESET);  
        System.out.println(VINO + NEGRITA + "           SISTEMA DE GESTIÓN DE BIBLIOTECA" + RESET);  
        System.out.println(VINO + "====================================================" + RESET);  

        System.out.println(MORADO + "               PROYECTO FINAL JAVA" + RESET);  
        System.out.println(VINO + "----------------------------------------------------" + RESET);  

        System.out.println(VERDE + " 1. Gestión de Libros" + RESET);  
        System.out.println(VERDE + " 2. Gestión de Usuarios" + RESET);  
        System.out.println(VERDE + " 3. Gestión de Préstamos" + RESET);  
        System.out.println(ROJO +  " 4. Salir" + RESET);  

        System.out.println(VINO + "----------------------------------------------------" + RESET);  
        System.out.print(AZUL + " Seleccione una opción: " + RESET);  

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
                System.out.println(VERDE + "\nGracias por usar el sistema." + RESET);  
                System.out.println(VERDE + "Hasta pronto." + RESET);  
                break;  

            default:  
                System.out.println(ROJO + "\nOpción no válida." + RESET);  
        }  

    } while (opcion != 4);  
}

}