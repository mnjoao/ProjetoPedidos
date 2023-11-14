
package br.com.joaomm.projetopedidos.modelo;

import jakarta.persistence.*;

/**
 *
 * @author João Marcos
 */
@Entity
@Table(name="comida")
public class Comida extends Produto{
    
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idComida")
    private Integer idComida;
    @Column(name="vegano")
    private Boolean vegano;
    @Column(name="ingredientes")
    private String ingredientes;
    @Column(name="peso")
    private Float peso;

    public Integer getIdComida() {
        return idComida;
    }

    public void setIdComida(Integer idComida) {
        this.idComida = idComida;
    }

    public Boolean getVegano() {
        return vegano;
    }

    public void setVegano(Boolean vegano) {
        this.vegano = vegano;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }
    
    
    
}
