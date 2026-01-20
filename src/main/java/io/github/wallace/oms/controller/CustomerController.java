package io.github.wallace.oms.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.wallace.oms.model.Customer;
import io.github.wallace.oms.repository.CustomerRepository;


@Controller
@RequestMapping("/customers")
public class CustomerController {
   
    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public String customers(Model model) {
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
    
}
