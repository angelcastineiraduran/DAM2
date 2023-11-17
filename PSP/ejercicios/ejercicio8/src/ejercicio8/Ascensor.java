/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio8;

/**
 *
 * @author dam2
 */
public class Ascensor extends Thread {
    
    // atributos del obj ascensor
    private int pisoActual;
    private boolean enMovimiento;
    private int pisoDestino;
    
    /**
     * constructor que inicializa los atributos del obj ascensor. 
     */
    public Ascensor() {
        this.pisoActual = 0; // El ascensor comienza en el piso 0
        this.enMovimiento = false;
        this.pisoDestino = -1; // No hay destino inicialmente
    }
    
    /**
     * Este metodo se llama cuando alguien realiza la solicitud de llamar a un piso especifico.
     * Al marcarlo como synhronized le estoy diciendo que UN SOLO HILO puede ejecutar 
     * este metodo A LA VEZ.
     * 
     * Primero se verifica si un piso esta enMovimiento. Si el ascensor no esta en movimiento
     * (enMovimiento=false) significa que no hay solicitudes pendientes y el ascensor puede
     * comenzar a moverse al piso solicitado. En este caso se actualiza el pisoDestino, 
     * enMovimiento y se utiliza notify() para despertar al hilo en caso de que este en 
     * espera en el metodo run()
     * 
     * Sin embargo, si el ascensor ya esta en movimiento (esMovimiento=true), significa que
     * ya hay una solicitud en curso y en este caso simplemente se actualiza el valor de
     * pisoDestino con el nuevo piso que se llamo. No se cambia el enMovimiento pq el 
     * ascensor ya esta en proceso de ir a un piso. Esto garantiza que si esta en movimiento
     * solo actualiza el destino del ascensor para que vaya a ese piso una vez termine su movimiento
     * actual
     * 
     * @param piso de destino
     */
    public synchronized void llamar(int piso) {
        System.out.println("Llamada desde el piso " + piso);
        if (!enMovimiento) { // si el piso no esta en movimiento, es decir, esta en false, SE PUEDE MOVER
            this.pisoDestino = piso;
            this.enMovimiento = true; // como se puede mover, lo INDICO
            notify(); // Notificar al hilo para que comience el movimiento
        } else { // si el piso esta en movimiento??
            this.pisoDestino = piso;
        }
    }
    
    /**
     * punto de entrada de ejecucion del hilo.
     * 
     * while(true) nos asegura que el hilo este siempre en funcionamiento y disponible
     * para aceptar nuevas llamadas al ascensor
     * 
     * while(!enMovimiento) verifica si el ascensor esta en movimiento. si esMoviemiento=false
     * indica que no hay solicitudes pendientes para mover el ascensor a un piso destino. Esto
     * provoca que el hilo entre en espera usando el wait(). esto suspende el programa hasta
     * que otra parte del programa, en este caso el metodo llamar(), notifique al hilo del 
     * ascensor para despertarlo.
     * 
     * Cuando alguien llama al ascensor, se actualiza el estado pisoDestino y enMovimiento y se
     * utiliza notify() para notificar al hilo del ascensor que ya puede dejar de esperar y
     * continuar con la ejecucion.
     * 
     * Una vez el ascensor recibe la notificacion, sale del bucle de espera del while(!enMovimiento)
     * y llama al metodo moverse() que simula el desplazamiento del ascensor hacia el pisoDestino
     */
    public synchronized void run() {
        while (true) {
            while (!enMovimiento) { // mientras el piso no este en movimiento, es decir, que nadie lo esta llamando
                try {
                    wait(); // Espera a que se llame al ascensor
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // cuando enMovimiento=true, significa que alguien lo ha llamado por lo tanto:
            moverse();
        }
    }

    private synchronized void moverse() {
        if (pisoActual < pisoDestino) {
            System.out.println("Ascensor subiendo al piso " + pisoDestino);
            while (pisoActual < pisoDestino) {
                pisoActual++;
                System.out.println("Piso actual: " + pisoActual);
                try {
                    Thread.sleep(1000); // Simulación de tiempo para subir un piso
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if (pisoActual > pisoDestino) {
            System.out.println("Ascensor bajando al piso " + pisoDestino);
            while (pisoActual > pisoDestino) {
                pisoActual--;
                System.out.println("Piso actual: " + pisoActual);
                try {
                    Thread.sleep(1000); // Simulación de tiempo para bajar un piso
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Ascensor ha llegado al piso " + pisoActual);
        this.enMovimiento = false;
    }
}
