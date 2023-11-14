package br.com.joaomm.projetopedidos;

import br.com.joaomm.projetopedidos.modelo.Pedido;
import br.com.joaomm.projetopedidos.modelo.Solicitante;
import br.com.joaomm.projetopedidos.service.SolicitanteService;
import java.util.Arrays;
import java.util.List;

/**
 * @author João Marcos
 */
public class SolicitanteTeste {
    
    public static void Salvar(SolicitanteService solicitanteService ){
        
        SolicitanteService cs = new SolicitanteService();
        Solicitante s = new Solicitante();
        s.setCpf("012345679");
        s.setEmail("emial@.com");
        s.setNome("Solicitante");
        
        Pedido p =new Pedido();
        p.setIdPedido(1); 
        s.setPedido(p);
        cs.save(s);
        System.out.println("____Criado:________");
        s.toString();
        System.out.println();
    }
    
    public static void Atualizar(SolicitanteService solicitanteService ){
        SolicitanteService cs = new SolicitanteService();
        Solicitante c = new Solicitante();

        c.setIdSolicitante(1);
        c.setEmail("carlo@gmail.com");
        c.setNome("Solicitante doces");
        cs.update(c);

        System.out.println("______Atualizado:_____________________________");
        c.toString();
        System.out.println();
    }
    
    public static void chamaTodas(SolicitanteService solicitanteService ){
        SolicitanteService cs = new SolicitanteService();
        for(Solicitante c:cs.findAll()){
            System.out.println("_____Lista_de_Todas_Solicitantes_________");
            c.toString();
            
        }
    }
    
    public static void chamaId(SolicitanteService solicitanteService ){
        SolicitanteService cs = new SolicitanteService();
        Solicitante c = cs.findId(2);
        System.out.println("_____Solicitante:________");
        c.toString();
    }
    
    public static void remover(SolicitanteService solicitanteService ){
        Integer cate=6;
        SolicitanteService cs = new SolicitanteService();
        Solicitante c = cs.remove(cate);
        System.out.println("_____Solicitante_Removida________");
        c.toString();
       
    }
}
