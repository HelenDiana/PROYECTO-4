package com.api.mscustomer;
import com.api.mscustomer.model.Customer;
import com.api.mscustomer.service.CustomerService;
import com.api.mscustomer.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest
class MsCustomerDummyApplicationTests {
	@InjectMocks
	private CustomerServiceImpl customerServiceimpl;// Inyectar el mock en el servicio
	public Customer[] customersArray;
	@BeforeEach
	public void setUp() {
		// Inicializar los mocks
		MockitoAnnotations.openMocks(this);
		customersArray = new Customer[] {
				new Customer(1, "Marcos","Martinez","jmartinez@gmail.com","78580311"),
				new Customer(2, "Roberto","Figueroa","rfigueroa@gmail.com","04536666"),
				new Customer(3, "Steve","Palomino","steve@gmail.com","45789999")
		};
	}
	@Test
	public void testObtenerCustomerPorId() {
		Customer resultado = customerServiceimpl.getCustomer(1);
		assertNotNull(resultado);
		assertEquals("Juan", resultado.getNombre());
	}
	@Test
	public void testAllCustomers() {
		List<Customer> resultado = customerServiceimpl.listCustomers();
		assertNotNull(resultado);
		assertEquals(5, resultado.size());
		assertEquals("Juan", resultado.get(0).getNombre());
	}
	@Test
	public void testAllCustomersArray() {
		List<Customer> resultado = Arrays.asList(customersArray);
		assertNotNull(resultado);
		assertEquals(3, resultado.size());
		assertEquals("Marcos", resultado.get(0).getNombre());
	}
}

