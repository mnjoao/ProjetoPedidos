
package br.com.joaomm.projetopedidos;
import br.com.joaomm.projetopedidos.modelo.Bebida;
import br.com.joaomm.projetopedidos.modelo.Produto;
import br.com.joaomm.projetopedidos.service.BebidaService;
/**
 * @author João Marcos
 */
public class BebidaTeste {
    
    public static void Salvar(BebidaService bebidaService ){
    BebidaService cs = new BebidaService();
    Bebida c = new Bebida();
    
    c.setIdBebida(2);
    c.setGelada(true);
    c.setTamanho(2000);
    c.setMarca("coca2");
    
    Produto p = new Produto();
    p.getIdProduto();
    p.getValor(); 
    p.getCodigo();
    p.getNome();
    
    c.setIdProduto(2);
    cs.save(c);
    
    System.out.println("____Criado:________");
    c.toString();
    System.out.println();
    }
    
    public static void Atualizar(BebidaService bebidaService ){
    BebidaService cs = new BebidaService();
    Bebida c = new Bebida();
    
    c.setIdBebida(3);
    c.setIdProduto(5);
    c.setNome("cocacola zero");
    c.setTamanho(750);
    
    cs.update(c);
    
    System.out.println("______Atualizado:_____________________________");
    c.toString();
    System.out.println();
    }
    
    public static void chamaTodas(BebidaService bebidaService ){
        BebidaService cs = new BebidaService();
        for(Bebida c:cs.findAll()){
            System.out.println("_____Lista_de_Todas_Bebidas_________");
            c.toString();
            
        }
    }
    
    public static void chamaId(BebidaService bebidaService ){
        BebidaService cs = new BebidaService();
        Bebida c = cs.findId(5);
        
        System.out.println("_____Bebida:________");
        System.out.println("Bebida{" + "idBebida=" + c.getIdBebida() + ", tamanho=" + c.getTamanho() +
                ", gelada=" + c.getGelada() + ", marca=" + c.getMarca() +", nome=" + c.getNome() +
            ", codigo=" + c.getCodigo() + '}');
    }
    
    public static void remover(BebidaService bebidaService ){
        Integer remo=6;
        BebidaService cs = new BebidaService();
        Bebida c = cs.remove(remo);
        System.out.println("_____Bebida_Removida________");
        System.out.println("Bebida{" + "idBebida=" + c.getIdBebida() + ", tamanho=" + c.getTamanho() +
                ", gelada=" + c.getGelada() + ", marca=" + c.getMarca() +", nome=" + c.getNome() +
            ", codigo=" + c.getCodigo() + '}');
       
    }

    
}//end class

