package com.grocerydeliveryapplication.deliveryperson.services;

import java.util.List;

import com.grocerydeliveryapplication.deliveryperson.dto.DeliveryPersonDto;
import com.grocerydeliveryapplication.deliveryperson.entities.DeliveryPerson;

public interface IDeliveryPersonService {
	List<DeliveryPerson> getAllDeliveryPersons();

	DeliveryPerson getDeliveryPersonById(int id);

	String insertDeliveryPerson(DeliveryPersonDto dpdto);

	String deleteDeliveryPersonById(int id);

	String updateDeliveryPerson(int id, DeliveryPersonDto dpdto);
}