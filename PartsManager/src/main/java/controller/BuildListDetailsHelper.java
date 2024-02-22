package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.BuildList;
import model.BuildListDetails;

/**
 * @author Jeff Johnson - jjohnson190
 * CIS175 - Spring 2024
 * Feb 16, 2024
 */


public class BuildListDetailsHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PartsManager");
	
	public void insertNewBuildListDetails(BuildListDetails blDeets) {
		
		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(blDeets);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<BuildListDetails> getListDetails(){
		
		EntityManager manager = emfactory.createEntityManager();
		
		List<BuildListDetails> allBuildListDetails = manager.createQuery("SELECT bld FROM BuildListDetails bld").getResultList();
		
		return allBuildListDetails;
		
	}

	public void deleteList(BuildListDetails listToDelete) {
		
		EntityManager manager = emfactory.createEntityManager();
		
		manager.getTransaction().begin();
		TypedQuery<BuildListDetails> bldhTypedQuery = manager.createQuery("SELECT d FROM BuildListDetails d WHERE d.listId = :selectedId", BuildListDetails.class);
		
		bldhTypedQuery.setParameter("selectedId", listToDelete.getListId());
		bldhTypedQuery.setMaxResults(1);
		BuildListDetails queryResult = bldhTypedQuery.getSingleResult();
		
		manager.remove(queryResult);
		manager.getTransaction().commit();
		manager.close();
		
		
	}

	public BuildListDetails searchForBuildListDetailsByID(Integer tempID) {
		
		EntityManager manager = emfactory.createEntityManager();		
		manager.getTransaction().begin();
		
		BuildListDetails bldFound = manager.find(BuildListDetails.class, tempID);
		
		manager.close();
		
		return bldFound;
	}

	public void updateList(BuildListDetails toUpdate) {
		
		EntityManager manager = emfactory.createEntityManager();	
		manager.getTransaction().begin();
		manager.merge(toUpdate);
		manager.getTransaction().commit();
		manager.close();
		
	}
	
}
