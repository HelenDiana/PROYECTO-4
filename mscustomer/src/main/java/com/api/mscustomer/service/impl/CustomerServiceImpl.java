package com.api.mscustomer.service.impl;

import com.api.mscustomer.model.Customer;
import com.api.mscustomer.dto.ApiResponseDTO;
import com.api.mscustomer.dto.AccountResponseDTO;
import com.api.mscustomer.repository.CustomerRepository;
import com.api.mscustomer.service.CustomerService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerServiceImpl implements CustomerService{

    public static List<Customer> data = new ArrayList<>(List.of(
            Customer.builder().id(1).nombre("Juan").apellido("Chanco").dni("43223356")
                    .correo("juan.chanco@gmail.com").build(),
            Customer.builder().id(2).nombre("Jimmy").apellido("Solar").dni("45223069")
                    .correo("jimmy.solar@gmail.com").build(),
            Customer.builder().id(3).nombre("Jorge").apellido("Juarez").dni("96520014")
                    .correo("jorge.juarez2@gmail.com").build(),
            Customer.builder().id(4).nombre("Carlos").apellido("Manchego").dni("56302170")
                    .correo("carlos.manchego@gmail.com").build(),
            Customer.builder().id(5).nombre("Manuel").apellido("Perez").dni("47120989")
                    .correo("manuel.perez4@gmail.com").build()));
    @Override
    public List<Customer> listCustomers() {
        return data;
    }
    @Override
    public Customer getCustomer(int id) {
        return data.stream()
                .filter(dato -> dato.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No existe"));
    }
    @Override
    public boolean deleteCustomer(int id) {
        return data.removeIf(cust -> cust.getId()==id);
    }
}
