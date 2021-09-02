package ua.com.acomahmanager.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bills")
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private Long utilityId;
	
	@Column
	private Double value;
	
	@Column
	private Long tariffId; //id of monthly tariff for utility
	
	@Column
	private Double summary;
	
	@Column
	private Long userId;
	
	@Column
	private Date promPeriod;
	
	@Column
	private Date toPeriod;
	
	@Column(nullable = true)
	private String comment;
	
	public Bill() {	}

	public Bill(Long utilityId, Double value, Long tariffId, Double summary, Long userId, Date promPeriod,
			Date toPeriod, String comment) {
		super();
		this.utilityId = utilityId;
		this.value = value;
		this.tariffId = tariffId;
		this.summary = summary;
		this.userId = userId;
		this.promPeriod = promPeriod;
		this.toPeriod = toPeriod;
		this.comment = comment;
	}

	public Bill(Long id, Long utilityId, Double value, Long tariffId, Double summary, Long userId, Date promPeriod,
			Date toPeriod, String comment) {
		super();
		this.id = id;
		this.utilityId = utilityId;
		this.value = value;
		this.tariffId = tariffId;
		this.summary = summary;
		this.userId = userId;
		this.promPeriod = promPeriod;
		this.toPeriod = toPeriod;
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUtilityId() {
		return utilityId;
	}

	public void setUtilityId(Long utilityId) {
		this.utilityId = utilityId;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Long getTariffId() {
		return tariffId;
	}

	public void setTariffId(Long tariffId) {
		this.tariffId = tariffId;
	}

	public Double getSummary() {
		return summary;
	}

	public void setSummary(Double summary) {
		this.summary = summary;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getPromPeriod() {
		return promPeriod;
	}

	public void setPromPeriod(Date promPeriod) {
		this.promPeriod = promPeriod;
	}

	public Date getToPeriod() {
		return toPeriod;
	}

	public void setToPeriod(Date toPeriod) {
		this.toPeriod = toPeriod;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((promPeriod == null) ? 0 : promPeriod.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result + ((tariffId == null) ? 0 : tariffId.hashCode());
		result = prime * result + ((toPeriod == null) ? 0 : toPeriod.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((utilityId == null) ? 0 : utilityId.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Bill other = (Bill) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (promPeriod == null) {
			if (other.promPeriod != null)
				return false;
		} else if (!promPeriod.equals(other.promPeriod))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (tariffId == null) {
			if (other.tariffId != null)
				return false;
		} else if (!tariffId.equals(other.tariffId))
			return false;
		if (toPeriod == null) {
			if (other.toPeriod != null)
				return false;
		} else if (!toPeriod.equals(other.toPeriod))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (utilityId == null) {
			if (other.utilityId != null)
				return false;
		} else if (!utilityId.equals(other.utilityId))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", utilityId=" + utilityId + ", value=" + value + ", tariffId=" + tariffId
				+ ", summary=" + summary + ", userId=" + userId + ", promPeriod=" + promPeriod + ", toPeriod="
				+ toPeriod + ", comment=" + comment + "]";
	}

}
