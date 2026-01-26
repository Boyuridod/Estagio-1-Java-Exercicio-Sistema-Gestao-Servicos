package entities;

import enums.ServicePriority;
import enums.ServiceStatus;
import enums.ServiceType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SUPPORT")
public class SupportService extends Service {

	private String whoNeeded;
	private String howWasSolved;
	
	public SupportService() {
		super();
	}

	public SupportService(String description, String beginDate, String endDate,
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
