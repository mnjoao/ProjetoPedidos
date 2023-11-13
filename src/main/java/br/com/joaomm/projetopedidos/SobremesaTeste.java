package br.com.joaomm.projetopedidos;

import br.com.joaomm.projetopedidos.modelo.Sobremesa;
import br.com.joaomm.projetopedidos.service.SobremesaService;

/**
 * @author João Marcos
 */
public class SobremesaTeste {
 
    
    public static void Salvar(SobremesaService sobremesaService ){
    SobremesaService cs = new SobremesaService();
    Sobremesa c = new Sobremesa();
    
    c.setQuantidade(0.100f);
    c.setInformacao("doce");
    c.setDoce(Boolean.TRUE);
    c.setCodigo(12);
    c.setNome("Sobremesa");
    c.setValor(9.99f);
    cs.save(c);
    System.out.println("____Criado:________");
    c.toString();
    System.out.println();
    }
    
    public static void Atualizar(SobremesaService sobremesaService ){
    SobremesaService cs = new SobremesaService();
    Sobremesa c = new Sobremesa();
    
    c.setIdSobremesa(1);
    c.setCodigo(123456);
    c.setNome("Sobremesa doces");
    cs.update(c);
    
    System.out.println("______Atualizado:_____________________________");
    c.toString();
    System.out.println();
    }
    
    public static void chamaTodas(SobremesaService sobremesaService ){
        SobremesaService cs = new SobremesaService();
        for(Sobremesa c:cs.findAll()){
            System.out.println("_____Lista_de_Todas_Sobremesas_________");
            c.toString();
            
        }
    }
    
    public static void chamaId(SobremesaService sobremesaService ){
        SobremesaService cs = new SobremesaService();
        Sobremesa c = cs.findId(2);
        System.out.println("_____Sobremesa:________");
        c.toString();
    }
    
    public static void remover(SobremesaService sobremesaService ){
        Integer cate=6;
        SobremesaService cs = new SobremesaService();
        Sobremesa c = cs.remove(cate);
        System.out.println("_____Sobremesa_Removida________");
        c.toString();
       
    }

}
