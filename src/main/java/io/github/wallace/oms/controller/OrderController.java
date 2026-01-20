package io.github.wallace.oms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.wallace.oms.dto.OrderDto;
import io.github.wallace.oms.model.Customer;
import io.github.wallace.oms.model.Order;
import io.github.wallace.oms.repository.CustomerRepository;
import io.github.wallace.oms.repository.OrderRepository;


@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderController(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public String getAllOrders(Model model) {
        Iterable<Order> ordersIterable = this.orderRepository.findAll();
        List<OrderDto> orders = new ArrayList<>();
        ordersIterable.forEach((or) -> {
            Optional<Customer> customer = this.customerRepository.findById(or.getCustomerId());
            String customerName = customer.map((c) -> c.getName()).orElse("-");
            OrderDto orderDto = new OrderDto(or.getId(), or.getCustomerId(), customerName, or.getOrderInfo());
            orders.add(orderDto);
        });
        model.addAttribute("orders", orders);
        model.addAttribute("module", "orders");

        return "orders";    
    }
}
