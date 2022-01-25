package com.grocerydeliveryapplication.deliveryperson.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import io.swagger.annotations.ApiModel;

@ApiModel
@Entity
public class DeliveryPerson {
	@Id
	private int deliveryId;
	private String firstName;
	private String lastName;
	private String phoneNo;
	private int age;
	private String deliveryStatus;

	@OneToMany(targetEntity = Feedback.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "delivery_id", referencedColumnName = "deliveryId")
	private List<Feedback> feedbacks;

	public DeliveryPerson() {
		super();
	}

	public DeliveryPerson(int deliveryId, String firstName, String lastName, String phoneNo, int age,
			String deliveryStatus, List<Feedback> feedbacks) {
		super();
		this.deliveryId = deliveryId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.age = age;
		this.feedbacks = feedbacks;
		this.deliveryStatus = deliveryStatus;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public int getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

}
