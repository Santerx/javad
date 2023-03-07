import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        System.out.print("Ingrese la ruta de la canción: ");
        String archivo = "C:/Users/PC/Documents/javas/viva.wav";

        Reproductor reproductor = new Reproductor(archivo);
        reproductor.reproducir();

        System.out.println("La canción se está reproduciendo.\n");

        reproductor.detener();

        
        System.out.println("\nTemporizador iniciando.\n");
        Temporizador temporizador = new Temporizador();
        temporizador.start();
        
        System.out.println("\nLetra de la cancion\n");
        HiloLetra hilo = new HiloLetra();
        hilo.start();
        
        System.out.println("\nUn juego\n");
        JuegoAdivinanza juego = new JuegoAdivinanza();
        Thread hiloJuego = new Thread(juego);
        hiloJuego.start();
    }
}

class HiloLetra extends Thread {
    @Override
    public void run() {
        try {
            // Leer el archivo de texto con la letra de la canción
            BufferedReader reader = new BufferedReader(new FileReader("C:/Users/PC/Documents/javas/letra.txt"));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);

                Thread.sleep(500);
            }
            reader.close();
        } catch (IOException | InterruptedException e) {
        }
    }
}