package entities;

import enums.ServicePriority;
import enums.ServiceStatus;
import enums.ServiceType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DEVELOPMENT")
public class DevelopmentService extends Service{
	
	private String language;
	
	public DevelopmentService() {
		super();
	}
	
	public DevelopmentService(String description, String beginDate,
			String endDate, ServiceStatus status, ServicePriority priority, String language) {
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

	@Override
	public String toString() {
		return "DevelopmentService [getId()=" + getId() + ", getDescription()=" + getDescription() + ", getType()="
				+ getType() + ", getBeginDate()=" + getBeginDate() + ", getEndDate()=" + getEndDate() + ", getStatus()="
				+ getStatus() + ", getPriority()=" + getPriority() + ", language=" + language + "]";
	}

	@Override
	public double calculatePrice() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
