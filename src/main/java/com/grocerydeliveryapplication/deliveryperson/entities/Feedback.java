package com.grocerydeliveryapplication.deliveryperson.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;

@ApiModel
@Entity
public class Feedback {
	@Id
	private int feedbackId;
	private String feedback;
	private double overallRating;

	public Feedback() {
		super();
	}

	public Feedback(int feedbackId, String feedback, double overallRating) {
		super();
		this.feedbackId = feedbackId;
		this.feedback = feedback;
		this.overallRating = overallRating;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public double getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(double overallRating) {
		this.overallRating = overallRating;
	}
}
