package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
	
	public PetsDetails searchForListById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		PetsDetails found = em.find(PetsDetails.class, tempId);
		em.close();
		return found;
	}

	public void deleteItem(PetsDetails listToDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PetsDetails> typedQuery = em.createQuery("select d from PetsDetails d where d.id = :selectedid",PetsDetails.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedid", listToDelete.getId());
		

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list detail object
		PetsDetails result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}

	public void updateList(PetsDetails toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
