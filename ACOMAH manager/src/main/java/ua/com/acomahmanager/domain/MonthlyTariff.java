package ua.com.acomahmanager.domain;

import java.sql.Date;

public class MonthlyTariff {
	private Integer id;
	private String utility;
	private Integer utilityId;
//	private Month month;
//	private Integer year;
	private Date fromDate;
	private String comment;
	
	public MonthlyTariff() {}

	public MonthlyTariff(String utility, Integer utilityId, Date fromDate, String comment) {
		this.utility = utility;
		this.utilityId = utilityId;
		this.fromDate = fromDate;
		this.comment = comment;
	}

	public MonthlyTariff(Integer id, String utility, Integer utilityId, Date fromDate, String comment) {
		this.id = id;
		this.utility = utility;
		this.utilityId = utilityId;
		this.fromDate = fromDate;
		this.comment = comment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		result = prime * result + ((fromDate == null) ? 0 : fromDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
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
		return "MonthlyTariff [id=" + id + ", utility=" + utility + ", utilityId=" + utilityId + ", fromDate="
				+ fromDate + ", comment=" + comment + "]";
	}
}
