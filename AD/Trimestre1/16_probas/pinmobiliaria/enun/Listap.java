
package pinmobiliaria;

import java.io.Serializable;
import java.text.NumberFormat;

public class Listap implements Serializable{     
	private String nifp;
        private String nomp;

    public Listap() {
    }

    public Listap(String nifp, String nomp) {
        this.nifp = nifp;
        this.nomp = nomp;
    }

public void setNifp(String nifp)
	{
	this.nifp = nifp;
	}

    public String getNomp() {
        return nomp;
    }

    public void setNomp(String nomp) {
        this.nomp = nomp;
    }

public String getNifp(){
	return nifp;
	}

    @Override
    public String toString() {
        return "Listap{" + "nifp=" + nifp + ", nomp=" + nomp + '}';
    }

}