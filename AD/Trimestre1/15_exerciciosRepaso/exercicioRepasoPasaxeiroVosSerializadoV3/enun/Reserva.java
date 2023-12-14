

package pasaxeirosvoosserializadooracle_3;

import java.io.Serializable;

public class Reserva implements Serializable{
 private int codr;
 private String dni;
 private int idvooida;
 private int idvoovolta ;

    public Reserva() {
    
    }
 
    public Reserva(int codr, String dni, int idvooida, int idvoovolta) {
        this.codr = codr;
        this.dni = dni;
        this.idvooida = idvooida;
        this.idvoovolta = idvoovolta;
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

    public int getIdvooida() {
        return idvooida;
    }

    public void setIdvooida(int idvooida) {
        this.idvooida = idvooida;
    }

    public int getIdvoovolta() {
        return idvoovolta;
    }

    public void setIdvoovolta(int idvoovolta) {
        this.idvoovolta = idvoovolta;
    }

    @Override
    public String toString() {
        return "Reserva{" + "codr=" + codr + ", dni=" + dni + ", idvooida=" + idvooida + ", idvoovolta=" + idvoovolta + '}';
    }
    

    }

  
 
 
 

