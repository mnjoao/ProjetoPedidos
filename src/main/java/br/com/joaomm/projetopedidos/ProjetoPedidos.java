package br.com.joaomm.projetopedidos;

import br.com.joaomm.projetopedidos.service.*;

/**
 * @author João Marcos
 */
public class ProjetoPedidos {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        //BebidaService bs= new BebidaService(); BebidaTeste.Salvar(bs);
        
        PedidoService pe = new PedidoService();
        PedidoTeste.Salvar(pe);
        
    }
}
