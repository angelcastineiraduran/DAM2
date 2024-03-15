
package pdietaenfermidadeopm;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Persoas {
    @Id 
    private String idp ;
    private String enfermidade ; 

    public Persoas() {
    }

    public Persoas(String idp, String enfermidade) {
        this.idp = idp;
        this.enfermidade = enfermidade;
    }

    public String getIdp() {
        return idp;
    }

    public void setIdp(String idp) {
        this.idp = idp;
    }

    public String getEnfermidade() {
        return enfermidade;
    }

    public void setEnfermidade(String enfermidade) {
        this.enfermidade = enfermidade;
    }

    @Override
    public String toString() {
        return "Persoas{" + "idp=" + idp + ", enfermidade=" + enfermidade + '}';
    }
 
}
