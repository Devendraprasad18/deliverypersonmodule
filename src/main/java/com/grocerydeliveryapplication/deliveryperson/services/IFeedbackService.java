package com.grocerydeliveryapplication.deliveryperson.services;

import com.grocerydeliveryapplication.deliveryperson.entities.Feedback;

public interface IFeedbackService {
	String setFeedback(int id, Feedback feedback);

	String deleteFeedbackById(int id);

	Feedback getFeedbackById(int id);
}