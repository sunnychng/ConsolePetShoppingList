package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.PetsSitter;

public class PetsSitterHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsolePetShoppingList");
	
	public void insertPetsSitter(PetsSitter p) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<PetsSitter> showAllPetsSitter(){
		EntityManager em = emfactory.createEntityManager();
		List<PetsSitter> allPetsSitter = em.createQuery("SELECT p FROM PetsSitter p").getResultList();
		return allPetsSitter;
	}
}
