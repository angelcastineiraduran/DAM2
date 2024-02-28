
package evinopobjectdb;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Analisis {
  @Id String coda;
 int acidez;
  String tipouva;
   int cantidade;
  String dni;

    public Analisis() {
    }

    public Analisis(String coda, int acidez, String tipouva, int cantidade, String dni) {
        this.coda = coda;
        this.acidez = acidez;
        this.tipouva = tipouva;
        this.cantidade = cantidade;
        this.dni = dni;
    }

    public String getCoda() {
        return coda;
    }

    public void setCoda(String coda) {
        this.coda = coda;
    }

    public int getAcidez() {
        return acidez;
    }

    public void setAcidez(int acidez) {
        this.acidez = acidez;
    }

    public String getTipouva() {
        return tipouva;
    }

    public void setTipouva(String tipouva) {
        this.tipouva = tipouva;
    }

    public int getCantidade() {
        return cantidade;
    }

    public void setCantidade(int cantidade) {
        this.cantidade = cantidade;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Analisis{" + "coda=" + coda + ", acidez=" + acidez + ", tipouva=" + tipouva + ", cantidade=" + cantidade + ", dni=" + dni + '}';
    }
 
}
