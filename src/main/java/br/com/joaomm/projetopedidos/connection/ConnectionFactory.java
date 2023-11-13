
package br.com.joaomm.projetopedidos.connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author João Marcos
 */
public class ConnectionFactory {
    
   private static EntityManagerFactory emf =Persistence.createEntityManagerFactory("persisUnit");
   
   public EntityManager getConnection(){
       return emf.createEntityManager();
   }
    public static void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }       
}
