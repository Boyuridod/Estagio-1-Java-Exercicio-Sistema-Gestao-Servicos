package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.DevelopmentService;
import entities.MaintenanceService;
import entities.Service;
import entities.SupportService;
import enums.ServicePriority;
import enums.ServiceStatus;
import jakarta.persistence.EntityManager;
import persistence.JPAUtil;

public class Main {

	private static EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
	private static Scanner scan = new Scanner(System.in);
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public static void main(String[] args) {

		int opcao = 0;

		do {
			System.out.println("\t**Service management system**\n");

			System.out.println("1) New service");
			System.out.println("2) List services");
			System.out.println("3) Update service");
			System.out.println("4) Delete service");
			System.out.println("0) Close application");

			System.out.print("\nType your option: ");
			opcao = scan.nextInt();
			
			scan.nextLine();

			switch (opcao) {
			case 1:
				Service s = newService();
				saveService(s);
				break;
				
			case 2:
				int tipo = 0;
				
				do {
					System.out.println("\n\t**Search on Database**\n");
					System.out.println("1) By ID");
					System.out.println("2) Return all");
					
					System.out.print("\nType your option: ");
					tipo = scan.nextInt();
				} while(tipo != 1 && tipo != 2);
				
				scan.nextLine();
				
				switch (tipo) {
				case 1:
					System.out.print("\nType the ID you want to search: ");
					int id = scan.nextInt();
					scan.nextLine();
					
					Service ret = getServiceById(id);
					
					System.out.println("\n" + ret.toString());
					
					break;

				default:
					List<Service> services = new ArrayList<>();
					
					services = listService();
					
					for(Service ser: services) {
						System.out.println(ser.toString());
					}
					
					break;
				}
				
				System.out.println("\nPress ENTER to continue...");
				scan.nextLine();
				
				break;

			default:
				System.out.println("\nYou choose to close the application");
				break;
			}

		} while (opcao != 0);

		scan.close();
		em.close();
		
	}

	public static Service newService() {

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
	
	public static Service getServiceById(int id) {
		return em.find(Service.class, id);
	}

	public static ArrayList<Service> listService() {
		return new ArrayList<>(em.createQuery("FROM Service", Service.class)
                .getResultList());
	}
	
	public static void saveService(Service s) {

		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		
	}
}
