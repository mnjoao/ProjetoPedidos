package br.com.joaomm.projetopedidos.service;

import br.com.joaomm.projetopedidos.connection.ConnectionFactory;
import br.com.joaomm.projetopedidos.modelo.Pedido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

/**
 *
 * @author João Marcos
 */
public class PedidoService {
 
    //metodo para criar e salvar 
    public void save(Pedido pedido) {
        EntityManager em = new ConnectionFactory().getConnection();
        EntityTransaction transaction = em.getTransaction();
        
        try {
            em.getTransaction().begin();
            em.merge(pedido);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace(); // ou logar a exceção
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
    // atualiza
    public void update(Pedido pedido) {
        EntityManager em = new ConnectionFactory().getConnection();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            // Verifica se a Categoria já existe no banco de dados com o mesmo id
            Pedido existingCategoria = em.find(Pedido.class, pedido.getIdPedido());
            // Se já existe, realiza a atualização
            if (existingCategoria != null) {
                em.merge(pedido);
                }
                else{ // Lógica para lidar com a ausência de um id válido
                    System.out.println("**********************************");
                    throw new IllegalArgumentException("Não foi possivel alterar pedido"
                    + " do id " + pedido.getIdPedido() + " pois não existe no banco de dados."); 
                    }
                transaction.commit();
        }catch(IllegalArgumentException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace(); // ou logar a exceção
        }finally{
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
     
    public Pedido findId(Integer id){
        EntityManager em = new ConnectionFactory().getConnection();
        EntityTransaction transaction = em.getTransaction();
        Pedido pedido = null ; 
        try {
            pedido = em.find(Pedido.class, id);
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                System.err.println(e);
            }
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
            return pedido;
    } 
     
    public List<Pedido> findAll(){
        EntityManager em = new ConnectionFactory().getConnection();
        EntityTransaction transaction = em.getTransaction();
        List<Pedido> pedidos = null;
        try {
            transaction.begin();
            pedidos = em.createQuery("from Pedido").getResultList();
            for (Pedido pedido : pedidos) {
                pedido.getProdutos().size();
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                System.err.println(e);
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return pedidos;
    }
    
    public Pedido remove(Integer id){
        EntityManager em = new ConnectionFactory().getConnection();
        EntityTransaction transaction = em.getTransaction();
        Pedido pedido = null ;
        try {
            
            pedido = em.find(Pedido.class, id);
            em.getTransaction().begin();
            em.remove(pedido);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();   
        }
        return pedido;
    }
}
