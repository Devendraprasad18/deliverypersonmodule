package com.grocerydeliveryapplication.deliveryperson.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocerydeliveryapplication.deliveryperson.entities.DeliveryPerson;
import com.grocerydeliveryapplication.deliveryperson.entities.Feedback;
import com.grocerydeliveryapplication.deliveryperson.exceptions.IdNotFoundException;
import com.grocerydeliveryapplication.deliveryperson.repositories.IDeliveryPersonRepository;
import com.grocerydeliveryapplication.deliveryperson.repositories.IFeedbackRepository;

@Service("feedbackservice")
public class FeedbackServiceImpl implements IFeedbackService {

	@Autowired
	IDeliveryPersonRepository personrepo;

	@Autowired
	IFeedbackRepository feedbackrepo;

	/**
	 * Service method for setting the feedback of delivery person
	 */
	@Override
	public String setFeedback(int id, Feedback feedback) {
		Optional<DeliveryPerson> result = personrepo.findById(id);
		if (result.isPresent()) {
			DeliveryPerson person = new DeliveryPerson();
			person.setDeliveryId(id);
			person.setAge(result.get().getAge());
			person.setFirstName(result.get().getFirstName());
			person.setLastName(result.get().getLastName());
			person.setPhoneNo(result.get().getPhoneNo());
			List<Feedback> feedbacks = result.get().getFeedbacks();
			feedbacks.add(feedback);
			person.setFeedbacks(feedbacks);
			personrepo.save(person);
			return "Feedback Submitted Successfully!!";
		} else
			throw new IdNotFoundException("Delivery person does not exist!!");
	}

	/**
	 * Service method for deleting feedback by id
	 */
	@Override
	public String deleteFeedbackById(int id) {
		Optional<Feedback> feedback = feedbackrepo.findById(id);
		if (feedback.isPresent()) {
			feedbackrepo.deleteById(id);
			return "Deleted Successfully!!";
		} else
			throw new IdNotFoundException("Feedback id does not exist!!");
	}

	/**
	 * Service method for getting feedback by id
	 */
	@Override
	public Feedback getFeedbackById(int id) {
		Optional<Feedback> feedback = feedbackrepo.findById(id);
		if (feedback.isPresent())
			return feedback.get();
		else
			throw new IdNotFoundException("Feedback id does not exist!!");
	}

}
