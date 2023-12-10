
(function (blocks, components, i18n, element) {


    blocks.registerBlockType(
        'common/history', {
            title: i18n_('History & Timeline'),
            icon: 'book',
            category: 'common',
            attributes: {
                title: {type: 'string'},
                total: {type: 'int'},
                date: {type: 'string'},
                text: {type: 'string'},
                mediaID: {
                    type: 'number',
                },
                mediaURL: {
                    type: 'string',
                    source: 'attribute',
                    selector: 'img',
                    attribute: 'src',
                }
            },

            edit: function (props) {

                // 1. VARIABLES PRINCIPALES
                // para poner el foco en el primer campo del formulario
                var focus = props.focus;
                // para que ese foco sea editable
                var focusedEditable = props.focus ? props.focus.editable || 'name' : null;
                var alignment = props.attributes.alignment;
                var attributes = props.attributes;
                var contactURL = props.attributes.contactURL;
                // contador para si queremos llegar a usarlo
                var count = 0;

                // 2. FUNCIONES INTERNAS
                // conseguimos el titulo y lo guardamos temporalmente
                function updateTitle(event) {
                    props.setAttributes({title: event.target.value})
                    cont = 1;
                }

                function updateTotal(event) {
                    props.setAttributes({total: event.target.value})
                    cont = 2;
                }

                function updateText(event) {
                    props.setAttributes({text: event.target.value})
                }


                // para la foto de portada del libro
                // cd selccionemos una imagen nos traiga unos estilos y nos la inserte y luego que recoga su contendido
                var onSelectImage = function (media) {
                    var x = document.querySelectorAll("#contenedor-1");
                    x[0].classList.add("none");

                    var x1 = document.querySelectorAll(".paso-1");
                    x1[0].classList.add("success");

                    props.setAttributes({
                        mediaURL: media.url,
                        mediaID: media.id,
                    });
                };

                // 3. PARTE MÁS DETALLADA QUE CONTIENE EL FORMULARIO
                // funcion que necesitamos para la parte interna de nuestro wp, es la que muestra la info
                // que se va a recoger.
                return[
                    //....ME QUEDE AQUI...
                ]
            }
        }
    )
    ;
})