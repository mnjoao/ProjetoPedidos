package br.com.joaomm.projetopedidos;

import br.com.joaomm.projetopedidos.modelo.Pedido;
import br.com.joaomm.projetopedidos.modelo.Solicitante;
import br.com.joaomm.projetopedidos.service.SolicitanteService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author João Marcos
 */
public class SolicitanteTeste {
    
    public static void Salvar(SolicitanteService solicitanteService ){
        
        SolicitanteService cs = new SolicitanteService();
        Solicitante solicitante = new Solicitante();
        
        solicitante.setCpf("789");
        solicitante.setEmail("joao@.com");
        solicitante.setNome("Solicitante joao");
        
        Pedido pedido =new Pedido();
        pedido.setIdPedido(1); 
        
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido);
        solicitante.setPedidos(pedidos);
        cs.save(solicitante);
        
        System.out.println("____Criado:________");
        System.out.println("Solicitante{"+ "idSolicitante=" + solicitante.getIdSolicitante()+", nome=" +solicitante.getNome() + 
        ", cpf=" + solicitante.getCpf() + ", email=" + solicitante.getEmail() + ", pedidos=" + solicitante.getPedidos() + '}');
    
        System.out.println();
    }
    
    public static void Atualizar(SolicitanteService solicitanteService ){
        SolicitanteService cs = new SolicitanteService();
        Solicitante c = new Solicitante();
        c.setIdSolicitante(2);
        c.setCpf("05436");
        c.setEmail("joao@gmail.com");
        c.setNome("Solicitas doces bolado");
        cs.update(c);

        System.out.println("______Atualizado:_____________________________");
        c.toString();
        System.out.println("Solicitante{" 
                + "idSolicitante=" + c.getIdSolicitante()+ ", nome=" + c.getNome() + ", cpf=" + c.getCpf() + ", email=" + c.getEmail() + ", pedidos=" + c.getPedidos() + '}');
    }
    
    public static void chamaTodas(SolicitanteService solicitanteService ){
        SolicitanteService cs = new SolicitanteService();
        for(Solicitante c:cs.findAll()){
            System.out.println("_____Lista_de_Todas_Solicitantes_________");
            System.out.println("Solicitante{" 
                + "idSolicitante=" + c.getIdSolicitante()+ ", nome=" + c.getNome() + 
                    ", cpf=" + c.getCpf() + ", email=" + c.getEmail() + ", pedidos=" + c.getPedidos() + '}');
            
        }
    }

    public static void chamaId(SolicitanteService solicitanteService ){
        SolicitanteService cs = new SolicitanteService();
        Solicitante c = cs.findId(3);
        System.out.println("_____Solicitante:________");
        System.out.println("Solicitante{" 
                + "idSolicitante=" + c.getIdSolicitante()+ ", nome=" + c.getNome() + ", cpf=" + c.getCpf() + ", email=" + c.getEmail() + ", pedidos=" + c.getPedidos() + '}');
    }
    
    public static void remover(SolicitanteService solicitanteService ){
        Integer cate=2;
        SolicitanteService cs = new SolicitanteService();
        Solicitante c = cs.remove(cate);
        System.out.println("_____Solicitante_Removida________");
        c.toString();
       
    }
}
