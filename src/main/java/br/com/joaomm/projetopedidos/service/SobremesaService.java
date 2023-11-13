
package br.com.joaomm.projetopedidos.service;

import br.com.joaomm.projetopedidos.connection.ConnectionFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import br.com.joaomm.projetopedidos.modelo.Sobremesa;
/**
 * @author João Marcos
 */
public class SobremesaService {
    
    
    EntityManager em = new ConnectionFactory().getConnection();
    EntityTransaction transaction = em.getTransaction();
        
    //metodo para criar e salvar 
    public void save(Sobremesa sobremesa) {
        try {
            transaction.begin();
            em.persist(sobremesa);
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
    public void update(Sobremesa sobremesa) {
        try {
            transaction.begin();
            // Verifica se a Categoria já existe no banco de dados com o mesmo id
            Sobremesa existingCategoria = em.find(Sobremesa.class, sobremesa.getIdSobremesa());
            // Se já existe, realiza a atualização
            if (existingCategoria != null) {
                em.merge(sobremesa);
                }
                else{ // Lógica para lidar com a ausência de um id válido
                    System.out.println("**********************************");
                    throw new IllegalArgumentException("Não foi possivel alterar Sobremesa"
                    + " do id " + sobremesa.getIdSobremesa() + " pois não existe no banco de dados."); 
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
     
    public Sobremesa findId(Integer id){
        Sobremesa sobremesa = null ; 
        try {
            sobremesa = em.find(Sobremesa.class, id);
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
            return sobremesa;
    } 
     
    public List<Sobremesa> findAll(){
        EntityManager emf = new ConnectionFactory().getConnection();
        List<Sobremesa> Sobremesas = null;
        try {
            Sobremesas = emf.createQuery("from Sobremesa").getResultList();
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
        return Sobremesas;
    }
    
    public Sobremesa remove(Integer id){
        Sobremesa sobremesa = null ;
        try {
            sobremesa = em.find(Sobremesa.class, id);
            em.getTransaction().begin();
            em.remove(sobremesa);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();   
        }
        return sobremesa;
    } 
}
