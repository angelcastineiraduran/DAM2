<?php

/*
 * Plugin Name: Correción de palabras
 * Plugin URI: https://openwebinars.net
 * Description: Plugin de prueba
 * Version: 1.0.0
 *
 */

$palabrotas = array (
    'mierda',
    'coño',
    'polla',
    'gilipollas',
);

$eufemismos = array (
    'caca',
    'chocho',
    'pene',
    'tonto',
);
function cambio_eufemismos_palabrotas($texto) {
    global $palabrotas, $eufemismos;
    // str_replace busca en el primer array y reemplaza por el segundo array
    // el tercer parámetro es el texto en el que se va a buscar
    return str_replace($palabrotas, $eufemismos, $texto);
}

// add_filter es un hook que se ejecuta cuando se va a mostrar un texto
// "cambio_eufemismos_palabrotas" es el nombre de la función que se ejecutará cuando se vaya a mostrar un texto
// "the_content" es el nombre del hook que se ejecutará y su funcion es mostrar el contenido de un post
add_filter('the_content', 'cambio_eufemismos_palabrotas');