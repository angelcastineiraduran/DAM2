
package pavions;
import java.io.Serializable;
import javax.persistence.*;
@Entity
public class Confirmada implements Serializable{
    private static final long serialVersionUID = 1L; 
    @Id 
    int codr;  	 
    String dni  ;		
    String orixeida ;	
    String orixevolta;
    Double prezoreserva;

    public Confirmada() {
    }

    public Confirmada(int codr, String dni, String orixeida, String orixevolta, Double prezoreserva) {
        this.codr = codr;
        this.dni = dni;
        this.orixeida = orixeida;
        this.orixevolta = orixevolta;
        this.prezoreserva = prezoreserva;
    }

    public int getCodr() {
        return codr;
    }

    public void setCodr(int codr) {
        this.codr = codr;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getOrixeida() {
        return orixeida;
    }

    public void setOrixeida(String orixeida) {
        this.orixeida = orixeida;
    }

    public String getOrixevolta() {
        return orixevolta;
    }

    public void setOrixevolta(String orixevolta) {
        this.orixevolta = orixevolta;
    }

    public Double getPrezoreserva() {
        return prezoreserva;
    }

    public void setPrezoreserva(Double prezoreserva) {
        this.prezoreserva = prezoreserva;
    }

    @Override
    public String toString() {
        return "Confirmada{" + "codr=" + codr + ", dni=" + dni + ", orixeida=" + orixeida + ", orixevolta=" + orixevolta + ", prezoreserva=" + prezoreserva + '}';
    }

}
