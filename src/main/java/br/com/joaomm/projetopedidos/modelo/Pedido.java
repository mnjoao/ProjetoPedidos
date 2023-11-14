
package br.com.joaomm.projetopedidos.modelo;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

/**
 *
 * @author João Marcos
 */
@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPedido")
    private Integer idPedido;
    @Column(name="descricao")
    private String descricao;
    @Column(name="LocalDateTime")
    private Date LocalDateTime;
    @Column(name="web")
    private Boolean web;
    
    @ManyToOne
    @JoinColumn(name = "solicitante_id")
    private Solicitante solicitante;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToMany(mappedBy = "produto")
    private Produto produto;

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getLocalDateTime() {
        return LocalDateTime;
    }

    public void setLocalDateTime(Date LocalDateTime) {
        this.LocalDateTime = LocalDateTime;
    }

    public Boolean getWeb() {
        return web;
    }

    public void setWeb(Boolean web) {
        this.web = web;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
}
