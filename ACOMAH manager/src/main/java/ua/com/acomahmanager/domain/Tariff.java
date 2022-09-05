package ua.com.acomahmanager.domain;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "tariffs")
public class Tariff {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Double value;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fromDate;
	
	@Column(nullable = true)
	private String description;
	
	@Column(name = "is_deleted")
	private Boolean isDeleted;
	
	@OneToMany(mappedBy = "tariff", fetch = FetchType.LAZY)
	private Set<Bill> bill;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Utility utility;
	
	public Tariff() {}

	public Tariff(String name, Double value, Date fromDate, String description,
			Boolean isDeleted) {
		this.name = name;
		this.value = value;
		this.fromDate = fromDate;
		this.description = description;
		this.isDeleted = isDeleted;
	}

	public Tariff(Long id, String name, Double value, Date fromDate, 
			String description, Boolean isDeleted) {
		this.id = id;
		this.name = name;
		this.value = value;
		this.fromDate = fromDate;
		this.description = description;
		this.isDeleted = isDeleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Utility getUtility() {
		return utility;
	}

	public void setUtility(Utility utility) {
		this.utility = utility;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, fromDate, id, isDeleted, name, utility, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tariff other = (Tariff) obj;
		return Objects.equals(description, other.description)
				&& Objects.equals(fromDate, other.fromDate) && Objects.equals(id, other.id)
				&& Objects.equals(isDeleted, other.isDeleted) && Objects.equals(name, other.name)
				&& Objects.equals(utility, other.utility) && Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "Tariff [id=" + id + ", name=" + name + ", value=" + value + ", fromDate=" + fromDate + ", description="
				+ description + ", isDeleted=" + isDeleted + ", utility=" + utility + "]";
	}
}
