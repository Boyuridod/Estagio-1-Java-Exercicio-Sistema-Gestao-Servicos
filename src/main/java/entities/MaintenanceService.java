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

	@Override
	public String toString() {
		return "MaintenanceService [getId()=" + getId()
				+ ", getDescription()=" + getDescription() + ", getType()=" + getType() + ", getBeginDate()="
				+ getBeginDate() + ", getEndDate()=" + getEndDate() + ", getStatus()=" + getStatus()
				+ ", getPriority()=" + getPriority() + "where=" + where + ", whatHappened=" + whatHappened + "]";
	}

	@Override
	public double calculatePrice() {
		// TODO Auto-generated method stub
		return 0;
	}

}
