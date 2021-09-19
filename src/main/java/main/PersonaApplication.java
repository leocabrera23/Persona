package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jboss.jandex.Main;

public class PersonaApplication {
		public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaAppPU");
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();
	}
}
