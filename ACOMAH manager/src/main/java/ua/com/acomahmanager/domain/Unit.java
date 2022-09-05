package ua.com.acomahmanager.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "units")
public class Unit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;
	private String description;
	
	@OneToMany(mappedBy = "unit", fetch = FetchType.LAZY)
	private Set<Utility> utilities;
	
	@Column(name = "is_deleted")
	private Boolean isDeleted;	
	
	public Unit() {}

	public Unit(Integer id, String name, String description, Boolean isDeleted) {
		this.id = id;
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
	public String toString() {
		return "Unit [id=" + id + ", name=" + name + ", description=" + description +  ", isDeleted=" + isDeleted + "]";
	}

}
