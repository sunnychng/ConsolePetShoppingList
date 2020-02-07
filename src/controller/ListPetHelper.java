package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListPet;

public class ListPetHelper {
	
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsolePetShoppingList");
	
	public void insertItem(ListPet li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListPet> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<ListPet> allItems = em.createQuery("SELECT i FROM ListPet i").getResultList();
		return	allItems;
		}
	
	public void deleteItem(ListPet toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListPet> typedQuery	= em.createQuery("select li from ListPet li where li.type = :selectedType and li.name = :selectedName and li.owner = :selectedOwner", ListPet.class);

		//Substitute parameter with actual data	from the toDelete item
		typedQuery.setParameter("selectedType", toDelete.getType());
		typedQuery.setParameter("selectedName",	toDelete.getName());
		typedQuery.setParameter("selectedOwner", toDelete.getOwner());

		//we only want one result
		typedQuery.setMaxResults(1);

		//get the result and save it into a new	list item
		ListPet result	= typedQuery.getSingleResult();

		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();

		}

	public ListPet searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListPet found = em.find(ListPet.class, idToEdit);
		em.close();
		return	found;
	}

	public void updateItem(ListPet toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListPet> searchForPetByType(String typeName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListPet> typedQuery	= em.createQuery("SELECT li	FROM ListPet li WHERE li.type = :selectedType", ListPet.class);
		typedQuery.setParameter("selectedType", typeName);
		List<ListPet> foundType = typedQuery.getResultList();
		em.close();
		return	foundType;
	}

	public List<ListPet> searchForPetByName(String petName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListPet> typedQuery	= em.createQuery("SELECT li	FROM ListPet li WHERE li.name = :selectedName",	ListPet.class);
		typedQuery.setParameter("selectedName",	petName);
		List<ListPet> foundPetName = typedQuery.getResultList();
		em.close();
		return	foundPetName;
	}
	
	public List<ListPet> searchForPetByOwner(String ownerName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListPet> typedQuery	= em.createQuery("SELECT li	FROM ListPet li WHERE li.owner = :selectedOwner", ListPet.class);
		typedQuery.setParameter("selectedOwner",	ownerName);
		List<ListPet> foundOwner = typedQuery.getResultList();
		em.close();
		return	foundOwner;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
	
}
