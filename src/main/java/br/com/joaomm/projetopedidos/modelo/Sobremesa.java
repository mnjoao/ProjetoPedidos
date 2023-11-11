
package br.com.joaomm.projetopedidos.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author João Marcos
 */
@Entity
@Table(name = "Sobremas")
public class Sobremesa extends Produto{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idBebida")
    private int idBebida; 
    @Column(name="quantidade")
    private Float quantidade;
    @Column(name="doce")
    private Boolean doce;
    @Column(name="informacao")
    private String informacao;

    public int getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(int idBebida) {
        this.idBebida = idBebida;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    public Boolean getDoce() {
        return doce;
    }

    public void setDoce(Boolean doce) {
        this.doce = doce;
    }

    public String getInformacao() {
        return informacao;
    }

    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }
    
    
}
