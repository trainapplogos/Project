package ua.com.acomahmanager.domain;

public class Bill {
	private Integer id;
	private String utility; //like water, electricity
	private Integer utilityId;
	private Double value;
	private Integer tariffId; //id of monthly tariff for utility
	private Double summary;
	private String comment;
	
	public Bill() {	}

	public Bill(String utility, Integer utilityId, Double value, Integer tariffId, Double summary, String comment) {
		this.utility = utility;
		this.utilityId = utilityId;
		this.value = value;
		this.tariffId = tariffId;
		this.summary = summary;
		this.comment = comment;
	}

	public Bill(Integer id, String utility, Integer utilityId, Double value, Integer tariffId, Double summary,
			String comment) {
		this.id = id;
		this.utility = utility;
		this.utilityId = utilityId;
		this.value = value;
		this.tariffId = tariffId;
		this.summary = summary;
		this.comment = comment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result + ((tariffId == null) ? 0 : tariffId.hashCode());
		result = prime * result + ((utility == null) ? 0 : utility.hashCode());
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
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", utility=" + utility + ", utilityId=" + utilityId + ", value=" + value
				+ ", tariffId=" + tariffId + ", summary=" + summary + ", comment=" + comment + "]";
	}
}
