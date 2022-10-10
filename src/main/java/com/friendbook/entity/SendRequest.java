package com.friendbook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "requests")
public class SendRequest {
	@Id
	@Column(name = "id")
	private int id;
	@ManyToOne
	@JoinColumn(name = "sender_id")
	private User senderid;

	@Column(name = "reciever_id")
	private int recieverid;
	@Column(name = "accept_id")
	private int acceptid;

	public SendRequest(int id, User senderid, int recieverid, int acceptid) {
		super();
		this.id = id;
		this.senderid = senderid;
		this.recieverid = recieverid;
		this.acceptid = acceptid;
	}

	public SendRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User getSenderid() {
		return senderid;
	}

	public void setSenderid(User senderid) {
		this.senderid = senderid;
	}

	public int getRecieverid() {
		return recieverid;
	}

	public void setRecieverid(int recieverid) {
		this.recieverid = recieverid;
	}

	public int getAcceptid() {
		return acceptid;
	}

	public void setAcceptid(int acceptid) {
		this.acceptid = acceptid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "SendRequest [id=" + id + ", senderid=" + senderid + ", recieverid=" + recieverid + ", acceptid="
				+ acceptid + "]";
	}

}
