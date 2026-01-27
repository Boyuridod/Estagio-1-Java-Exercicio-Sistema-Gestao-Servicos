package application;

import java.util.Scanner;

import controller.ServiceDAO;
import entities.Service;

public class UpdateServiceView {

	public static void menuUpdate(){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n\t**Update service**\n\n");
		
		System.out.print("Type the ID of the service to be updated: ");
		int id = scan.nextInt();
		
		Service s = ServiceDAO.getById(id);
		
		
		
		scan.close();
	}

}
