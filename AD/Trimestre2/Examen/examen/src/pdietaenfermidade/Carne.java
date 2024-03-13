
package pdietaenfermidade;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Carne {
  @Id 
    private String nome ;
    private Double colesterol ; 

    public Carne() {
    }

    public Carne(String nome, Double colesterol) {
        this.nome = nome;
        this.colesterol = colesterol;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getColesterol() {
        return colesterol;
    }

    public void setColesterol(Double colesterol) {
        this.colesterol = colesterol;
    }

    @Override
    public String toString() {
        return "Carne{" + "nome=" + nome + ", colesterol=" + colesterol + '}';
    }
   
}
