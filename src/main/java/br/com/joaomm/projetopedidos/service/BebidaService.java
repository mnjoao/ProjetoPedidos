
package br.com.joaomm.projetopedidos.service;

import br.com.joaomm.projetopedidos.connection.ConnectionFactory;
import br.com.joaomm.projetopedidos.modelo.Bebida;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

/**
 *
 * @author João Marcos
 */
public class BebidaService {
   
    EntityManager em = new ConnectionFactory().getConnection();
    EntityTransaction transaction = em.getTransaction();
        
    //metodo para criar e salvar 
    public void save(Bebida bebida) {
        try {
            transaction.begin();
            em.persist(bebida);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace(); // ou logar a exceção
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
    // atualiza
    public void update(Bebida bebida) {
        try {
            transaction.begin();
            // Verifica se a Categoria já existe no banco de dados com o mesmo id
            Bebida existingCategoria = em.find(Bebida.class, bebida.getIdBebida());
            // Se já existe, realiza a atualização
            if (existingCategoria != null) {
                em.merge(bebida);
                }
                else{ // Lógica para lidar com a ausência de um id válido
                    System.out.println("**********************************");
                    throw new IllegalArgumentException("Não foi possivel alterar Bebida"
                    + " do id " + bebida.getIdBebida() + " pois não existe no banco de dados."); 
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
     
    public Bebida findId(Integer id){
        Bebida bebida = null ; 
        try {
            bebida = em.find(Bebida.class, id);
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
            return bebida;
    } 
     
    public List<Bebida> findAll(){
        EntityManager emf = new ConnectionFactory().getConnection();
        List<Bebida> Bebidas = null;
        try {
            Bebidas = emf.createQuery("from Bebida").getResultList();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
            System.err.println(e);
            }
            e.printStackTrace();
        } finally {
            if (emf != null && emf.isOpen()) {
                emf.close();
            }
        }
        return Bebidas;
    }
    
    public Bebida remove(Integer id){
        Bebida bebida = null ;
        try {
            bebida = em.find(Bebida.class, id);
            em.getTransaction().begin();
            em.remove(bebida);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();   
        }
        return bebida;
    } 
}
