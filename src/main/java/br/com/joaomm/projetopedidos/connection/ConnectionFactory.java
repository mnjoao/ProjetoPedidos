package br.com.joaomm.projetopedidos.connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * @author João Marcos
 */
public class ConnectionFactory {
    
   public EntityManager getConnection() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persisUnit");
        return emf.createEntityManager();
    }
    public static void closeEntityManagerFactory(EntityManagerFactory emf) {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }       
}
