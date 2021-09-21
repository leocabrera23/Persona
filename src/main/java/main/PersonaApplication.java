package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import entities.Autor;
import entities.Domicilio;
import entities.Libro;
import entities.Localidad;
import entities.Persona;

public class PersonaApplication {
		public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaAppPU");
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			
			Autor autor = Autor.builder()
					.nombre("Lorem")
					.apellido("ipsum")
					.bigrafia("Lorem ipsum ")
					.build();
			
			Libro libro = Libro.builder()
					.fecha(0)
					.genero("sssssss")
					.paginas(24)
					.titulo("adipiscing elit")
					.build();
			
			Localidad localidad = Localidad.builder()
					.denominacion("consectetur")
					.build();
			
			Domicilio domicilio = Domicilio.builder()
					.calle("Alemanes")
					.numero(123)
					.localida(localidad)
					.build();
			
			Persona persona = Persona.builder()
					.apellido("Cabrera")
					.nombre("Leonardo")
					.dni(42793451)
					.domicilio(domicilio)
					.build();
			
			libro.getAutores().add(autor);
			persona.getLibros().add(libro);
			
			em.flush();
			em.getTransaction().commit();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			JOptionPane.showConfirmDialog(null, e);
		}
		em.close();
		emf.close();
	}
}
