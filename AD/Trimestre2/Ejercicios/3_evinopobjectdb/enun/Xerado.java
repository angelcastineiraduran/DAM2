
package evinopobjectdb;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Xerado {
  @Id String coda;
   String nomeuva;
    String tratacidez;
   int total;

    public Xerado() {
    }

    public Xerado(String coda, String nomeuva, String tratacidez, int total) {
        this.coda = coda;
        this.nomeuva = nomeuva;
        this.tratacidez = tratacidez;
        this.total = total;
    }

    public String getCoda() {
        return coda;
    }

    public void setCoda(String coda) {
        this.coda = coda;
    }

    public String getNomeuva() {
        return nomeuva;
    }

    public void setNomeuva(String nomeuva) {
        this.nomeuva = nomeuva;
    }

    public String getTratacidez() {
        return tratacidez;
    }

    public void setTratacidez(String tratacidez) {
        this.tratacidez = tratacidez;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Xerado{" + "coda=" + coda + ", nomeuva=" + nomeuva + ", tratacidez=" + tratacidez + ", total=" + total + '}';
    }

}
