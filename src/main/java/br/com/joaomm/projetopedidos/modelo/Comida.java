
package br.com.joaomm.projetopedidos.modelo;

import jakarta.persistence.*;

/**
 *
 * @author João Marcos
 */
@Entity
@Table(name="Comida")
public class Comida extends Produto{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idComida")
    private int idComida;
    @Column(name="vegano")
    private Boolean vegano;
    @Column(name="ingredientes")
    private String ingredientes;

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
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
    
    
    
}
