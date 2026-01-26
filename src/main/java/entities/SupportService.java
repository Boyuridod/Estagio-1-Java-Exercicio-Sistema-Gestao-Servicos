package entities;

import java.time.LocalDateTime;

import enums.ServicePriority;
import enums.ServiceStatus;
import enums.ServiceType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "services")
public class SupportService extends Service {

	private String whoNeeded;
	private String howWasSolved;
	
	public SupportService() {
		super();
	}

	public SupportService(Integer id, String description, LocalDateTime beginDate, LocalDateTime endDate,
			ServiceStatus status, ServicePriority priority, String whoneeded, String howWasSolved) {
		super(id, description, ServiceType.SUPPORT, beginDate, endDate, status, priority);
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

	@Override
	public String toString() {
		return "SupportService [getId()=" + getId() + ", getDescription()=" + getDescription() + ", getType()="
				+ getType() + ", getBeginDate()=" + getBeginDate() + ", getEndDate()=" + getEndDate() + ", getStatus()="
				+ getStatus() + ", getPriority()=" + getPriority() + ", whoNeeded=" + whoNeeded + ", howWasSolved="
				+ howWasSolved + "]";
	}

	@Override
	public double calculatePrice() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
