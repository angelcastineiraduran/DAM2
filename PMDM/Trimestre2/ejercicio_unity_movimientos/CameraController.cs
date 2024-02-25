using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CameraController : MonoBehaviour
{

    public GameObject player;

    // va a ser privada porque solo quiero modificar esta var en el script
    // distancia entre la camara y el player
    private Vector3 offset;

    public GameObject centerOfRotation;
    public float rotationSpeed = 2.0f;


    void Start()
    {
        // esto tiene que suceder en cada frame por lo que tenemos que añadirlo en Update
        // calcula el "offset" inicial entre la posicion de la camara y la posicion del jugador.
        offset = transform.position - player.transform.position;
        
    }

    // -- PRIMERA SOLUCION (AUNQUE INCORRECTA) --
    // aunque lo pongamos aqui, no es la mejor posicion debido a que:
    // la posicion de la camara se realiza antes de que se ejecute el frame
    // esta transformacion podria ejecutarse antes de que se ejecute cualquier script
    // el mejor sitio dd poner el codigo es en el "Late Update" ya que aunque corre cada frame
    // (como el Update), va ser ejecutado despues de que se hayan ejecutado todas las otras actualizaciones
    /**
    void Update()
    {
        transform.position = player.transform.position + offset;
    }
    **/

    // -- SEGUNDA SOLUCION (CORRECTA) --
    // ahora la posicion de la camara NO se va a mover ANTES de que el "player" se ha movido debido a ese frame 
    // LateUpdate is called once per frame after all Upadte functions have been completed
    void LateUpdate()
    {
        // --CAMARA EN TERCERA PERSONA--
        // Establece la posición de la cámara en función de la posición del jugador
        //transform.position = player.transform.position + offset;

        // Asegura que la rotación de la cámara sea fija y no cambie
        //transform.rotation = Quaternion.Euler(Vector3.zero);

        // --CAMARA EN PRIMERA PERSONA--
        // Obtén la entrada del mouse para controlar la rotación de la cámara
        //float mouseX = Input.GetAxis("Mouse X");

        // Rota la cámara horizontalmente según la entrada del mouse
        //transform.RotateAround(player.transform.position, Vector3.up, mouseX * rotationSpeed);

        // Calcula la nueva posición de la cámara
        //Vector3 desiredPosition = player.transform.position - transform.forward;

        // Establece la posición de la cámara
        //transform.position = desiredPosition;

        // Asegura que la cámara siempre mire hacia el jugador
        //transform.LookAt(player.transform.position);

        // CAMARA INDEPENDIENTE DEL JUGADOR--
        // Rota la cámara horizontalmente de manera continua
        transform.RotateAround(centerOfRotation.transform.position, Vector3.up, rotationSpeed * Time.deltaTime);
    }
}
