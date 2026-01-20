package io.github.wallace.oms.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "customer_id")
    private UUID id;

    @Column(name = "name")
    private String name;
    
    @Column(name = "contact_name")
    private String contactName;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "phone")
    private String phoneNumber;
}
