package com.grocerydeliveryapplication.deliveryperson.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grocerydeliveryapplication.deliveryperson.dto.DeliveryPersonDto;
import com.grocerydeliveryapplication.deliveryperson.entities.DeliveryPerson;
import com.grocerydeliveryapplication.deliveryperson.entities.Feedback;
import com.grocerydeliveryapplication.deliveryperson.responseentities.SuccessInfo;
import com.grocerydeliveryapplication.deliveryperson.services.IDeliveryPersonService;
import com.grocerydeliveryapplication.deliveryperson.services.IFeedbackService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("This is for all kinds of operations performed on Delivery person")
@Validated
@RestController
@CrossOrigin("http://localhost:57982/")
public class DeliveryPersonController {

	@Autowired
	IDeliveryPersonService personservice;

	@Autowired
	IFeedbackService feedbackservice;

	@ApiOperation("This is fetching details of all delivery persons")
	@GetMapping(value = "/deliveryperson/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DeliveryPerson> getAllDeliveryPersons() {
		return personservice.getAllDeliveryPersons();
	}

	@ApiOperation("This is fetching details of delivery person on the basis of id")
	@GetMapping(value = "/deliveryperson/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DeliveryPerson getDeliveryPersonById(@PathVariable("id") int id) {
		return personservice.getDeliveryPersonById(id);
	}

	@ApiOperation("This is inserting details of delivery person")
	@PostMapping(value = "/deliveryperson/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuccessInfo> insertDeliveryPerson(@Valid @RequestBody DeliveryPersonDto person) {
		String str = personservice.insertDeliveryPerson(person);
		return new ResponseEntity<>(new SuccessInfo(HttpStatus.CREATED, 201, str), HttpStatus.CREATED);
	}

	@ApiOperation("This is deleting delivery person on the basis of id")
	@DeleteMapping(value = "/deliveryperson/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteDeliveryPersonById(@PathVariable("id") int id) {
		return personservice.deleteDeliveryPersonById(id);
	}

	@ApiOperation("This is updating the details of delivery person")
	@PutMapping(value = "/deliveryperson/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateDeliveryPerson(@PathVariable("id") int id, @Valid @RequestBody DeliveryPersonDto person) {
		return personservice.updateDeliveryPerson(id, person);
	}

	@ApiOperation("This is setting feedback for delivery person")
	@PostMapping(value = "/deliveryperson/feedback/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String setFeedback(@PathVariable("id") int id, @RequestBody Feedback feedback) {
		return feedbackservice.setFeedback(id, feedback);
	}

	@DeleteMapping(value = "/feedback/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deletedFeedbackById(@PathVariable("id") int id) {
		return feedbackservice.deleteFeedbackById(id);
	}

	@GetMapping(value = "/feedback/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Feedback getFeedbackById(@PathVariable("id") int id) {
		return feedbackservice.getFeedbackById(id);
	}
}