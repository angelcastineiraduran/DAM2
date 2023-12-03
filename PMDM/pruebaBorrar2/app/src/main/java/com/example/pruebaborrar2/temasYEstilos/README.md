# Cómo aplicar estilo y temas a tu app

Archivo conf de temas:
`ui/theme/Theme.kt`

```kotlin
@Composable
fun PruebaBorrar2Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    //...

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
```
`MaterialTheme` es una función de componibilidad que refleja los principios de 
estilo de la especificación de Material Design.

Esa info de estilo cae en cascada(?) a los componentes que estan dentro de su `content`.

Desde cualquier elemento componible descendiente puedes recuperar 3 propiedades de `MatherialTheme`:
* `colorScheme`
* `typography`
* `shapes`

Ejemplo:

El elemento componible `Text` configura un nuevo `TextStyle`. Puedes crearlo o recuperarlo de 
`MatherialTheme.typography` (metodo pref). Con esta ultima tenemos acceso a estilos definidos por 
el Material: `displayLarge, headlineMedium, titleSmall, bodyLarge, labelMedium`...
```kotlin
Column(modifier = Modifier
    .weight(1f)
    .padding(bottom = extraPadding.coerceAtLeast(0.dp))
) {
    Text(text = "Hello, ")
    Text(text = name, style = MaterialTheme.typography.headlineMedium)
}
```

Buena practica: utilizar colores/estilos... de `MaterialTheme` pero si queremos cambiar por unos 
distintos basarnos en unos existentes.
Puedes cambiar el estilo predefinido con la funcion `copy`


Me quede en como configurar una vista previa en modo oscuro...