*1 se suponge que si:
```java
        hilo1.join(); 
        //hilo2.join();
        //hilo3.join();
        //hilo4.join();
```
...esto esta así, se acabaria el 1 y luego se ejecutaria el resto. Sin embargo no 
entinedo porque va de ultimo en este caso el mensaje de "**fin de main**" ya que aunque se 
termine antes el 1, se termendria que printear antes lo de la principal antes que los otros 
metodos. 
* si ejecutamos varias veces podemos comprobar que puede salir antes o despues el 
mensaje del fin del main


