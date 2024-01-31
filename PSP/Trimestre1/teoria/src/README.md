# Concurrencia

## Introduccion

Concurrencia: 2 o mas tareas en ejecucion al mismo tiempo
en paralelo. **La concurrencia de java esta mas centrada
en los Threads que en los procesos.**

Los ordenadores tienen multiples proceosos e hilos activos
incluso en sistemas en dd solo haya un unico nucleo de 
ejecución. El tiempo de procesamiento en un unico nucleo
es compartido a traves de hilos y procesos a traves de 
una caracteristica del SO llamada "sciling".

### Procesos vs Threads (hilos)

#### Procesos
Son vistos como sinonimos de app o programas pero sin 
embargo, **una app tiene un monton de procesos compenetrados.**
Tienen un entorno de ejecucion autónomo.

* Cada proceso tiene su propio espacio 
de memoria. 
* tiempo de ejecucion especifico para
interactuar con el SO y asignar otros recursos, como su
propia memoria, como hace la JVM. JMV de hecho es un 
proceso.
* Para facilitar la comunicacion entre procesos, muchos 
SO soportan recursos de IPC (Inter Process Comunication), como
tuberías (pipes) o sockets. IPC se utiliza para comunicar
procesos tanto en el mismo sistema como con procesos de sistemas
distintos.
* Muchas de las implementaciones de la JVM corren como un
unico proceso. Java puede crear procesos adicionales 
usando instancias de `ProcessBuilder`.

#### Threads (hilos)
Parecidos a procesos ya que ambos consumen 
recursos del SO pero lo hilos son mas faciles de crear
y consumen muchos menos recursos que los procesos. Debido 
a esto cualquier procesador un poco moderno puede correr
cientos de hilos en un solo proceso de JVM. El conjunto
de hilos que pueda correr dependera de CPU, SO, RAM disponible, 
configuracion de JVM.

* Los **hilos existen dentro de un proceso.** Todos los procesos
tienen al menos un hilo. 
* Los hilos comparten los recursos del proceso incluso
la memoria y los archivos abiertos. Esto provoca
una comunicacion eficiente pero potencialmente problematica.
* Todas las app de Java tienen al menos un hilo. Bueno, o varios
si contasemos los hilos del systema los cuales hacen cosas como 
el manejo de memoria. Pero bueno, nosotros, como programadores,
vamos a quedarnos con que cada app de Java = 1 hilo llamado
**hilo principal (main thread)**
* El hilo principal tiene la capacidad de crear hilos adicionales.
* Los hilos tambien pueen tener su propio contexto de seguridad
el cual puede ser usado por clientes.

----

#### CONCLUSIONES DIFERENCIAS
* Los hilos (de un mismo proceso) corren con espacio de 
memoria compartida mientras que los proceso corren 
en espacios de memoria separados.
* cada proceso proporciona los recursos necesitados para 
ejecutar un programa .Todos los hilos de un proceso comparten 
su espacio de
direccion virtual y recursos del sistema.
* un proceso tiene su propo espacio de memoria virtual, 
codigo ejecutable, manejo avierto de objetos del sistema, 
contexto de seguridad, un identificador de proceso unico,
variables de entorno, prioridad de clase, min y max tamaño
de trabajo y **por lo menos un hilo de ejecucion**.
* cada hilo tiene un manejo de sus excepciones, prioridad, 
almacenamiento local del hilo, identificador unico de hilo...
* un hilo es una entidad dentro de un proceso que se puede
programar para su ejecucion.


Microsoft Windows soporta "preemptive multitasking" el cual
crea el efecto de ejecucion de
 multiples hilos asociados a multiples proecesos
simultaneamente.

## Threads

Cada hilo asociado a una instancia de la clase `Thread`.

### Formas de definir y empezar un hilo

La app que crea una instancia de esa clase debe proveer 
el codigo que ese hilo va a correr. Hay 2 formas de 
hacer esto:

* Proporcionar un objeto `Runnable` al constructor de `Thread`

La interfaz `Runnable` define un unico metodo llamado
`run()` el cual tiene que tener el codigo que va a ejecutar
el hilo. El obj `Runnable` es pasado al constructor del `Thread`.

```java
public class HelloRunnable implements Runnable {

    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String args[]) {
        (new Thread(new HelloRunnable())).start();
    }

}
```

* Extendiendo de la clase `Thread`

La clase `Thread` implementa directamente la interfaz
`Runnable` (API Java) aun su metodo `run()` **NO contiene
nada** de todo por lo que hay que **sobreescribirlo**.

```java
public class HelloThread extends Thread {

    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String args[]) {
        (new HelloThread()).start();
    }

}
``

>**Que forma utilizar/mejor practica?**
>La primera ya que es mas general porque utiliza un obj 
>que implementa la interfaz `Runnable` y este no está 
>vinculado directamente a un hilo y por tanto
>puede ser utilizado por cualquier clase que implemente
>`Runnable`. Separar la tarea (`Runnable`) del objeto de hilo
>(`Thread`) es una practica que mejor al modularidad y permite
>mejor diseño. De esta forma encapsulamos tareas y separamos la logica
>del hilo de ejecución.

### Metodos
`Thread.sleep` 

Se suspende el hilo actual por un tiempo. Utilidades:
* metodo eficaz para hacer que el tiempo del procesador
este disponible para otros hilos de la app.
* para que espere a otro hilo del cual necesita cosas

Se le pasa el nanosegundos o milisegundos el tiemop que 
debe estar parado aunque no es exactamente preciso ya
que tambien depende de nuestro SO.
 


## Bibliografia
Documentacion Java ORACLE
https://docs.oracle.com/javase/tutorial/essential/concurrency/simple.html




