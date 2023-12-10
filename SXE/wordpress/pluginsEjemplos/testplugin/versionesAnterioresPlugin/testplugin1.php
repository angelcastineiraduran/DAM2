<?php
/*
 * Plugin Name: testplugin1
 * Plugin URI: https://openwebinars.net
 * Description: Plugin de prueba
 * Version: 1.0.0
 * Author: Angel Castineira
 * Author URI: https://openwebinars.net
 * License: GPL2
 * License URI: https://www.gnu.org/licenses/gpl-2.0.html
 */

function activar()
{

}

function desactivar()
{

}

echo "Hola mundo";

// __FILE__ es una constante mágica que contiene la ruta del fichero actual, en este caso testplugin.php
// "activar" es el nombre de la función que se ejecutará cuando se active el plugin
register_activation_hook(__FILE__, 'activar');

register_deactivation_hook(__FILE__, 'desactivar');

// admin_menu es un hook que se ejecuta cuando se carga el menú de administración
// crearMenu es el nombre de la función que se ejecutará cuando se cargue el menú de administración
add_action('admin_menu', 'crearMenu');

function crearMenu() {
    // add_menu_page añade una nueva entrada en el menú de administración
    add_menu_page(
        'testplugin',
        'testplugin',
        // nivel de acceso que se requiere para ver la página, en este caso "manage_options" que es el nivel de acceso de los administradores
        'manage_options',
        'sp_testplugin',
        // nombre de la función que se ejecutará cuando se cargue la página
        'mostrarPagina',
        // direccion de la imagen
        //plugin_dir_url(__FILE__).'admin/img/menu.png',
        // posicion del menu, en este caso para que me salga arriba
        //'1'
    );

    add_submenu_page(
        'sp_testplugin', // recibe el padre del menu, para que este dentro de este
        'Ajustes',
        'Ajustes',
        'manage_options', // Capability
        'sp_testplugin_ajustes', // slug propio
        'mostrarSubmenu'
    );

}

function mostrarPagina()
{
    echo "<h1>Hola mundo</h1>";
}

function mostrarSubmenu()
{
    echo "<h1>Submenu</h1>";
}