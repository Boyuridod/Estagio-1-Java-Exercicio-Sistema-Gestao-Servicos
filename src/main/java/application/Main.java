package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.ServiceDAO;
import entities.Service;

public class Main {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao = 0;

		do {
			System.out.println("\t**Service management system**\n");

			System.out.println("1) New service");
			System.out.println("2) List services");
//			System.out.println("3) Update service");
			System.out.println("4) Delete service");
			System.out.println("0) Close application");

			System.out.print("\nType your option: ");
			opcao = scan.nextInt();
			
			scan.nextLine();

			switch (opcao) {
			case 0:
				System.out.println("\nYou choose to close the application");
				System.out.println("\nPress ENTER to continue...");
				scan.nextLine();
				break;
			case 1:
				Service s = ServiceDAO.newService();
				ServiceDAO.saveService(s);
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
					
					Service ret = ServiceDAO.getById(id);
					
					System.out.println("\n" + ret.toString());
					
					break;

				default:
					List<Service> services = new ArrayList<>();
					
					System.out.println();
					
					services = ServiceDAO.listService();

					System.out.println();
					
					for(Service ser: services) {
						System.out.println(ser.toString());
					}
					
					break;
				}
				
				System.out.println("\nPress ENTER to continue...");
				scan.nextLine();
				
				break;
			case 4:
				int type = 0;
				
				do {
					System.out.println("\n\t**Delete row on Database**\n");
					System.out.println("1) By ID");
					
					System.out.print("\nType your option: ");
					type = scan.nextInt();
				} while(type != 1 && type != 2);
				
				switch (type) {
				case 1:
					System.out.print("\nType the ID of the Service you want to delete: ");
					int id = scan.nextInt();
					
					ServiceDAO.deleteById(id);
					
					break;
				default:
					System.out.println("\nPlease, choose an valid option!");
					System.out.println("\nPress ENTER to continue...");
					break;
				}
				break;
			default:
				System.out.println("\nPlease, choose an valid option!");
				System.out.println("\nPress ENTER to continue...");
				scan.nextLine();
				break;
			}

		} while (opcao != 0);

		scan.close();
		ServiceDAO.closeConnection();
		
	}
	
}
