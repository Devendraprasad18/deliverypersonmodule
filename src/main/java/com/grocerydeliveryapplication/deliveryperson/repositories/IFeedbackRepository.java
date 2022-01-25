package com.grocerydeliveryapplication.deliveryperson.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grocerydeliveryapplication.deliveryperson.entities.Feedback;

@Repository("feedbackrepo")
public interface IFeedbackRepository extends JpaRepository<Feedback,Integer>{

}

