<?php
    global $wpdb;
    $query = "SELECT * FROM {$wpdb->prefix}encuestas";
    // nos devolveria un obj
    //$lista_encuestas = $wpdb->get_results($query);
    // nos devolveria un array asociativo
    $lista_encuestas = $wpdb->get_results($query, ARRAY_A);

    // para evitar que nos salgan posible errores de que la variable no esta definida
    if(empty($lista_encuestas)){
        $lista_encuestas = array();
    }

?>

<div class="wrap">
    <?php
    // muestra el titulo puesto en "page_title" en la funcion "add_menu_page"
    echo "<h1>" .get_admin_page_title() . "</h1>";
    ?>

    <a class="page-titule-action">Añadir nueva</a>
    <br><br><br>

    <table class="wp-list-table widefat fixed striped pages">
        <thead>
        <th >Nombre de la encuestas</th>
        <th >ShortCode</th>
        <th >Acciones</th>
        </thead>
        <tbody id="the-list">
            <?php
                foreach ($lista_encuestas as $key => $value) {
                    // ["Nombre"] es el nombre de la columna de la tabla
                    $nombre = $value['Nombre'];
                    // ["ShortCode"] es el nombre de la columna de la tabla
                    $shortcode = $value['ShortCode'];
                    echo "
                    <tr>
                        <td>$nombre</td>
                        <td>$shortcode]</td>
                        <td>
                            <a class='page-title-action'>Ver estadisticas</a>
                            <a class='page-title-action'>Borrar</a>
                        </td>
                    </tr>
                    ";
                }
            ?>
        </tbody>
    </table>
</div>
