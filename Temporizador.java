public class Temporizador extends Thread {
    private int tiempo = 10;

    @Override
    public void run() {
        while (tiempo > 0) {
            System.out.println(tiempo);
            tiempo--;

            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
            }
        }

        System.out.println("¡Tiempo acabado!");
    }
}
