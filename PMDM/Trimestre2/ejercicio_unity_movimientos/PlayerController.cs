using System.Collections;
using System.Collections.Generic;
using UnityEngine;

using UnityEngine.InputSystem;

public class PlayerController : MonoBehaviour
{
    public float speed = 0;
    private Rigidbody rb;
    private float movementX;
    private float movementY;
    private float movementZ;

    public float jumpForce = 5f;
    public Animator animator;


    
    void Start()
    {
        rb = GetComponent<Rigidbody>();
        animator = GetComponent<Animator>();        
    }


    void OnMove(InputValue movementValue) {
        Vector2 movementVector = movementValue.Get<Vector2>();
        movementX = movementVector.x;
        movementY = movementVector.y;
    }
    
    void OnJump(InputValue jumpValue)
    {
        if (Mathf.Abs(rb.velocity.y) < 0.01f)
        {
            Vector3 jumpForceVector = new Vector3(0, jumpForce, 0);
            rb.AddForce(jumpForceVector, ForceMode.Impulse);    
            animator.SetBool("isJumping", true);
        } 
        
    }

    void FixedUpdate() {
        Vector3 movement = new Vector3(movementX, 0.0f, movementY );

        // Aplicar fuerza en direcciones diferentes
        rb.AddForce(Vector3.forward * movementY * speed);
        rb.AddForce(Vector3.right * movementX * speed);

        // Agregar resistencia al aire
        rb.AddForce(rb.velocity * -0.1f);

        //rb.AddForce(movement * speed);
        if(movement.y < 0.01f) {
            animator.SetBool("isJumping", false);
        }

    }

    private void OnTriggerEnter(Collider other) {
        if(other.gameObject.CompareTag("PickUp")) {
            other.gameObject.SetActive(false);
        }

    }
    
    public void ChangeColor(bool isChangingColor)
    {
        animator.SetBool("isChangingColor", isChangingColor);
    }
    
}
