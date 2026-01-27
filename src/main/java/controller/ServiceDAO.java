package controller;

import java.util.ArrayList;

import entities.Service;
import jakarta.persistence.EntityManager;
import persistence.JPAUtil;

public class ServiceDAO {
	private static final EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public static void createService(Service s) {
		
		try {
			em.getTransaction().begin();
			em.persist(s);
			em.getTransaction().commit();
		}
		catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		
	}
	
	public static Service getById(int id) {
		return em.find(Service.class, id);
	}

	public static ArrayList<Service> listServices() {
		return new ArrayList<>(em.createQuery("FROM Service", Service.class)
                .getResultList());
	}
	
	public static void deleteById(int id) {
		
		try {
			em.getTransaction().begin();
			em.remove(getById(id));
			em.getTransaction().commit();			
		}
		catch(Exception e){
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		
		
	}
	
	public static void updateService(int id, Service s) {
		
		try {
			s.setId(1);
			em.getTransaction().begin();
			em.merge(s);
			em.getTransaction().commit();			
		}
		catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		
	}
	
	public static void closeConnection() {
		em.close();
	}
}
