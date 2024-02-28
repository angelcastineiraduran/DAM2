/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evinopobjectdb;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Clientes {
    @Id String dni;
   String nome;
    int telf;
   int numerodeanalisis;

    public Clientes() {
    }

    public Clientes(String dni, String nome, int telf, int numerodeanalisis) {
        this.dni = dni;
        this.nome = nome;
        this.telf = telf;
        this.numerodeanalisis = numerodeanalisis;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelf() {
        return telf;
    }

    public void setTelf(int telf) {
        this.telf = telf;
    }

    public int getNumerodeanalisis() {
        return numerodeanalisis;
    }

    public void setNumerodeanalisis(int numerodeanalisis) {
        this.numerodeanalisis = numerodeanalisis;
    }

    @Override
    public String toString() {
        return "Clientes{" + "dni=" + dni + ", nome=" + nome + ", telf=" + telf + ", numerodeanalisis=" + numerodeanalisis + '}';
    }
   
   
   
}
