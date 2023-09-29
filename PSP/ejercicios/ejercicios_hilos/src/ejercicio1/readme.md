*1 porque es tan corto lo que hay en el main que se printea primero lo del Main.
Cuando se ejecuta el Main ordena que se ejecute un hilo (y este ahora iria por su cuenta)
luego el hilo 2 (y este ahora...) y luego printea lo de "fin del main". Pero como
ordena las tareas tan rapido, le da tiempo a printear antes lo del main que a ejecutarse 
cualquiera de los hilos. 
