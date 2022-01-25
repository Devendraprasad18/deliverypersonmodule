package com.grocerydeliveryapplication.deliveryperson.dto;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import com.grocerydeliveryapplication.deliveryperson.entities.Feedback;

public class DeliveryPersonDto {
	@NotNull
	@Min(1)
	private int deliveryId;
	@NotNull
	@Pattern(regexp = "^[A-Za-z\\s]+$", message = "Invalid firstname")
	private String firstName;
	@NotNull
	@Pattern(regexp = "^[A-Za-z\\s]+$", message = "Invalid lastname")
	private String lastName;
	@NotNull
	@Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message = "Mobile number is invalid")
	private String phoneNo;
	@Max(80)
	@Positive(message = "Invalid age")
	private int age;
	private String deliveryStatus;

	private List<Feedback> feedbacks;

	public DeliveryPersonDto() {
		super();
	}

	public DeliveryPersonDto(int deliveryId, String firstName, String lastName, String phoneNo, int age,
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

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
}