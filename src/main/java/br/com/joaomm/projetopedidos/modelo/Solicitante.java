
package br.com.joaomm.projetopedidos.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author João Marcos
 */
@Table(name="solicitante")
@Entity
public class Solicitante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idSolicitante")
    private Integer idSolicitante;
    @Column(name="nome")
    private String nome;
    @Column(name="cpf")
    private String cpf;
    @Column(name="email")
    private String email;
    
    @OneToMany(mappedBy = "pedido_idPedido")
    private Pedido pedido;
    
    
    
    public Integer getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(Integer idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
