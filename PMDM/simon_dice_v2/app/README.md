# SIMON DICE

## Descripción
El juego consiste en que el usuario debe repetir la secuencia de colores que se le muestra en pantalla, 
cada vez que el usuario acierte la secuencia se le agregará un color más a la secuencia, 
si el usuario se equivoca en la secuencia el juego termina.

## Explicación del código
El código está dividido en 4 partes:
1. Declaracion e iniciación de variables en el `Object Data`.
2. En la clase `MainActivity` iniciamos la app llamando al método `MiInterfaz()` del fichero `IU.kt`.
3. El método `MiInterfaz()` (archivo `UI.kt`) inicia los componentes de la interfaz de usuario y recibe una instancia `MyViewModel`
para poder acceder al funcionamiento de los eventos de los componenetes.
4. En la clase `MiViewModel` se encuentra la lógica del juego. Contiene todas las funciones 
que tendrán que hacer internamente los botones una vez se les haga click.

_Utilizamos el repositorio `theme` y `res` para poder acceder a los colores propios de la app y 
valores String que se utilizan en la interfaz de usuario respectivamente._

### Object Data

`mutableStateOf()` se utiliza para crear estados mutables que pueden cambiar y 
provocar actualizaciones en la interfaz de usuario cuando su valor se modifica. Por ejemplo:

- `isStarted`, `isGameOver` y `playStatus` son estados mutables que controlan el inicio, fin y estado de reproducción del juego.
- `record` es un estado mutable que guarda el récord actual del jugador.
- `colorSeleccion`, `colorRojo`, `colorAmarillo`, `colorVerde` y `colorAzul` son estados mutables 
que representan diferentes colores para la interfaz de usuario.

Por otro lado, `mutableListOf<Int>()` se utiliza para crear listas mutables que pueden contener elementos del tipo `Int`. En este código:

- `userSecuence`, `botSecuence` y `botSecuenceNow` son listas mutables que almacenan secuencias de números para el juego.

### MainActivity
La clase `MainActivity` inicia la aplicación. En su método `onCreate`, instancia un `MiViewModel` 
y configura la interfaz gráfica mediante Compose.

La función `MiInterfaz` es utilizada para crear la interfaz de usuario, 
y recibe una instancia de `MiViewModel` para manejar la lógica de la app.

Se hace uso de estructuras como `Surface` y `MaterialTheme` 
para configurar la apariencia visual de la app, estableciendo colores y ajustes de tamaño.

La función `PreviewPrincipal` es una vista previa de la interfaz de usuario, 
donde también se instancia `MiViewModel` y se muestra la interfaz.

### IU
Contiene funciones Composables para la interfaz de usuario.

- `MiInterfaz` contiene la estructura principal de la IU, 
con elementos como el contador de rondas y la botonera de colores. 
Utiliza `Column` y `Row` de Compose para organizar los componentes.

- `Botonera` crea botones para cada color y permite al usuario agregar 
colores a una secuencia mientras el juego está en curso.

- `BotonStart`, `BotonReset` y `BotonContinuar` 
son botones individuales para iniciar, reiniciar y continuar el juego respectivamente.

- `ContadorRonda` muestra el número de la ronda actual.

- La función `prevMostrarNumeros` es una vista previa de la interfaz de usuario.

### MiViewModel
Contiene la lógica principal de la app.

- `MiViewModel` hereda de `ViewModel` de Android y contiene métodos para manejar la lógica del juego, 
como la generación de secuencias, la validación de secuencias, el control del estado del juego, entre otros.

- `setBotSecuence` genera una secuencia aleatoria para el bot y la guarda en `Data.botSecuence`.

- `validateSecuences` compara las secuencias del usuario y del bot para determinar si el juego continúa o termina.

- `isStarted`, `isGameOverTrue` y `nextRound` controlan el inicio, 
fin y progreso del juego, reiniciando secuencias y actualizando el récord según corresponda.

- `setBotSecuenceNow` va creando gradualmente una secuencia para 
mostrar al usuario y compararla con su secuencia, mientras limita la cantidad de elementos a mostrar con base en el récord.

- `modifyColor` cambia momentáneamente el color de los botones 
para mostrar al usuario la secuencia del bot, utilizando un `viewModelScope` para gestionar el tiempo entre cambios de color.

### MVVM
En la app el patrón MVVM se aplica eficazmente:

El **Modelo** (representado por `Data`) almacena los estados del juego.
La **Vista** (funciones `Composables`) estructura la interfaz y responde a la interacción del usuario.
El **ViewModel** (`MiViewModel`) gestiona la lógica del juego y actúa como intermediario entre la vista y el modelo.