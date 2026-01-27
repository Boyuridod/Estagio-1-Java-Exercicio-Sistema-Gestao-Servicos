package entities;

import java.time.LocalDateTime;

import enums.ServicePriority;
import enums.ServiceStatus;
import enums.ServiceType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MAINTENANCE")
@SuppressWarnings("serial")
public class MaintenanceService extends Service {
	
	private String where;
	private String whatHappened;
	
	public MaintenanceService() {
		super();
	}

	public MaintenanceService(String description, LocalDateTime beginDate, LocalDateTime endDate,
			ServiceStatus status, ServicePriority priority, String where, String whatHappened) {
		super(description, ServiceType.MAINTENANCE, beginDate, endDate, status, priority);
		this.where = where;
		this.whatHappened = whatHappened;
	}

	@Column(name="where_happened")
	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}
	
	@Column(name="what_happened")
	public String getWhatHappened() {
		return whatHappened;
	}

	public void setWhatHappened(String whatHappened) {
		this.whatHappened = whatHappened;
	}
	
}
