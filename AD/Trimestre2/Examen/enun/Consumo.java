
package pdietaenfermidade;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Consumo {
    @Id 
    private int id;
    private String dni ; 
    private int dia;
    private int gramos;
    private String tipocarne ; 

    public Consumo() {
    }

    public Consumo(int id, String dni, int dia, int gramos, String tipocarne) {
        this.id = id;
        this.dni = dni;
        this.dia = dia;
        this.gramos = gramos;
        this.tipocarne = tipocarne;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getGramos() {
        return gramos;
    }

    public void setGramos(int gramos) {
        this.gramos = gramos;
    }

    public String getTipocarne() {
        return tipocarne;
    }

    public void setTipocarne(String tipocarne) {
        this.tipocarne = tipocarne;
    }

    @Override
    public String toString() {
        return "Consumo{" + "id=" + id + ", dni=" + dni + ", dia=" + dia + ", gramos=" + gramos + ", tipocarne=" + tipocarne + '}';
    }

    
}
