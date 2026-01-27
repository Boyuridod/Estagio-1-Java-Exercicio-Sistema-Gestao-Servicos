package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import controller.ServiceDAO;
import entities.DevelopmentService;
import entities.Service;
import enums.ServicePriority;
import enums.ServiceStatus;

public class test {

	public static void main(String[] args) {
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		System.out.println(ServiceDAO.getById(1).toString());
		
		Service s = new DevelopmentService("Aconteceu o q eu temia",
				LocalDateTime.parse("22/05/2222 15:12:12", fmt),
				LocalDateTime.parse("22/05/2222 15:12:12", fmt),
				ServiceStatus.CANCELED, ServicePriority.VERY_LOW, "C#");
		
		s.setId(1);
		
		ServiceDAO.updateService(s);
		
		System.out.println(ServiceDAO.getById(1).toString());
		
	}

}
