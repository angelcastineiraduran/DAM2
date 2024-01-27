/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sincronizacionHilos.sincronizacion3;

import java.lang.System.Logger.Level;
import java.util.logging.Logger;

/**
 * 
 * @author ubuntu
 */
public class BancoSinSincronizar {
    
    public static void main(String[] args) throws InterruptedException {
        
        // creo las 100 cuentas y las recargo con 2000$ cada una.
        Banco banco = new Banco();
        
        for(int i = 0; i < 100; i++) {
            // la variable Runneable que vamos a ejecutar como hilo sera eT
            EjecutarTransferencia eT = new EjecutarTransferencia(banco, i, 2000);
            Thread hilo = new Thread(eT);
            hilo.start();
        }
       
    }
    
}

class Banco {
    
    private final double[] cuentas;
    
    public Banco() {
        cuentas = new double[100];
        for(int i = 0; i < cuentas.length; i++) {
            cuentas[i] = 2000;
        }
    }
    
    public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) {
        if(cuentas[cuentaOrigen] < cantidad){
            return;
        }
        // para saber por pantalla el hilo que va a realizar la transf
        System.out.println(Thread.currentThread());
        // dinero que sale de la cuenta origen
        cuentas[cuentaOrigen] -= cantidad;
        // para saber todos los param implicados
        // 10.2f indico 2 decimales
        // d (pimero) cuenta origen
        // d (segundo) ...
        System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);
        // dinero que entra en la nueva cuenta
        cuentas[cuentaDestino] += cantidad;
        // imprimo el saldo total
        // "%n"?¿
        System.out.printf("Saldo total: %10.2f%n", getSaldoTotal());
    }
    
    public double getSaldoTotal() {
        double sumaCuentas = 0;
        for(double a:cuentas) {
            sumaCuentas += a;
        }
        return sumaCuentas;
    }
    
}

class EjecutarTransferencia implements Runnable {
    Banco banco;
    int cuentaOrigen;
    double cantidadMax;
    
    public EjecutarTransferencia(Banco banco, int cuentaOrigen, double cantidadMax) {
        this.banco = banco;
        this.cuentaOrigen = cuentaOrigen;
        this.cantidadMax = cantidadMax;
    }

    @Override
    public void run() {
        while(true) {
            int cuentaDestino = (int)(100*Math.random());
            double cantidad = (int)cantidadMax*Math.random();
            banco.transferencia(cuentaOrigen, cuentaDestino, cantidad);
            try {
                Thread.sleep((int)(Math.random()*10));
            } catch (InterruptedException ex) {
                
            }
        }
    }
    
}


