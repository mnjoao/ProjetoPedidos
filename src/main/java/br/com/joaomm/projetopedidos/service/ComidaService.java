package br.com.joaomm.projetopedidos.service;

import br.com.joaomm.projetopedidos.connection.ConnectionFactory;
import br.com.joaomm.projetopedidos.modelo.Comida;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

/**
 * @author João Marcos
 */
public class ComidaService { 
    //metodo para criar e salvar 
    public static void save(Comida comida) {
    EntityManager em = new ConnectionFactory().getConnection();
    EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(comida);
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
    public void update(Comida comida) {
        EntityManager em = new ConnectionFactory().getConnection();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            // Verifica se a Categoria já existe no banco de dados com o mesmo id
            Comida existingCategoria = em.find(Comida.class, comida.getIdComida());
            // Se já existe, realiza a atualização
            if (existingCategoria != null) {
                em.merge(comida);
                }
                else{ // Lógica para lidar com a ausência de um id válido
                    System.out.println("**********************************");
                    throw new IllegalArgumentException("Não foi possivel alterar Comida"
                    + " do id " + comida.getIdComida() + " pois não existe no banco de dados."); 
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
     
    public static Comida findId(Integer id){
        Comida comida = null ; 
        EntityManager em = new ConnectionFactory().getConnection();
        EntityTransaction transaction = em.getTransaction();
        try {
            comida = em.find(Comida.class, id);
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
            return comida;
    } 
     
    public List<Comida> findAll(){
        EntityManager em = new ConnectionFactory().getConnection();
        EntityTransaction transaction = em.getTransaction();
        EntityManager emf = new ConnectionFactory().getConnection();
        List<Comida> Comidas = null;
        try {
            Comidas = emf.createQuery("from Comida").getResultList();
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
        return Comidas;
    }
    
    public Comida remove(Integer id){
        EntityManager em = new ConnectionFactory().getConnection();
        EntityTransaction transaction = em.getTransaction();
        Comida comida = null ;
        try {
            comida = em.find(Comida.class, id);
            em.getTransaction().begin();
            em.remove(comida);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();   
        }
        return comida;
    } 
}
