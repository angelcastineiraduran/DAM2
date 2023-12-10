<?php
/*
 * Plugin Name: History Timeline
 * Plugin URI: http://www.wp-plugin-dev.com/history-timeline
 * Description: Plugin para crear un bloque Gutenberg
 * Version: 1.0.0
 * Author: Angel Castineira
 * Author URI: http://www.wp-plugin-dev.com
 */

/**
 * se incluyen los ficheros que se va a mostrar en la parte
 * del back
 */
function functionBack()
{
    wp_enqueue_script(
        'history-timeline',
        plugin_dir_url(__FILE__), 'js/history-timeline.js',
        array('wp-blocks', 'wp-i18n', 'wp-editor'),
        true
    );

    wp_enqueue_script(
        'events',
        plugin_dir_url(__FILE__), 'js/events.js',
        array('wp-blocks', 'wp-i18n', 'wp-editor', 'jquery'),
        1.1, true
    );

    wp_enqueue_style(
        'editor',
        plugins_url(__FILE__), 'css/editor.css',
        array(),
        '4.7.0'
    );
}
