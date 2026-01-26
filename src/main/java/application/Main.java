package application;

import entities.DevelopmentService;
import entities.Service;
import enums.ServicePriority;
import enums.ServiceStatus;
import jakarta.persistence.EntityManager;
import persistence.JPAUtil;

public class Main {
	public static void main(String[] args) {
		
		Service service1 = new DevelopmentService("Desenvolver este aplicativo",
				"20/01/2026 10:00:00", "22/01/2026 18:00:00",
				ServiceStatus.FINISHED, ServicePriority.VERY_HIGH, "Java");
		
		System.out.println(service1.getBeginDate());
		
		EntityManager em = JPAUtil
                .getEntityManagerFactory()
                .createEntityManager();
		
		em.getTransaction().begin();
		em.persist(service1);
		em.getTransaction().commit();
		
		
		em.close();
	}

}
