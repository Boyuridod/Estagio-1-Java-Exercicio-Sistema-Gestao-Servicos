package entities;

import java.time.LocalDateTime;

import enums.ServicePriority;
import enums.ServiceStatus;
import enums.ServiceType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SUPPORT")
@SuppressWarnings("serial")
public class SupportService extends Service {

	private String whoNeeded;
	private String howWasSolved;
	
	public SupportService() {
		super();
	}

	public SupportService(String description, LocalDateTime beginDate, LocalDateTime endDate,
			ServiceStatus status, ServicePriority priority, String whoneeded, String howWasSolved) {
		super(description, ServiceType.SUPPORT, beginDate, endDate, status, priority);
		this.whoNeeded = whoneeded;
		this.howWasSolved = howWasSolved;
	}

	@Column(name="who_needed")
	public String getWhoNeeded() {
		return whoNeeded;
	}

	public void setWhoNeeded(String whoNeeded) {
		this.whoNeeded = whoNeeded;
	}

	@Column(name="how_solved")
	public String getHowWasSolved() {
		return howWasSolved;
	}

	public void setHowWasSolved(String howWasSolved) {
		this.howWasSolved = howWasSolved;
	}
	
}
