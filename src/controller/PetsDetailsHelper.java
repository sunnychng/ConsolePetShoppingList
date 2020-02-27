package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.PetsDetails;

public class PetsDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsolePetShoppingList");
	
	public void insertNewPetsDetails(PetsDetails p) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<PetsDetails> getPets(){
		EntityManager em = emfactory.createEntityManager();
		List<PetsDetails> allDetails = em.createQuery("SELECT p FROM PetsDetails p").getResultList();
		return allDetails;
	}
}
