package io.github.wallace.oms.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.github.wallace.oms.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, UUID> {

}
