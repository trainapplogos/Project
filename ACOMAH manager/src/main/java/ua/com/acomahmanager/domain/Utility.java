package ua.com.acomahmanager.domain;

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

@Entity
@Table(name = "utilities")
public class Utility {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false)
	private String name; //electricity, water, gas
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Unit unit; //m3, kWh(KWatt-hour)
	
	@Column(nullable = true)
	private String description;
	
	@Column(name = "is_deleted")
	private Boolean isDeleted;
	
	@OneToMany(mappedBy = "utility", fetch = FetchType.LAZY)
	private Set<Tariff> tariffs;
	
	public Utility() {}

	public Utility(String name, Unit unit, String description, Boolean isDeleted) {
		this.name = name;
		this.unit = unit;
		this.description = description;
		this.isDeleted = isDeleted;
	}

	public Utility(Integer id, String name, Unit unit, String description, Boolean isDeleted) {
		this.id = id;
		this.unit = unit;
		this.name = name;
		this.description = description;
		this.isDeleted = isDeleted;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
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

	@Override
	public int hashCode() {
		return Objects.hash(description, id, isDeleted, name, unit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utility other = (Utility) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(isDeleted, other.isDeleted) && Objects.equals(name, other.name)
				&& Objects.equals(unit, other.unit);
	}

	@Override
	public String toString() {
		return "Utility [id=" + id + ", name=" + name + ", unit=" + unit + ", description=" + description
				+ ", isDeleted=" + isDeleted + "]";
	}
	
}
