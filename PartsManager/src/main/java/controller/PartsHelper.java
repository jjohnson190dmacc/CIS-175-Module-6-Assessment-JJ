package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.ComputerPart;

/**
 * @author Jeff Johnson - jjohnson190
 * CIS175 - Spring 2024
 * Feb 9, 2024
 */

public class PartsHelper {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PartsManager");
	
	public void insertItem(ComputerPart compPart) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(compPart);
		em.getTransaction().commit();
		em.close();
	}
	
	public void delete(ComputerPart compPart) {
		
		EntityManager manager = emfactory.createEntityManager();
		manager.getTransaction().begin();
		manager.remove(manager.find(ComputerPart.class, compPart.getPartID()));
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void update(ComputerPart compPart) {
		
		EntityManager manager = emfactory.createEntityManager();
		ComputerPart dbEntity = manager.find(ComputerPart.class, compPart.getPartID());
		manager.getTransaction().begin();
		dbEntity.setManufacturerName(compPart.getManufacturerName());
		dbEntity.setProductType(compPart.getProductType());
		dbEntity.setProductName(compPart.getProductName());
		manager.getTransaction().commit();
		manager.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<ComputerPart> showAllParts(){
		
		EntityManager manager = emfactory.createEntityManager();
		List<ComputerPart> allParts = manager.createQuery("SELECT i FROM ComputerPart i").getResultList();
		manager.close();
		return allParts;
	}


	public ComputerPart searchForItemByID(Integer tempID) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ComputerPart foundPart = em.find(ComputerPart.class, tempID);
		em.close();
		return foundPart;
		
	}
	
}
