/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.joaomm.projetopedidos;

import br.com.joaomm.projetopedidos.modelo.Produto;
import br.com.joaomm.projetopedidos.modelo.Pedido;
import br.com.joaomm.projetopedidos.modelo.Solicitante;
import br.com.joaomm.projetopedidos.service.PedidoService;
import br.com.joaomm.projetopedidos.service.ProdutoService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 *
 * @author João Marcos
 */
public class PedidoTeste {
    
    public static void Salvar(PedidoService pedidoService ){
        
        PedidoService cs = new PedidoService();
        Pedido pedido = new Pedido();

        pedido.setIdPedido(1);
        pedido.setDescricao("pedido sem talher");
        pedido.setWeb(Boolean.TRUE);

        Solicitante solicitante = new Solicitante();
        solicitante.setIdSolicitante(1);
        pedido.setSolicitante(solicitante);
        
        Produto produto = new Produto();
        produto.setIdProduto(1);
        
        List<Produto> produtos = new ArrayList<>();
        produtos.add(produto);
        pedido.setProdutos(produtos);
        
        LocalDateTime localDateTime = LocalDateTime.now(); // Substitua isso pelo valor desejado
        Date date = java.util.Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        pedido.setLocalDateTime(date);
        
        cs.save(pedido);

        System.out.println("____Criado_____");
        System.out.println();
    }
    
    public static void Atualizar(PedidoService pedidoService ){
        PedidoService cs = new PedidoService();
        Pedido pedido = new Pedido();

        pedido.setIdPedido(3);
        pedido.setDescricao("pedido com talher");
        pedido.setWeb(Boolean.TRUE);
        
        Solicitante solicitante = new Solicitante();
        solicitante.setIdSolicitante(1);
        pedido.setSolicitante(solicitante);
        
        LocalDateTime localDateTime = LocalDateTime.now(); // Substitua isso pelo valor desejado
        Date date = java.util.Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        pedido.setLocalDateTime(date);
        
        cs.update(pedido);

        System.out.println("______Atualizado:_____________________________");
        System.out.println("Pedido{" + "idPedido=" + pedido.getIdPedido() + ", descricao=" +pedido.getDescricao()+ ", LocalDateTime=" +pedido.getLocalDateTime() + ", web=" +pedido.getWeb());   
        System.out.println();
    }
    
    public static void chamaTodas(PedidoService pedidoService ){
        PedidoService cs = new PedidoService();
        for(Pedido c:cs.findAll()){
            System.out.println("_____Lista_de_Todas_Pedidos_______");
            System.out.println("Pedido{" + "idPedido=" + c.getIdPedido() + ", descricao=" +c.getDescricao()+ ", LocalDateTime=" +c.getLocalDateTime() + ", web=" +c.getWeb() );
            
        }
    }
    
    public static void chamaId(PedidoService pedidoService ){
        PedidoService cs = new PedidoService();
        Pedido c = cs.findId(2);
        System.out.println("_____Pedido:________");
        System.out.println("Pedido{" + "idPedido=" + c.getIdPedido() + ", descricao=" +c.getDescricao()+ ", LocalDateTime=" +c.getLocalDateTime() + ", web=" +c.getWeb() );
            
    }
    
    public static void remover(PedidoService pedidoService ){
        Integer cate=3;
        PedidoService cs = new PedidoService();
        Pedido c = cs.remove(cate);
        System.out.println("_____Pedido_Removido________");
        System.out.println("Pedido{" + "idPedido=" + c.getIdPedido() + ", descricao=" +c.getDescricao()+ ", LocalDateTime=" +c.getLocalDateTime() + ", web=" +c.getWeb() );

    }
}