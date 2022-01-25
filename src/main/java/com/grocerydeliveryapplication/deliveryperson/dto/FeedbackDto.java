package com.grocerydeliveryapplication.deliveryperson.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class FeedbackDto {
	@Min(1)
	private int feedbackId;
	@NotEmpty
	private String feedback;
	@Min(1)
	private double overallRating;

	public FeedbackDto() {
		super();
	}

	public FeedbackDto(int feedbackId, String feedback, double overallRating) {
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
