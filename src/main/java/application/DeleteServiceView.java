package application;

import controller.ServiceDAO;

public class DeleteServiceView {

	public static void menuDeleteService() {
		
		int type = 0;
		
		do {
			System.out.println("\n\t**Delete row on Database**\n");
			System.out.println("1) By ID");
			
			System.out.print("\nType your option: ");
			type = Main.scan.nextInt();
		} while(type != 1 && type != 2);
		
		switch (type) {
		case 1:
			System.out.print("\nType the ID of the Service you want to delete: ");
			int id = Main.scan.nextInt();
			
			ServiceDAO.deleteById(id);
			
			break;
		default:
			System.out.println("\nPlease, choose an valid option!");
			System.out.println("\nPress ENTER to continue...");
			break;
		}
		
	}
	
}
