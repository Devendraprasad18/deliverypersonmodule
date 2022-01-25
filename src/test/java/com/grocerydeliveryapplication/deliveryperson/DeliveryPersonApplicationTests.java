package com.grocerydeliveryapplication.deliveryperson;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.grocerydeliveryapplication.deliveryperson.dto.DeliveryPersonDto;
import com.grocerydeliveryapplication.deliveryperson.entities.DeliveryPerson;
import com.grocerydeliveryapplication.deliveryperson.exceptions.IdNotFoundException;
import com.grocerydeliveryapplication.deliveryperson.mapper.Mapper;
import com.grocerydeliveryapplication.deliveryperson.repositories.IDeliveryPersonRepository;
import com.grocerydeliveryapplication.deliveryperson.services.DeliveryPersonServiceImpl;

@SpringBootTest
class DeliveryPersonApplicationTests {

	@Autowired
	private DeliveryPersonServiceImpl service;

	@MockBean
	private IDeliveryPersonRepository mockedrepo;

	/**
	 * For testing get all delivery persons
	 */
	@Test
	void getAllDeliveryPersonsTest() {
		when(mockedrepo.findAll()).thenReturn(Stream
				.of(new DeliveryPerson(1001, "Rahul", "Jain", "9896283911", 30, "pending", null),
						new DeliveryPerson(1002, "Raj", "Joshi", "9893563911", 32, "pending", null))
				.collect(Collectors.toList()));
		assertEquals(2, service.getAllDeliveryPersons().size());
	}

	/**
	 * For testing insert delivery person
	 */
	@Test
	void insertDeliveryPersonTest() {
		DeliveryPersonDto person = new DeliveryPersonDto(1003, "Ram", "Charan", "9893672911", 33, "pending", null);
		when(mockedrepo.save(Mapper.persondtoToEntity(person))).thenReturn(Mapper.persondtoToEntity(person));
		assertEquals("Inserted Successfully!!", service.insertDeliveryPerson(person));
	}

	/**
	 * For testing delete delivery person by id
	 */
	@Test
	void deleteDeliveryPersonByIdTest() {
		Optional<DeliveryPerson> person = Optional
				.of(new DeliveryPerson(1003, "Ram", "Charan", "9893672911", 33, "pending", null));
		when(mockedrepo.findById(person.get().getDeliveryId())).thenReturn(person);
		service.deleteDeliveryPersonById(person.get().getDeliveryId());
		verify(mockedrepo, times(1)).delete(person.get());
	}

	/**
	 * For testing whether get delivery person by id
	 * 
	 */
	@Test
	void getDeliveryPersonByIdTest() {
		Optional<DeliveryPerson> person = Optional
				.of(new DeliveryPerson(1003, "Ram", "Charan", "9893672911", 33, "pending", null));
		when(mockedrepo.findById(person.get().getDeliveryId())).thenReturn(person);
		assertNotNull(service.getDeliveryPersonById(person.get().getDeliveryId()));
	}

	/**
	 * For testing whether get delivery person by id throwing exceptions for
	 * negative scenarios
	 */
	@Test
	void getDeliveryPersonByIdExceptionTest() {
		assertThrows(IdNotFoundException.class, () -> service.getDeliveryPersonById(0));
	}

	/**
	 * For testing whether delete delivery person by id throwing exceptions for
	 * negative scenarios
	 */
	@Test
	void deleteDeliveryPersonByIdExceptionTest() {
		assertThrows(IdNotFoundException.class, () -> service.deleteDeliveryPersonById(0));
	}
}
