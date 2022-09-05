package ua.com.acomahmanager.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "bills")
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Double value;
	
	@Column(nullable = false)
	private Double summary;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fromPeriod;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date toPeriod;
	
	@Column(nullable = true)
	private String comment;
	
	@Column(name = "is_deleted")
	private Boolean isDeleted;
	
	@ManyToOne
	@JoinColumn (nullable = false)
	private Tariff tariff;
	
	@ManyToOne  
    @JoinColumn(nullable = false)
    private User user;

	public Bill() {	}

	public Bill(String name, User user, Tariff tariff, Double value,
			Double summary, Long userId, Date fromPeriod, Date toPeriod, String comment,
			Boolean isDeleted) {
		this.name = name;
		this.user = user; 
	    this.tariff = tariff;
		this.value = value;
		this.summary = summary;
		this.fromPeriod = fromPeriod;
		this.toPeriod = toPeriod;
		this.comment = comment;
		this.isDeleted = isDeleted;
	}

	public Bill(Long id, String name, User user, Tariff tariff,
			Double value, Double summary, Date fromPeriod, Date toPeriod, String comment,
			Boolean isDeleted) {
		this.id = id;
		this.name = name;
		this.user = user; 
		this.tariff = tariff;
		this.value = value;
		this.summary = summary;
		this.fromPeriod = fromPeriod;
		this.toPeriod = toPeriod;
		this.comment = comment;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Tariff getTariff() {
		return tariff;
	}

	public void setTariff(Tariff tariff) {
		this.tariff = tariff;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Double getSummary() {
		return summary;
	}

	public void setSummary(Double summary) {
		this.summary = summary;
	}

	public Date getFromPeriod() {
		return fromPeriod;
	}

	public void setFromPeriod(Date fromPeriod) {
		this.fromPeriod = fromPeriod;
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

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comment, fromPeriod, id, isDeleted, name, summary, tariff, toPeriod, user, value);
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
		return Objects.equals(comment, other.comment) && Objects.equals(fromPeriod, other.fromPeriod)
				&& Objects.equals(id, other.id) && Objects.equals(isDeleted, other.isDeleted)
				&& Objects.equals(name, other.name) && Objects.equals(summary, other.summary)
				&& Objects.equals(tariff, other.tariff) && Objects.equals(toPeriod, other.toPeriod)
				&& Objects.equals(user, other.user) && Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", name=" + name + ", value=" + value + ", summary=" + summary + ", fromPeriod="
				+ fromPeriod + ", toPeriod=" + toPeriod + ", comment=" + comment + ", isDeleted=" + isDeleted
				+ ", tariff=" + tariff + ", user=" + user + "]";
	}

		
}
