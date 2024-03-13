
package pinvasoras;
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Zonas implements Serializable {
  @Id 
    private int codz;
    private String nomz ; 
    private int tempmedia ; 
    private Double superficie ; 
    private int numeroinvasoras;

    public Zonas() {
    }

    public Zonas(int codz, String nomz, int tempmedia, Double superficie,int numeroinvasoras) {
        this.codz = codz;
        this.nomz = nomz;
        this.tempmedia = tempmedia;
        this.superficie = superficie;
        this.numeroinvasoras= numeroinvasoras;
    }

    public int getCodz() {
        return codz;
    }

    public void setCodz(int codz) {
        this.codz = codz;
    }

    public String getNomz() {
        return nomz;
    }

    public void setNomz(String nomz) {
        this.nomz = nomz;
    }

    public int getTempmedia() {
        return tempmedia;
    }

    public void setTempmedia(int tempmedia) {
        this.tempmedia = tempmedia;
    }

    public Double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Double superficie) {
        this.superficie = superficie;
    }

    public int getNumeroinvasoras() {
        return numeroinvasoras;
    }

    public void setNumeroinvasoras(int numeroinvasoras) {
        this.numeroinvasoras = numeroinvasoras;
    }

    @Override
    public String toString() {
        return "Zonas{" + "codz=" + codz + ", nomz=" + nomz + ", tempmedia=" + tempmedia + ", superficie=" + superficie + ", numeroinvasoras=" + numeroinvasoras + '}';
    }

   

    
}
