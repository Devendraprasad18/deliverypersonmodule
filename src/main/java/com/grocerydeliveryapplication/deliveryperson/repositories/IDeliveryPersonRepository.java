package com.grocerydeliveryapplication.deliveryperson.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grocerydeliveryapplication.deliveryperson.entities.DeliveryPerson;

@Repository("personrepo")
public interface IDeliveryPersonRepository extends JpaRepository<DeliveryPerson, Integer> {

}
