package entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import enums.ServicePriority;
import enums.ServiceStatus;
import enums.ServiceType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "services")
public abstract class Service implements Serializable {
	private Integer id;
	private String description;
	private ServiceType type;
	private LocalDateTime beginDate;
	private LocalDateTime endDate;
	private ServiceStatus status;
	private ServicePriority priority;
	
	public Service() {
		
	}

	public Service(String description, ServiceType type, String beginDate,
			String endDate, ServiceStatus status,
			ServicePriority priority) {
		this.description = description;
		this.type = type;
		this.beginDate = LocalDateTime.parse(beginDate, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		this.endDate = LocalDateTime.parse(endDate, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		this.status = status;
		this.priority = priority;
	}

	@Id
    @GeneratedValue
    @Column(name="id")
	public int getId() {
		return id;
	}

	@Column(name="descrip")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Enumerated(EnumType.STRING)
    @Column(name="tipo")
	public ServiceType getType() {
		return type;
	}

	public void setType(ServiceType type) {
		this.type = type;
	}

	@Column(name="begin_date")
	public LocalDateTime getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(LocalDateTime beginDate) {
		this.beginDate = beginDate;
	}

	@Column(name="end_date")
	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="stats")
	public ServiceStatus getStatus() {
		return status;
	}

	public void setStatus(ServiceStatus status) {
		this.status = status;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="priority")
	public ServicePriority getPriority() {
		return priority;
	}

	public void setPriority(ServicePriority priority) {
		this.priority = priority;
	}
	public abstract double calculatePrice();
}
