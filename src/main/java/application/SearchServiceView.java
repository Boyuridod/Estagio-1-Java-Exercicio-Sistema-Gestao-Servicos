package application;

import java.util.ArrayList;
import java.util.List;

import controller.ServiceDAO;
import entities.Service;

public class SearchServiceView {
	
	public static void menuSearchService() {
		
		int search = 0;
		
		do {
			System.out.println("\n\t**Search on Database**\n");
			System.out.println("1) By ID");
			System.out.println("2) Return all");
			
			System.out.print("\nType your option: ");
			search = Main.scan.nextInt();
		} while(search != 1 && search != 2);
		
		Main.scan.nextLine();
		
		switch (search) {
		case 1:
			System.out.print("\nType the ID you want to search: ");
			int id = Main.scan.nextInt();
			Main.scan.nextLine();
			
			Service ret = ServiceDAO.getById(id);
			
			System.out.println("\n" + ret.toString());
			
			break;

		default:
			List<Service> services = new ArrayList<>();
			
			System.out.println();
			
			services = ServiceDAO.listServices();

			System.out.println();
			
			for(Service ser: services) {
				System.out.println(ser.toString());
			}
			
			break;
		}
		
		System.out.println("\nPress ENTER to continue...");
		Main.scan.nextLine();
		
	}
	
}
