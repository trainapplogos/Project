package ua.com.acomahmanager.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private Long recipientId;
	
	@Column
	private String message;
	
	@Column
	private Boolean shown;
	
	@Column
	private Boolean important;
	
	@Column
	private MessageType type;
	
	@Column(nullable = true) //true for non rental messages
	private Long billId;
	
	@Column
	private Date creationDate;
	
	@Column(name = "is_deleted")
	private Boolean isDeleted;
	
	public Message() {}

	public Message(Long recipientId, String message, Boolean shown, Boolean important, MessageType type, Long billId,
			Date creationDate, Boolean isDeleted) {
		this.recipientId = recipientId;
		this.message = message;
		this.shown = shown;
		this.important = important;
		this.type = type;
		this.billId = billId;
		this.creationDate = creationDate;
		this.isDeleted = isDeleted;
	}

	public Message(Long id, Long recipientId, String message, Boolean shown, Boolean important, MessageType type,
			Long billId, Date creationDate, Boolean isDeleted) {
		this.id = id;
		this.recipientId = recipientId;
		this.message = message;
		this.shown = shown;
		this.important = important;
		this.type = type;
		this.billId = billId;
		this.creationDate = creationDate;
		this.isDeleted = isDeleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(Long recipientId) {
		this.recipientId = recipientId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getShown() {
		return shown;
	}

	public void setShown(Boolean shown) {
		this.shown = shown;
	}

	public Boolean getImportant() {
		return important;
	}

	public void setImportant(Boolean important) {
		this.important = important;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billId == null) ? 0 : billId.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((important == null) ? 0 : important.hashCode());
		result = prime * result + ((isDeleted == null) ? 0 : isDeleted.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((recipientId == null) ? 0 : recipientId.hashCode());
		result = prime * result + ((shown == null) ? 0 : shown.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Message other = (Message) obj;
		if (billId == null) {
			if (other.billId != null)
				return false;
		} else if (!billId.equals(other.billId))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (important == null) {
			if (other.important != null)
				return false;
		} else if (!important.equals(other.important))
			return false;
		if (isDeleted == null) {
			if (other.isDeleted != null)
				return false;
		} else if (!isDeleted.equals(other.isDeleted))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (recipientId == null) {
			if (other.recipientId != null)
				return false;
		} else if (!recipientId.equals(other.recipientId))
			return false;
		if (shown == null) {
			if (other.shown != null)
				return false;
		} else if (!shown.equals(other.shown))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", recipientId=" + recipientId + ", message=" + message + ", shown=" + shown
				+ ", important=" + important + ", type=" + type + ", billId=" + billId + ", creationDate="
				+ creationDate + ", isDeleted=" + isDeleted + "]";
	}
}
