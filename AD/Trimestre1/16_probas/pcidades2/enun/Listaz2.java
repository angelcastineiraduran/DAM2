
package pcidades2;

import java.io.Serializable;
import java.text.NumberFormat;


public class Listaz2 implements Serializable{     
	private String codz;
        private String nomz;
        private int total;

        public Listaz2(String codz, String nomz, int total) {
            this.codz = codz;
            this.nomz = nomz;
            this.total = total;
        }

        public Listaz2() {
        }

        public String getCodz() {
            return codz;
        }

        public void setCodz(String codz) {
            this.codz = codz;
        }

        public String getNomz() {
            return nomz;
        }

        public void setNomz(String nomz) {
            this.nomz = nomz;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
        
        @Override
        public String toString() {
            return "Listap{" + "codz=" + codz + ", nomz=" + nomz + ", total=" + total + '}';
        }

}
