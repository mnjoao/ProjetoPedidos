
package br.com.joaomm.projetopedidos;

import br.com.joaomm.projetopedidos.modelo.Comida;
import br.com.joaomm.projetopedidos.service.ComidaService;

/**
 *
 * @author João Marcos
 */
public class ComidaTeste {
    
    public static void Salvar(ComidaService comidaService ){
    ComidaService cs = new ComidaService();
    Comida c = new Comida();
    
    c.setPeso(0.500f);
    c.setIngredientes("Ingredientes");
    c.setVegano(Boolean.TRUE);
    c.setCodigo(12345);
    c.setNome("almoço");
    c.setValor(25.99f);
    cs.save(c);
    System.out.println("____Criado:________");
    c.toString();
    System.out.println();
    }
    
    public static void Atualizar(ComidaService comidaService ){
    ComidaService cs = new ComidaService();
    Comida c = new Comida();
    
    c.setIdComida(1);
    c.setCodigo(123456);
    c.setNome("Almoço zero");
    cs.update(c);
    
    System.out.println("______Atualizado:_____________________________");
    c.toString();
    System.out.println();
    }
    
    public static void chamaTodas(ComidaService comidaService ){
        ComidaService cs = new ComidaService();
        for(Comida c:cs.findAll()){
            System.out.println("_____Lista_de_Todas_Comidas_________");
            c.toString();
            
        }
    }
    
    public static void chamaId(ComidaService comidaService ){
        ComidaService cs = new ComidaService();
        Comida c = cs.findId(2);
        System.out.println("_____Comida:________");
        c.toString();
    }
    
    public static void remover(ComidaService comidaService ){
        Integer cate=6;
        ComidaService cs = new ComidaService();
        Comida c = cs.remove(cate);
        System.out.println("_____Comida_Removida________");
        c.toString();
       
    }

}
