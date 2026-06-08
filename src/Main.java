import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("===== SISTEMA DE BIBLIOTECA =====");
        System.out.print("Ingrese su nombre: ");
        String usuario = teclado.nextLine();

        System.out.println("Bienvenido a la biblioteca, " + usuario);

        Musica musica = new Musica();
        musica.reproducir();

        Interfaz interfaz = new Interfaz();
        interfaz.mostrarMenu();
    }
}