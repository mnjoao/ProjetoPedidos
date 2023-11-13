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
    Produto produ = new Produto();
    produ.setIdProduto(1);
    pedido.setProdutos((List<Produto>) produ);
    cs.save(pedido);
    
    System.out.println("____Criado:________");
    pedido.toString();
    System.out.println();
    }
    
    public static void Atualizar(PedidoService pedidoService ){
    PedidoService cs = new PedidoService();
    Pedido pedido = new Pedido();
    
    pedido.setIdPedido(1);
    pedido.setDescricao("pedido com talher");
    cs.update(pedido);
    
    System.out.println("______Atualizado:_____________________________");
    pedido.toString();
    System.out.println();
    }
    
    public static void chamaTodas(PedidoService pedidoService ){
        PedidoService cs = new PedidoService();
        for(Pedido c:cs.findAll()){
            System.out.println("_____Lista_de_Todas_Pedidos_________");
            c.toString();
            
        }
    }
    
    public static void chamaId(PedidoService pedidoService ){
        PedidoService cs = new PedidoService();
        Pedido c = cs.findId(2);
        System.out.println("_____Pedido:________");
        c.toString();
    }
    
    public static void remover(PedidoService pedidoService ){
        Integer cate=6;
        PedidoService cs = new PedidoService();
        Pedido c = cs.remove(cate);
        System.out.println("_____Pedido_Removida________");
        c.toString();
       
    }
}