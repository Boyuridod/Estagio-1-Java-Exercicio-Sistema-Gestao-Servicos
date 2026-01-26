package persistence;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
	private static final EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("Estagio-1-Java-Exercicio-Sistema-Gestao-Servicos");

	public static EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
}
