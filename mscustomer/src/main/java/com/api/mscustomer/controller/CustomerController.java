package com.api.mscustomer.controller;

import com.api.mscustomer.model.Customer;
import com.api.mscustomer.service.CustomerService;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping("/customers")
    public List<Customer> viewCustomers(@RequestHeader Map<String, String> headers) {
        return customerService.listCustomers();
    }
    @GetMapping("/customers/{id}")
    public Customer viewCustomer(@RequestHeader Map<String, String> headers,
                                 @PathVariable int id) {
        return customerService.getCustomer(id);
    }
    @DeleteMapping("/customers/{id}")
    public boolean deleteCustomer(@RequestHeader Map<String, String> headers,
                                  @PathVariable int id) {
        return customerService.deleteCustomer(id);
    }
}
