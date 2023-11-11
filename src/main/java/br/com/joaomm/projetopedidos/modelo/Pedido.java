
package br.com.joaomm.projetopedidos.modelo;

import jakarta.persistence.*;
import java.util.Date;

/**
 *
 * @author João Marcos
 */
@Entity
@Table(name = "Pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPedido")
    private int idPedido;
    @Column(name="descricao")
    private String descricao;
    @Column(name="descricao")
    private Date LocalDateTime;
    @Column(name="web")
    private Boolean web;
    
    
    
    public int getIdPedido() {
        return idPedido;
    }

    public void setId(int idPedido) {
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
    
}
