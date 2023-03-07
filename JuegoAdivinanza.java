import java.util.Random;
import java.util.Scanner;


public class JuegoAdivinanza implements Runnable {

    private final char letraAdivinar;
    private boolean juegoTerminado;

    public JuegoAdivinanza() {
        Random random = new Random();
        letraAdivinar = (char) (random.nextInt(26) + 'a');
        juegoTerminado = false;
    }

    @Override
    public void run() {
        System.out.println("Adivina una letra entre a y z");
        Scanner scanner = new Scanner(System.in);

        while (!juegoTerminado) {
            char letraIngresada = scanner.next().charAt(0);

            if (letraIngresada == letraAdivinar) {
                System.out.println("¡Felicidades, has adivinado la letra!");
                juegoTerminado = true;
            } else {
                System.out.println("Esa no es la letra correcta, intenta de nuevo");
            }
        }

        scanner.close();
    }
}