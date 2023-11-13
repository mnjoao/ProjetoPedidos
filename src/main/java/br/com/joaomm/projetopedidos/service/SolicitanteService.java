
package br.com.joaomm.projetopedidos.service;

import br.com.joaomm.projetopedidos.connection.ConnectionFactory;
import br.com.joaomm.projetopedidos.modelo.Solicitante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

/**
 * @author João Marcos
 */
public class SolicitanteService {
    
    EntityManager em = new ConnectionFactory().getConnection();
    EntityTransaction transaction = em.getTransaction();
        
    //metodo para criar e salvar 
    public void save(Solicitante solicitante) {
        try {
            transaction.begin();
            em.persist(solicitante);
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
    public void update(Solicitante solicitante) {
        try {
            transaction.begin();
            // Verifica se a Categoria já existe no banco de dados com o mesmo id
            Solicitante existingCategoria = em.find(Solicitante.class, solicitante.getIdSolicitante());
            // Se já existe, realiza a atualização
            if (existingCategoria != null) {
                em.merge(solicitante);
                }
                else{ // Lógica para lidar com a ausência de um id válido
                    System.out.println("**********************************");
                    throw new IllegalArgumentException("Não foi possivel alterar solicitante"
                    + " do id " + solicitante.getIdSolicitante() + " pois não existe no banco de dados."); 
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
     
    public Solicitante findId(Integer id){
        Solicitante solicitante = null ; 
        try {
            solicitante = em.find(Solicitante.class, id);
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
            return solicitante;
    } 
     
    public List<Solicitante> findAll(){
        EntityManager emf = new ConnectionFactory().getConnection();
        List<Solicitante> solicitantes = null;
        try {
            solicitantes = emf.createQuery("from Solicitante").getResultList();
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
        return solicitantes;
    }
    
    public Solicitante remove(Integer id){
        Solicitante solicitante = null ;
        try {
            solicitante = em.find(Solicitante.class, id);
            em.getTransaction().begin();
            em.remove(solicitante);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();   
        }
        return solicitante;
    }
}
