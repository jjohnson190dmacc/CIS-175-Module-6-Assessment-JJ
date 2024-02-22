package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.BuildList;
import model.ComputerPart;

/**
 * @author Jeff Johnson - jjohnson190
 * CIS175 - Spring 2024
 * Feb 16, 2024
 */


public class BuildListHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PartsManager");
	
	public void insertBuildList(BuildList buildList) {
		
		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(buildList);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<BuildList> showAllLists(){
		
		EntityManager manager = emfactory.createEntityManager();
		
		List<BuildList> allBuildLists = manager.createQuery("SELECT bl FROM BuildList bl").getResultList();
		
		return allBuildLists;
		
	}


	public BuildList findBuildList(String nameToFind) {
		
		EntityManager manager = emfactory.createEntityManager();
		manager.getTransaction().begin();
		
		TypedQuery<BuildList> blhTypedQuery = manager.createQuery("SELECT b FROM BuildList b WHERE b.buildName = :selectedName", BuildList.class);
		blhTypedQuery.setParameter("selectedName", nameToFind);
		blhTypedQuery.setMaxResults(1);
		
		BuildList foundList;
		try {
			
			foundList = blhTypedQuery.getSingleResult();
			
		} catch (NoResultException ex) {
			
			foundList = new BuildList(nameToFind);
			
		}
		
		manager.close();
		
		return foundList;
	}
	
}
