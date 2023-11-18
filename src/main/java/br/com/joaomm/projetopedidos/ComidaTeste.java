
package br.com.joaomm.projetopedidos;

import br.com.joaomm.projetopedidos.modelo.Comida;
import br.com.joaomm.projetopedidos.service.ComidaService;

/**
 *
 * @author João Marcos
 */
public class ComidaTeste {
    
    public static void Salvar(ComidaService comidaService ){
    Comida c = new Comida();
    c.setIdComida(1);
    c.setPeso(0.500f);
    c.setIngredientes("Ingredientes");
    c.setVegano(Boolean.TRUE);
    c.setCodigo(12345);
    c.setNome("almoço");
    c.setValor(25.99f);
    ComidaService.save(c);
    System.out.println("____Criado:________");
    c.toString();
    System.out.println();
    }
    
    public static void Atualizar(ComidaService comidaService ){
    ComidaService cs = new ComidaService();
    Comida c = new Comida();
    
    c.setIdComida(7);
    c.setIdProduto(9);
    c.setPeso(0.550f);
    c.setIngredientes("comida toptoptop");
    c.setVegano(Boolean.TRUE);
    c.setCodigo(4321);
    c.setNome("almoço top");
    c.setValor(29.99f);
    cs.update(c);
    
    System.out.println("______Atualizado:_____________________________");
    System.out.println("Comida{" + "idComida=" + c.getIdComida() + ", vegano=" + c.getVegano() + ", ingredientes=" + c.getIngredientes() + ", peso=" + c.getPeso() + '}');
    System.out.println();
    }
    
    public static void chamaTodas(ComidaService comidaService ){
        ComidaService cs = new ComidaService();
        for(Comida c:cs.findAll()){
            System.out.println("_____Lista_de_Todas_Comidas_________");
            System.out.println("Comida{" + "idComida=" + c.getIdComida() + ", vegano=" + c.getVegano() + ", ingredientes=" + c.getIngredientes() + ", peso=" + c.getPeso() + '}');
            System.out.println();
            
        }
    }
    
    public static void chamaId(ComidaService comidaService ){
        ComidaService cs = new ComidaService();
        Comida c = cs.findId(9);
        System.out.println("_____Comida:________");
        System.out.println("Comida{" + "idComida=" + c.getIdComida() + ", vegano=" + c.getVegano() + ", ingredientes=" + c.getIngredientes() + ", peso=" + c.getPeso() + '}');
            System.out.println();

    }
    
    public static void remover(ComidaService comidaService ){
        Integer cate=7;
        ComidaService cs = new ComidaService();
        Comida c = cs.remove(cate);
        System.out.println("_____Comida_Removida________");
        System.out.println("Comida{" + "idComida=" + c.getIdComida() + ", vegano=" + c.getVegano() + ", ingredientes=" + c.getIngredientes() + ", peso=" + c.getPeso() + '}');
            System.out.println();

       
    }

}
