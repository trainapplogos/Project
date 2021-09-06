package ua.com.acomahmanager.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MonthlyTariff {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String utility;
	
	@Column
	private Integer utilityId;
	
	@Column
	private Double tariff;
	
//	private Month month;
//	private Integer year;
	
	@Column
	private Date fromDate;
	
	@Column(nullable = true)
	private String description;
	
	public MonthlyTariff() {}

	public MonthlyTariff(String utility, Integer utilityId, Double tariff, Date fromDate, String description) {
		super();
		this.utility = utility;
		this.utilityId = utilityId;
		this.tariff = tariff;
		this.fromDate = fromDate;
		this.description = description;
	}

	public MonthlyTariff(Long id, String utility, Integer utilityId, Double tariff, Date fromDate, String description) {
		super();
		this.id = id;
		this.utility = utility;
		this.utilityId = utilityId;
		this.tariff = tariff;
		this.fromDate = fromDate;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUtility() {
		return utility;
	}

	public void setUtility(String utility) {
		this.utility = utility;
	}

	public Integer getUtilityId() {
		return utilityId;
	}

	public void setUtilityId(Integer utilityId) {
		this.utilityId = utilityId;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	
	public Double getTariff() {
		return tariff;
	}

	public void setTariff(Double tariff) {
		this.tariff = tariff;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((fromDate == null) ? 0 : fromDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tariff == null) ? 0 : tariff.hashCode());
		result = prime * result + ((utility == null) ? 0 : utility.hashCode());
		result = prime * result + ((utilityId == null) ? 0 : utilityId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonthlyTariff other = (MonthlyTariff) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (fromDate == null) {
			if (other.fromDate != null)
				return false;
		} else if (!fromDate.equals(other.fromDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tariff == null) {
			if (other.tariff != null)
				return false;
		} else if (!tariff.equals(other.tariff))
			return false;
		if (utility == null) {
			if (other.utility != null)
				return false;
		} else if (!utility.equals(other.utility))
			return false;
		if (utilityId == null) {
			if (other.utilityId != null)
				return false;
		} else if (!utilityId.equals(other.utilityId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MonthlyTariff [id=" + id + ", utility=" + utility + ", utilityId=" + utilityId + ", tariff=" + tariff
				+ ", fromDate=" + fromDate + ", description=" + description + "]";
	}

}
