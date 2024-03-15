
package pdietaenfermidadeopm;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Enfermidades {
    @Id 
    private String ide ;
    private Double maxcolesterolsemanal ; 

    public Enfermidades() {
    }

    public Enfermidades(String ide, Double maxcolesterolsemanal) {
        this.ide = ide;
        this.maxcolesterolsemanal = maxcolesterolsemanal;
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }

    public Double getMaxcolesterolsemanal() {
        return maxcolesterolsemanal;
    }

    public void setMaxcolesterolsemanal(Double maxcolesterolsemanal) {
        this.maxcolesterolsemanal = maxcolesterolsemanal;
    }

    @Override
    public String toString() {
        return "Enfermidades{" + "ide=" + ide + ", maxcolesterolsemanal=" + maxcolesterolsemanal + '}';
    }
    
}
