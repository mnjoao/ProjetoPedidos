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
    c.setIdSobremesa(2);
    c.setQuantidade(0.100f);
    c.setInformacao("doce");
    c.setDoce(Boolean.TRUE);
    c.setCodigo(120000);
    c.setNome("Sobremesa");
    c.setValor(9.99f);
    cs.save(c);
    System.out.println("_____Criado______");
    System.out.println();
    }
    
    public static void Atualizar(SobremesaService sobremesaService ){
    SobremesaService cs = new SobremesaService();
    Sobremesa c = new Sobremesa();
    c.setIdProduto(11);
    
    c.setIdSobremesa(10);
    c.setQuantidade(0.100f);
    c.setInformacao("Doces balas");
    c.setDoce(Boolean.FALSE);
    cs.update(c);
    
    System.out.println("______Atualizado:_____________________________");
    System.out.println("Sobremesa{" + "idSobremesa=" + c.getIdSobremesa() + ", quantidade=" +c.getQuantidade() + ", doce=" +c.getDoce() + ", informacao=" +c.getInformacao()+ '}');
    }
    
    public static void chamaTodas(SobremesaService sobremesaService ){
        SobremesaService cs = new SobremesaService();
        for(Sobremesa c:cs.findAll()){
            System.out.println("_____Lista_de_Todas_Sobremesas_________");
            System.out.println("Sobremesa{" + "idSobremesa=" + c.getIdSobremesa() + ", quantidade=" +c.getQuantidade() + ", doce=" +c.getDoce() + ", informacao=" +c.getInformacao()+ '}');
            
        }
    }
    
    public static void chamaId(SobremesaService sobremesaService ){
        SobremesaService cs = new SobremesaService();
        Sobremesa c = cs.findId(11);
        System.out.println("_____Sobremesa:________");
        System.out.println("Sobremesa{" + "idSobremesa=" + c.getIdSobremesa() + ", quantidade=" +c.getQuantidade() + ", doce=" +c.getDoce() + ", informacao=" +c.getInformacao()+ '}');
    }
    
    public static void remover(SobremesaService sobremesaService ){
        Integer remo=12;
        SobremesaService cs = new SobremesaService();
        Sobremesa c = cs.remove(remo);
        System.out.println("_____Sobremesa_Removida________");
       System.out.println("Sobremesa{" + "idSobremesa=" + c.getIdSobremesa() + ", quantidade=" +c.getQuantidade() + ", doce=" +c.getDoce() + ", informacao=" +c.getInformacao()+ '}');
       
    }

}
