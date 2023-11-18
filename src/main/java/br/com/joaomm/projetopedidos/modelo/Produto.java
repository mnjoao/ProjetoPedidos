
package br.com.joaomm.projetopedidos.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author João Marcos
 */
@Entity
@Table(name = "produto")
@Inheritance(strategy = InheritanceType.JOINED)
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idProduto")
    private Integer idProduto;
    @Column(name="nome")
    private String nome;
    @Column(name="valor")
    private Float valor;
    @Column(name="codigo")
    private int codigo;
    
    @ManyToOne
    @JoinColumn(name = "idPedido", nullable = true)
    private Pedido pedido; 
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
 }