package com.api.mscustomer.service;

import com.api.mscustomer.model.Customer;
import java.util.List;


public interface CustomerService {
    public List<Customer> listCustomers();
    public Customer getCustomer(int id);
    public boolean deleteCustomer(int id);
}