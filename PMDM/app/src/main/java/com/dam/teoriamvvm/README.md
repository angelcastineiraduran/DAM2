# INTRODUCCION

## ¿Qué es MVVM?
MVVM es un patrón de arquitectura de software que facilita la separación de los diferentes tipos
de componentes desarrollados en una aplicación. Este patrón de arquitectura de software se basa en 
el patrón Modelo Vista Controlador (MVC), pero con algunas modificaciones que lo hacen más adecuado 
para el desarrollo de aplicaciones modernas.

## Division de la aplicacion
La aplicación se divide en tres partes principales:

### Modelo
El modelo es responsable de recuperar los datos de la aplicación y almacenarlos en un formato que
pueda ser utilizado por la vista. El modelo también puede contener la lógica de negocio de la aplicación.

### Vista
La vista es responsable de mostrar los datos del modelo al usuario y de proporcionar la interacción
del usuario. La vista también puede contener la lógica de presentación de la aplicación.

### ViewModel
El ViewModel es responsable de transformar los datos del modelo en un formato que pueda ser utilizado
por la vista y de proporcionar la interacción del usuario. El ViewModel también puede contener la lógica
de presentación de la aplicación.

## Pasos para implementar MVVM
Lo primero que tenemos que hacer es que nuestra `activity` se suscriba a nuestro `ViewModel`, a
través de `liveData`, que no es otra cosa que "conectarse" a través del patrón `observer` para 
que cuando haya un cambio en el `ViewModel` se actualice la `activity`.

Esto es prioritario ya que la actividad sólo se pintará cuando dicho `ViewModel` lo notifique.

### Primera parte: Modificar Gradle Scripts
>No es toy seguro de si estos cambios son necesarios
>ya que están en la guia para implementar el modelo 
>en un proyecto XML y no Compose

1. Gradle Srcipts -> build.gradle (Module: app). 
   2. En el bloque `android`, dentro
      de `buildFeatures` añadimos la linea `viewBinding true`. Lo que te permite
      acceder de manera más segura a las vistas de tu diseño mediante enlaces
      generados por el sistema.
   3. En el bloque `dependencies` añadimos:
   ```kotlin
    // Fragment
    implementation ("androidx.fragment:fragment-ktx:1.3.2")
    // Activity
    implementation ("androidx.activity:activity-ktx:1.2.2")
    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    // LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
   ```

### Segunda parte: Diseño
Cuando creas una instancia de ViewModel, le pasas un objeto que implementa la interfaz `ViewModelStoreOwner`.

Un rango de clases son subclases directas o indirectas de la interfaz `ViewModelStoreOwner`. 
Las subclases directas son `ComponentActivity`, `Fragment` y `NavBackStackEntry`.

