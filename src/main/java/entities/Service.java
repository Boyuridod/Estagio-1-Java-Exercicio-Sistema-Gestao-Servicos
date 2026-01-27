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
import jakarta.persistence.Table;

@Entity
@Table(name = "services")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "service_type")
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

	public Service(String description, ServiceType type, LocalDateTime beginDate,
			LocalDateTime endDate, ServiceStatus status,
			ServicePriority priority) {
		this.description = description;
		this.type = type;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.status = status;
		this.priority = priority;
	}

	@Id
    @GeneratedValue
    @Column(name="id")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
	    this.id = id;
	}

	@Column(name="descrip")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	@Enumerated(EnumType.STRING)
//    @Column(name="type_of")
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
