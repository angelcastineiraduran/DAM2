/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serializacion_1;

import java.io.Serializable;

/**
 *
 * @author dam2
 */
public class MClase implements Serializable{
    String nome;
    transient int numero1; // para que 
    double numero2;

    public MClase() {
    }

    public MClase(String nome, int numero1, double numero2) {
        this.nome = nome;
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MClase{");
        sb.append("nome=").append(nome);
        sb.append(", numero1=").append(numero1);
        sb.append(", numero2=").append(numero2);
        sb.append('}');
        return sb.toString();
    }
    
}
