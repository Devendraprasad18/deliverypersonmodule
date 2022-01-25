package com.grocerydeliveryapplication.deliveryperson.mapper;

import com.grocerydeliveryapplication.deliveryperson.dto.DeliveryPersonDto;
import com.grocerydeliveryapplication.deliveryperson.entities.DeliveryPerson;

public class Mapper {
	public static DeliveryPerson persondtoToEntity(DeliveryPersonDto dpdto) {
		return new DeliveryPerson(dpdto.getDeliveryId(), dpdto.getFirstName(), dpdto.getLastName(), dpdto.getPhoneNo(),
				dpdto.getAge(), dpdto.getDeliveryStatus(), dpdto.getFeedbacks());
	}

}
