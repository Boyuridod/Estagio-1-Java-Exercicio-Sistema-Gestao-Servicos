package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import entities.DevelopmentService;
import entities.MaintenanceService;
import entities.Service;
import entities.SupportService;
import enums.ServicePriority;
import enums.ServiceStatus;
import jakarta.persistence.EntityManager;
import persistence.JPAUtil;

public class ServiceDAO {
	private static final EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
	private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	public static Service newService() {
		
		Scanner scan = new Scanner(System.in);

		int type = 0, aux = 0;
		Service s = null;

		System.out.println("\n\t**New service**\n");

		do {
			System.out.println("Project type");
			System.out.println("\t1 - Development");
			System.out.println("\t2 - Maintenance");
			System.out.println("\t3 - Support");

			System.out.print("Type here: ");
			type = scan.nextInt();
		} while (type != 1 && type != 2 && type != 3);
		
		scan.nextLine();

		System.out.print("\nDescription: ");
		String description = scan.nextLine();

		System.out.print("Begin date (dd/MM/yyyy HH:mm:ss): ");
		LocalDateTime beginDate = (LocalDateTime.parse(scan.nextLine(), fmt));

		System.out.print("End date (dd/MM/yyyy HH:mm:ss): ");
		LocalDateTime endDate = (LocalDateTime.parse(scan.nextLine(), fmt));

		do {
			System.out.println("\nStatus");
			System.out.println("\t1 - Pending");
			System.out.println("\t2 - Canceled");
			System.out.println("\t3 - In progress");
			System.out.println("\t4 - Finished");

			System.out.print("Status: ");
			aux = scan.nextInt();
		} while (aux != 1 && aux != 2 && aux != 3 && aux != 4);
		
		scan.nextLine();

		ServiceStatus status = null;

		switch (aux) {
		case 1:
			status = ServiceStatus.PENDING;
			break;
		case 2:
			status = ServiceStatus.CANCELED;
			break;
		case 3:
			status = ServiceStatus.IN_PROGRESS;
			break;
		default:
			status = ServiceStatus.FINISHED;
			break;
		}

		do {
			System.out.println("\nStatus");
			System.out.println("\t1 - Very low");
			System.out.println("\t2 - Low");
			System.out.println("\t3 - Medium");
			System.out.println("\t4 - High");
			System.out.println("\t5 - Very high");

			System.out.print("Status: ");
			aux = scan.nextInt();
		} while (aux != 1 && aux != 2 && aux != 3 && aux != 4 && aux != 5);

		ServicePriority priority = null;
		
		scan.nextLine();

		switch (aux) {
		case 1:
			priority = ServicePriority.VERY_LOW;
			break;
		case 2:
			priority = ServicePriority.LOW;
			break;
		case 3:
			priority = ServicePriority.MEDIUM;
			break;
		case 4:
			priority = ServicePriority.HIGH;
			break;
		default:
			priority = ServicePriority.VERY_HIGH;
			break;
		}

		switch (type) {
		case 1:
			System.out.print("Type the used language: ");
			String lang = scan.nextLine();
			s = new DevelopmentService(description, beginDate, endDate, status, priority, lang);
			break;
		case 2:
			System.out.print("Type here where the maintenance happened: ");
		    String where = scan.nextLine();

		    System.out.print("Type here what happened: ");
		    String whatHappened = scan.nextLine();
		    
			s = new MaintenanceService(description, beginDate, endDate, status, priority, where, whatHappened);
			break;
		default:
			System.out.print("Type here who needed support: ");
		    String whoNeeded = scan.nextLine();

		    System.out.print("Type here how it was solved: ");
		    String howWasSolved = scan.nextLine();
		    
			s = new SupportService(description, beginDate, endDate, status, priority, whoNeeded, howWasSolved);
			break;
		}

		return s;
	}
	
	public static Service getById(int id) {
		return em.find(Service.class, id);
	}

	public static ArrayList<Service> listService() {
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
	
	public static void saveService(Service s) {
		
		try {
			em.getTransaction().begin();
			em.persist(s);
			em.getTransaction().commit();
		}
		catch(Exception e){
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		
	}
	
	public static void closeConnection() {
		em.close();
	}
}
