package com.grocerydeliveryapplication.deliveryperson.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocerydeliveryapplication.deliveryperson.dto.DeliveryPersonDto;
import com.grocerydeliveryapplication.deliveryperson.entities.DeliveryPerson;
import com.grocerydeliveryapplication.deliveryperson.exceptions.IdNotFoundException;
import com.grocerydeliveryapplication.deliveryperson.mapper.Mapper;
import com.grocerydeliveryapplication.deliveryperson.repositories.IDeliveryPersonRepository;

@Service("personservice")
public class DeliveryPersonServiceImpl implements IDeliveryPersonService {

	static final String NOT_FOUND = "Error: Requested delivery id not found!";

	@Autowired
	IDeliveryPersonRepository repo;

	@Override
	public List<DeliveryPerson> getAllDeliveryPersons() {
		return repo.findAll();
	}

	/**
	 * Service method for inserting the delivery person
	 */
	@Override
	public String insertDeliveryPerson(DeliveryPersonDto dpdto) {
		DeliveryPerson person = Mapper.persondtoToEntity(dpdto);
		repo.save(person);
		return "Inserted Successfully!!";
	}

	/**
	 * Service method for deleting delivery person by id
	 */
	@Override
	public String deleteDeliveryPersonById(int id) {
		Optional<DeliveryPerson> result = repo.findById(id);
		if (result.isPresent()) {
			repo.delete(result.get());
			return "Deleted Successfully!!";
		} else
			throw new IdNotFoundException(NOT_FOUND);
	}

	/**
	 * Service method for updating delivery person details
	 */
	@Override
	public String updateDeliveryPerson(int id, DeliveryPersonDto dpdto) {
		DeliveryPerson person = Mapper.persondtoToEntity(dpdto);
		Optional<DeliveryPerson> result = repo.findById(id);
		if (result.isPresent()) {
			repo.save(person);
			return "Updated Successfully!!";
		} else
			throw new IdNotFoundException(NOT_FOUND);
	}

	/**
	 * Service method for fetching delivery person by id
	 */
	@Override
	public DeliveryPerson getDeliveryPersonById(int id) {
		Optional<DeliveryPerson> result = repo.findById(id);
		if (result.isPresent())
			return result.get();
		else
			throw new IdNotFoundException(NOT_FOUND);
	}

}
