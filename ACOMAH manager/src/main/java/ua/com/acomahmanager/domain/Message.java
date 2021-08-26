package ua.com.acomahmanager.domain;

import java.sql.Date;

public class Message {
	private Integer id;
	private Integer recipientId;
	private String message;
	private Boolean shown;
	private Boolean important;
	private MessageType type;
	private Date creationDate;
	
	public Message() {}

	public Message(Integer recipientId, String message, Boolean shown, Boolean important, MessageType type,
			Date creationDate) {
		this.recipientId = recipientId;
		this.message = message;
		this.shown = shown;
		this.important = important;
		this.type = type;
		this.creationDate = creationDate;
	}

	public Message(Integer id, Integer recipientId, String message, Boolean shown, Boolean important, MessageType type,
			Date creationDate) {
		this.id = id;
		this.recipientId = recipientId;
		this.message = message;
		this.shown = shown;
		this.important = important;
		this.type = type;
		this.creationDate = creationDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(Integer recipientId) {
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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((important == null) ? 0 : important.hashCode());
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
				+ ", important=" + important + ", type=" + type + ", creationDate=" + creationDate + "]";
	}
	
}
