# EXPLICACION
Aniadir prioridades

* Como funciona las prioridades?¿

```java
MyThread obx = new MyThread("1");
MyThread obx2 = new MyThread("2");

obx.setPriority(1);
obx2.setPriority(10);

obx2.start();
obx.start();
```

-----

* Cambiar nombre a un hilo:

```java

public class MyThread extends Thread{
    public MyThread(String name){
        super(name);
    }
    
public void run(){
    System.out.println("Hola, soy el hilo numero " + getName());
}

```

-----

`Sychronized`
En Java, el método synchronized se utiliza para controlar el acceso a 
bloques de código o métodos por parte de múltiples hilos (threads) para garantizar la sincronización y 
evitar problemas de concurrencia, como condiciones de carrera y problemas de 
consistencia en datos compartidos.

Cuando un método o bloque de código se declara como synchronized, 
se asegura de que solo un hilo pueda ejecutar ese bloque o método a la vez. 
Esto significa que otros hilos que intenten acceder a métodos synchronized del 
mismo objeto deben esperar su turno para ejecutar el código protegido.

```java

public class Ejemplo {
    private int contador = 0;

    // Un método synchronized
    public synchronized void metodoSincronizado() {
        // Código protegido por la sincronización
        contador++;
    }

    // Un bloque de código synchronized usando un objeto como monitor
    public void otroMetodo() {
        synchronized (this) {
            // Código protegido por la sincronización
            contador--;
        }
    }
}

```

En el ejemplo anterior, metodoSincronizado() y otroMetodo() están sincronizados. 
Si múltiples hilos intentan llamar a metodoSincronizado() al mismo tiempo en la 
misma instancia de Ejemplo, solo un hilo podrá ejecutarlo a la vez. Lo mismo ocurre con 
el bloque synchronized en otroMetodo(); asegura que solo un hilo a la vez pueda 
ejecutar el código dentro del bloque, utilizando el objeto actual (this) como monitor.

Es importante tener en cuenta que el uso excesivo de synchronized 
puede provocar problemas de rendimiento debido a la espera de los hilos. 
Además, con Java 5 y versiones posteriores, se introdujeron otras construcciones
 más avanzadas, como java.util.concurrent que ofrecen alternativas más eficientes 
para manejar la concurrencia, como Locks, Semáforos, ForkJoinPool, entre otros.

----

`wait`
Claro, el método wait() en Java se utiliza en el contexto de la concurrencia y 
la sincronización entre hilos. Se encuentra disponible en la clase Object y se 
utiliza para hacer que un hilo 
espere hasta que cierta condición se cumpla antes de continuar su ejecución.

Cuando un hilo llama al método wait() en un objeto, se suspende y libera el 
bloqueo del objeto, permitiendo que otros hilos puedan ejecutar métodos 
sincronizados en ese mismo objeto. El hilo que invoca wait() espera hasta 
que otro hilo invoque el método notify() o notifyAll() en el mismo objeto.

* notify(): Este método despierta un solo hilo que está esperando en el objeto. 
Si hay múltiples hilos esperando, uno de ellos (no hay garantía sobre cuál) se activará.

* notifyAll(): Este método despierta todos los hilos que están esperando en el objeto. 
Todos los hilos se pondrán en un estado de ejecución, pero solo uno obtendrá el bloqueo del objeto cuando se libere.

Estos métodos (notify() y notifyAll()) se invocan en el mismo objeto en el que 
se llamó wait() para despertar los hilos en espera. Todos estos métodos (wait(), notify(), notifyAll()) 
deben ser invocados desde bloques synchronized o métodos synchronized para asegurar 
la consistencia y evitar condiciones de carrera.

```java

public class EjemploWaitNotify {
    public synchronized void metodoEspera() {
        System.out.println("Hilo en espera...");

        try {
            // El hilo se suspende hasta que se llame a notify() o notifyAll()
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Hilo reanudado.");
    }

    public synchronized void metodoNotifica() {
        System.out.println("Notificando a los hilos en espera...");

        // Realiza alguna tarea y luego notifica a los hilos en espera
        notifyAll();
    }
}

```

En este ejemplo, metodoEspera() espera hasta que se invoque notifyAll() 
desde metodoNotifica() en el mismo objeto. Una vez que notifyAll() se llama, 
el hilo que está en espera en metodoEspera() se reanuda y continúa su ejecución.

Es importante mencionar que wait() debe estar dentro de un ciclo while para 
verificar la condición que hizo que el hilo se suspendiera, ya que puede ocurrir 
una falsa notificación debido a una interrupción u otras razones. Esto ayuda a 
evitar problemas de concurrencia.