package model.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import model.enums.ServicePriority;
import model.enums.ServiceStatus;
import model.enums.ServiceType;

@Entity
@DiscriminatorValue("DEVELOPMENT")
@SuppressWarnings("serial")
public class DevelopmentService extends Service{
	
	private String language;
	
	public DevelopmentService() {
		super();
	}
	
	public DevelopmentService(String description, LocalDateTime beginDate,
			LocalDateTime endDate, ServiceStatus status, ServicePriority priority, String language) {
		super(description, ServiceType.DEVELOPMENT, beginDate, endDate, status, priority);
		this.language = language;
	}

	@Column(name="lang")
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
}
