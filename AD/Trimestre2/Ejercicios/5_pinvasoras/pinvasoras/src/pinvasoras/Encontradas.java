
package pinvasoras;
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Encontradas  implements Serializable {
 @Id private int numero;
    private int codzona;
    private int codespecie; 
    private Double extension; 

    public Encontradas() {
    }

    public Encontradas(int numero, int codzona, int codespecie, Double extension) {
        this.numero = numero;
        this.codzona = codzona;
        this.codespecie = codespecie;
        this.extension = extension;
    }
  public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCodzona() {
        return codzona;
    }

    public void setCodzona(int codzona) {
        this.codzona = codzona;
    }

    public int getCodespecie() {
        return codespecie;
    }

    public void setCodespecie(int codespecie) {
        this.codespecie = codespecie;
    }

    public Double getExtension() {
        return extension;
    }

    public void setExtension(Double extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "Encontradas{" + "numero=" + numero + ", codzona=" + codzona + ", codespecie=" + codespecie + ", extension=" + extension + '}';
    }


}
