
package br.com.joaomm.projetopedidos.modelo;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
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
@Table(name = "bebida")
@AttributeOverrides({
        @AttributeOverride(name="nome", column=@Column(name="nome")),
        @AttributeOverride(name="valor", column=@Column(name="valor")),
        @AttributeOverride(name="codigo", column=@Column(name="codigo"))
    })
public class Bebida extends Produto{
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idBebida")
    private Integer idBebida;
    @Column(name="tamanho")
    private float tamanho;
    @Column(name="gelada")
    private Boolean gelada;
    @Column(name="marca")
    private String marca;

    @Override
    public void setCodigo(int codigo) {
        super.setCodigo(codigo); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public int getCodigo() {
        return super.getCodigo(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setValor(Float valor) {
        super.setValor(valor); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public Float getValor() {
        return super.getValor(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getNome() {
        return super.getNome(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    public Integer getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(Integer idBebida) {
        this.idBebida = idBebida;
    }

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }

    public Boolean getGelada() {
        return gelada;
    }

    public void setGelada(Boolean gelada) {
        this.gelada = gelada;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setGelada(boolean b) {
       
    }

    @Override
    public String toString() {
        return "Bebida{" + "idBebida=" + getIdBebida() + ", tamanho=" + getTamanho() +
                ", gelada=" + getGelada() + ", marca=" + getMarca() +", nome=" + getNome() +
            ", codigo=" + getCodigo() + '}';
    }  
}
