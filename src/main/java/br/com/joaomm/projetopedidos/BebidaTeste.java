
package br.com.joaomm.projetopedidos;
import br.com.joaomm.projetopedidos.modelo.Bebida;
import br.com.joaomm.projetopedidos.service.BebidaService;
/**
 * @author João Marcos
 */
public class BebidaTeste {
    
    public static void Salvar(BebidaService bebidaService ){
    BebidaService cs = new BebidaService();
    Bebida c = new Bebida();
    c.setIdBebida(1);
    c.setGelada(true);
    c.setMarca("cocacola");
    c.setCodigo(123);
    c.setNome("cocacola");
    c.setValor(5.99f);
    cs.save(c);
    System.out.println("____Criado:________");
    c.toString();
    System.out.println();
    }
    
    public static void Atualizar(BebidaService bebidaService ){
    BebidaService cs = new BebidaService();
    Bebida c = new Bebida();
    
    c.setIdBebida(1);
    c.setCodigo(0202);
    c.setNome("cocacola zero");
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
        Bebida c = cs.findId(2);
        System.out.println("_____Bebida:________");
        c.toString();
    }
    
    public static void remover(BebidaService bebidaService ){
        Integer cate=6;
        BebidaService cs = new BebidaService();
        Bebida c = cs.remove(cate);
        System.out.println("_____Bebida_Removida________");
        c.toString();
       
    }

    
}//end class

