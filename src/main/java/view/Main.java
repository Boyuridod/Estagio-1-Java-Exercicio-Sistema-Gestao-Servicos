package view;

import java.util.Scanner;

import DAO.ServiceDAO;

public class Main {

	public static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao = 0;

		do {
			System.out.println("\t**Service management system**\n");

			System.out.println("1) New service");
			System.out.println("2) Search services");
			System.out.println("3) Update service");
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
				NewServiceView.menuNewService();
				break;	
			case 2:
				SearchServiceView.menuSearchService();				
				break;
			case 3:
				UpdateServiceView.menuUpdate();
				break;
			case 4:
				DeleteServiceView.menuDeleteService();
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
