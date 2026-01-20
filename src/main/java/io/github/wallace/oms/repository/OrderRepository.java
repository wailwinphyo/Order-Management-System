package io.github.wallace.oms.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import io.github.wallace.oms.model.Order;

public interface OrderRepository extends CrudRepository<Order, UUID>{
    List<Order> findAllByCustomerId(UUID customerId);
}
