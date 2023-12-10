<?php

/*
 * Plugin Name: Correción de palabras PRO
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

function crear_tabla_db() {
    global $wpdb;

    $charset_collate = $wpdb->get_charset_collate();

    $table_name = $wpdb->prefix . 'dam';

    $sql = "CREATE TABLE $table_name (
     id mediumint(9) NOT NULL AUTO_INCREMENT,
     time datetime DEFAULT '0000-00-00 00:00:00' NOT NULL,
     palabrotas varchar(55) NOT NULL,
     eufemismos varchar(55) NOT NULL,   
     PRIMARY KEY  (id)
    ) $charset_collate;";


    require_once( ABSPATH . 'wp-admin/includes/upgrade.php' );
    dbDelta( $sql );

}

add_action( 'plugins_loaded', 'crear_tabla_db' );


function insertar_fila_db() {
    global $wpdb, $palabrotas, $eufemismos;
    $table_name = $wpdb->prefix . 'dam';
    $flag = $wpdb->get_results("SELECT * FROM $table_name");
    // Si la tabla está vacía, insertamos los datos
    if (count($flag) == 0) {
        for ($i = 0; $i < count($palabrotas); $i++) {
            $wpdb->insert(
                $table_name,
                array(
                    'palabrotas' => $palabrotas[$i],
                    'eufemismos' => $eufemismos[$i],
                )
            );
        }
    }


}

add_action( 'plugins_loaded', 'insertar_fila_db' );


function select_db() {
    global $wpdb;
    $table_name = $wpdb->prefix . 'dam';
    $resultados = $wpdb->get_results("SELECT * FROM $table_name");
    return $resultados;
}

function cambio_eufemismos_palabrotas($texto) {
    //global $wpdb, $palabrotas, $eufemismos;
    //$table_name = $wpdb->prefix . 'dam';
    //$palabrotas = $wpdb->get_results("SELECT palabrotas FROM $table_name");
    //$eufemismos = $wpdb->get_results("SELECT eufemismos FROM $table_name");
    $dam = select_db();
    foreach ($dam as $fila) {
        // por cada fila del array, añadimos el valor de la columna palabrotas al array $palabrotas
        $palabrotas[] = $fila->palabrotas;
        // por cada fila del array, añadimos el valor de la columna eufemismos al array $eufemismos
        $eufemismos[] = $fila->eufemismos;
    }
    return str_replace($palabrotas, $eufemismos, $texto);
}

add_filter('the_content', 'cambio_eufemismos_palabrotas');