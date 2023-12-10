<?php
/*
 * Plugin Name: testplugin
 * Plugin URI: https://openwebinars.net
 * Description: Plugin de prueba
 * Version: 1.0.0
 * Author: Angel Castineira
 * Author URI: https://openwebinars.net
 * License: GPL2
 * License URI: https://www.gnu.org/licenses/gpl-2.0.html
 */

/**
 * Función que se ejecuta cuando se activa el plugin por parte del administrador de WordPress
 * Va a comprobar si existe una tabla. Si existe no hace nada, si no existe la crea.
 * @return void
 */
function activar()
{
    // variable de la libreria de wp y nos permite utilizar todas las funciones de la bd
    global $wpdb;

    // creamos el srcipt sql
    // $wpdb->prefix nos devuelve el prefijo de la tabla de la bd
    $sql = " create table if not exists {$wpdb->prefix}encuestas(
        EncuestaId INT auto_increment,
        Nombre      VARCHAR(45) null,
        ShortCode VARCHAR(45) null,
        constraint wp_encuestas_pk
            primary key (EncuestaId)
     );";
    // ejecuto el query mediante la variable local
    $wpdb->query($sql);

    if ($wpdb->last_error !== '') {
        // Si hay un error, puedes mostrarlo en el log o en pantalla para depuración
        error_log('Error al crear la tabla: ' . $wpdb->last_error);
        // O puedes mostrarlo en pantalla durante el desarrollo para depurar
        // echo 'Error al crear la tabla: ' . $wpdb->last_error;
    }

    $sql2 = "create table if not exists {$wpdb->prefix}encuestas_detalle (
        DetalleId   INT auto_increment,
        EncuestaId INT          null,
        Pregunta    VARCHAR(150) null,
        Tipo        VARCHAR(45)  null,
        constraint encuestas_detalle_pk
            primary key (DetalleId)
    );";

    $wpdb->query($sql2);

    $sql3 = "create table if not exists {$wpdb->prefix}encuestas_respuesta (
        RespuestaId   INT auto_increment,
        DetalleId INT          null,
        Respuesta    VARCHAR(45) null,
        constraint encuestas_respuesta_pk
            primary key (RespuestaId)
    );";

    $wpdb->query($sql3);

}

function desactivar()
{

}

register_activation_hook(__FILE__, 'activar');
register_deactivation_hook(__FILE__, 'desactivar');
add_action('admin_menu', 'crearMenu');

function crearMenu() {
    add_menu_page(
        'Super encuestas',
        'Super encuentas Menu',
        'manage_options',
        plugin_dir_path(__FILE__).'admin/listas_encuestas.php',
        null,
        null,
        1
    );
}
