package io.github.wallace.oms.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import io.github.wallace.oms.model.Customer;
import io.github.wallace.oms.model.Order;
import io.github.wallace.oms.repository.CustomerRepository;
import io.github.wallace.oms.repository.OrderRepository;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private CustomerRepository customerRepository;
    private OrderRepository orderRepository;

    public CustomerController(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public String getAllCustomers(Model model) {
        Iterable<Customer> customersIterable = this.customerRepository.findAll();
        List<Customer> customers = new ArrayList<>();
        customersIterable.forEach(customers::add);
        customers.sort(new Comparator<Customer>() {
            public int compare(Customer c1, Customer c2) {
                return c1.getName().compareTo(c2.getName()); // sort by name asc
            };
        });

        model.addAttribute("customers", customers);
        model.addAttribute("module", "customers");
        return "customers";
    }

    @GetMapping("/{id}")
    public String getCustomerDetails(@PathVariable("id") UUID customerId, Model model, Principal principal) {
        Optional<Customer> customer = this.customerRepository.findById(customerId);
        if (customer.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found!");
        }
        model.addAttribute("customer", customer.get());

        List<Order> orders = new ArrayList<>();

        if (principal instanceof UsernamePasswordAuthenticationToken token) {
            // AtomicBoolean auth = new AtomicBoolean(false);
            // Collection<GrantedAuthority> authorities = ((UsernamePasswordAuthenticationToken) principal)
            //         .getAuthorities();
            // authorities.forEach(authority -> {
            //     if (authority.getAuthority().equals("ROLE_ADMIN")) {
            //         auth.set(true);
            //     }
            // });
            // if (auth.get()) {
            //     Iterable<Order> ordersIterable = this.orderRepository.findAllByCustomerId(customerId);
            //     ordersIterable.forEach(orders::add);
            // }

            boolean isAdmin = token.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"));

            if(isAdmin) {
                Iterable<Order> ordersIterable = this.orderRepository.findAllByCustomerId(customerId);
                ordersIterable.forEach(orders::add);
            }
            
        }

        model.addAttribute("orders", orders);
        model.addAttribute("module", "customers");
        return "customer_detail";
    }

}
