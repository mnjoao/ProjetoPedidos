
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
@Table(name = "Bebida")
public class Bebida extends Produto{
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idBebida")
    private int idBebida;
    @Column(name="peso")
    private float peso;
    @Column(name="vegano")
    private Boolean vegano;
    @Column(name="ingredientes")
    private String ingredientes;

    public int getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(int idBebida) {
        this.idBebida = idBebida;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
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
