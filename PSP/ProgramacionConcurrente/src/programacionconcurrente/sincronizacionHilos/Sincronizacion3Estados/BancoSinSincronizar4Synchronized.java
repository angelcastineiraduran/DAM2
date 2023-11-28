/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacionconcurrente.sincronizacionHilos.Sincronizacion3Estados;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubuntu
 */
public class BancoSinSincronizar4Synchronized {

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
    //private Lock cierreBanco = new ReentrantLock();
    //private Condition saldoSuficiente;

    public Banco() {
        cuentas = new double[100];
        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i] = 2000;
        }
        //saldoSuficiente = cierreBanco.newCondition();
    }

    public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException {
//        cierreBanco.lock();
//        try {
            while (cuentas[cuentaOrigen] < cantidad) {
                //saldoSuficiente.await();
                wait();
            }
            System.out.println(Thread.currentThread());
            cuentas[cuentaOrigen] -= cantidad;
            System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);
            cuentas[cuentaDestino] += cantidad;
            System.out.printf("Saldo total: %10.2f%n", getSaldoTotal());
            //saldoSuficiente.signalAll();
            notifyAll();
//        } finally {
//            cierreBanco.unlock();
//        }
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
            try {
                banco.transferencia(cuentaOrigen, cuentaDestino, cantidad);
            } catch (InterruptedException ex) {
                Logger.getLogger(EjecutarTransferencia.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Thread.sleep((int) (Math.random() * 10));
            } catch (InterruptedException ex) {
                Logger.getLogger(EjecutarTransferencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
