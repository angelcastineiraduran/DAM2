/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacionconcurrente.sincronizacionHilos.Sincronizacion3Estados;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubuntu
 */
public class BancoSinSincronizar2 {

    public static void main(String[] args) throws InterruptedException {

        Banco banco = new Banco();

        for (int i = 0; i < 100; i++) {
            EjecutarTransferencia eT = new EjecutarTransferencia(banco, i, 2000);
            Thread hilo = new Thread(eT);
            hilo.start();
        }

    }

}

class Banco {

    private final double[] cuentas;
    // para utilizar lock() y unlock()
    private Lock cierreBanco = new ReentrantLock();

    public Banco() {
        cuentas = new double[100];
        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i] = 2000;
        }
    }

    public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) {
        // bloqueamos codigo de debajo hasta que acabe el hilo
        cierreBanco.lock();
        try {
            if (cuentas[cuentaOrigen] < cantidad) {
                System.out.println("------CANTIDAD INSUFICIENTE-----");
                System.out.println("····CUENTA ORIGEN --> " + cuentaOrigen + ": " + cuentas[cuentaOrigen] + "$");
                System.out.println("····CANTIDAD A TRANSFERIR --> " + cantidad + "$" );
                return;
            }
            System.out.println(Thread.currentThread());
            cuentas[cuentaOrigen] -= cantidad;
            System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);
            cuentas[cuentaDestino] += cantidad;
            System.out.printf("Saldo total: %10.2f%n", getSaldoTotal());
        } finally {
            // despues de acabar lo desbloqueamos para que se pueda ejecutar el siguiente hilo
            // se pone en el finally para que siempre se ejecute, de forma que si 
            // el hilo entra en el if (return), se ejecute esta linea previamente desbloqueando
            // asi el codigo
            cierreBanco.unlock();
        }
    }

    public double getSaldoTotal() {
        double sumaCuentas = 0;
        for (double a : cuentas) {
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
        while (true) {
            int cuentaDestino = (int) (100 * Math.random());
            double cantidad = (int) cantidadMax * Math.random();
            banco.transferencia(cuentaOrigen, cuentaDestino, cantidad);
            try {
                Thread.sleep((int) (Math.random() * 10));
            } catch (InterruptedException ex) {
                Logger.getLogger(EjecutarTransferencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
