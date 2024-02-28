/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evinopobjectdb;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity

public class Uvas {
   @Id String codu;
   String nomeu;
 int acidezmin;
   int acidezmax;

    public Uvas() {
    }

    public Uvas(String codu, String nomeu, int acidezmin, int acidezmax) {
        this.codu = codu;
        this.nomeu = nomeu;
        this.acidezmin = acidezmin;
        this.acidezmax = acidezmax;
    }

    public String getCodu() {
        return codu;
    }

    public void setCodu(String codu) {
        this.codu = codu;
    }

    public String getNomeu() {
        return nomeu;
    }

    public void setNomeu(String nomeu) {
        this.nomeu = nomeu;
    }

    public int getAcidezmin() {
        return acidezmin;
    }

    public void setAcidezmin(int acidezmin) {
        this.acidezmin = acidezmin;
    }

    public int getAcidezmax() {
        return acidezmax;
    }

    public void setAcidezmax(int acidezmax) {
        this.acidezmax = acidezmax;
    }

    @Override
    public String toString() {
        return "Uvas{" + "codu=" + codu + ", nomeu=" + nomeu + ", acidezmin=" + acidezmin + ", acidezmax=" + acidezmax + '}';
    }
   
   
}
