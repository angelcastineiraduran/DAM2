/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package introduccion.metodos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Una interrupcion es una indicacion para el hilo de que deberia parar lo que
 * esta haciendo y hacer algo mas. Es exactamente tarea del programador decirlo
 * como el hilo debe responder a esa interrupcion pero es muy comun hacer que el
 * hilo se termine.
 *
 * Muchos metodos que lanzan InterruptException como sleep() que la lanza si el
 * hilo es inturrumpido mientras esta esperando.
 *
 * Si un hilo pasa mucho tiempo sin invocar un metodo que pueda lanzar un
 * InterruptedException, aún debe verificar periodicamente si ha sido
 * interrumpido. Esto lo podemos hacer llamando al metodo estatico interrupted()
 * el cual devuelve true si el hilo ha sido interrumpido y al mismo tiempo
 * limpia la bandera de interrupcion, marcando que ya se ha manejado la
 * interrupcion. Por ejempo imaginemos que tenemos un bucle largo que realiza
 * varias operaciones sin lanzar un InterruptedException pero en algun momento
 * verifica si ha sido interrumpido usando el Thread.interrpted(). si devuelve
 * true el hilo puede realizar alguna accion apropiada como salir del bucle o
 * finalizar su ejecucion
 * 
 * El mecaniso de interrupcion implementa un indicador interno
 * llamado "interrupt status". Este 
 * indicador se encuentra asociado a cada hilo y se utiliza
 * para rastrear si se ha solicitado una interrupcion 
 * en ese hilo.
 * Cunado se invoca el metodo estatico Thrad.interrupt()
 * es un hilo, se establece el indicador de estado 
 * de interrupcion de ese hilo. Esta invocacion es una forma
 * de solicitar la interrupcion del hilo.
 * 
 * cd se se quiere comprobar si el hilo
 * ha solicitado una interrupcion invocando al metodo estatico 
 * Thread.interrupted devuelve true si el hilo ha sido 
 * interrumpido y al mismo tiempo limpia el  "interrupt
 * status". Sin embargo, cd queremos
 * comprobar el estado de ejecucion de otro hilo con el 
 * metodo no estatico isInterrupted(), la indicador 
 * "interrupt status" no es limpiado.
 *
 * Por convencion, todo metodo que lance una InterruptedExcepion
 * cuando completa su ejecucion o sale debido a una excepcion
 * deberia LIMPIAR el "interrupt status". Todo esto
 * es importante para el comportamiento de un codigo que
 * depende de la interaccion de un hilo 
 * no se vea afectado por el estado de interrupcion del mismo.
 * 
 * @author ubuntu
 */
public class Interrupts {

    public static void main(String[] args) {
        String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kit will eat ivy too"
        };

        for (int i = 0; i < importantInfo.length; i++) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                // hemos sido interrumpidos: no mas mensajes
                return;
            }
            System.out.println(importantInfo[i]);
        }

        // EJEMPLO: verificacion de si hay interrupcion en el hilo
        for (int i = 0; i < importantInfo.length; i++) {
            // Realizar operaciones sin lanzar InterruptedException
            // ...

            // Verificar periódicamente si se ha interrumpido
            if (Thread.interrupted()) {
                // Acciones apropiadas si el hilo ha sido interrumpido
                return;
            }
        }

    }

}
