/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;

/**
 *
 * @author dam2
 */
public class Ejercicio4 extends Thread{
    long sumaPares;
    long sumaImpares;
    long suma2o3;
    
public Ejercicio4(String str) {
        super(str);
    }
    
    public long sumarPares(){     
        for(int i = 0; i <= 1000; i++){
            if(i % 2 == 0) {
                sumaPares += i;
            }
        }
        return sumaPares;
    }
    public long sumarImpares(){     
        for(int i = 0; i <= 1000; i++){
            if(i % 2 != 0) {
                sumaImpares += i;
            }
        }
        return sumaImpares;
    }
    public long Sumar_2o3(){     
        for(int i = 0; i <= 1000; i++){
            if(i % 10 == 3) {
               suma2o3 += i;
            }
        }
        return suma2o3;
    }
    
    int escogerHilo;
    public void run(){
       
        switch(escogerHilo) {
            case 0:
                System.out.println("pares = " +  sumarPares());
                break;
            case 1:
                System.out.println("impares = " + sumarImpares());
                break;
            case 2:
                System.out.println("suma2o3 = " + Sumar_2o3());
                break;
            
        }
       
    }
    
    
    
    public static void main(String[] args) {
        Ejercicio4 hilo1, hilo2, hilo3;
        hilo1 = new Ejercicio4("Hilo1");
        hilo2 = new Ejercicio4("Hilo2");
        hilo3 = new Ejercicio4("Hilo3");
        
        hilo1.escogerHilo = 0;
        hilo1.start();
        hilo2.escogerHilo = 1;
        hilo2.start();
        hilo3.escogerHilo = 2;
        hilo3.start();

        
    }
    
}

