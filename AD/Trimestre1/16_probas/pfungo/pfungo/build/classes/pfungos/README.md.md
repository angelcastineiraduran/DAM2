# Explicación pfungo
El error `java.lang.ClassNotFoundException: pfungos.Detectados` 
indica que Java no puede encontrar la clase `pfungos.Detectados` 
al deserializar un objeto en `Serializado.getDetectados()`.

- **Causa probable:** La referencia de la clase en el archivo serializado (`pfungos.Detectados`) 
no coincide con la ubicación real de la clase (`pfungo.Detectados`).

- **Solución:** Asegúrate de que la clase `Detectados` se serialice y deserialice 
con la ruta de paquete correcta (`pfungo.Detectados`). Ajusta el código para que 
coincida con el paquete donde se encuentra la clase. Además, verifica que la clase 
`Detectados` sea accesible desde el classpath utilizado para la ejecución del programa.

