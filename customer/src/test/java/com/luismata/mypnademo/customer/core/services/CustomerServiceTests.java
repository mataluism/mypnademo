package com.luismata.mypnademo.customer.core.services;

import com.luismata.mypnademo.customer.core.exceptions.InvalidNameProvidedException;
import com.luismata.mypnademo.customer.core.exceptions.CustomerIdNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CustomerServiceTests {

    @Autowired
    private CustomerService customerService;

    @BeforeEach
    void init() {
    }

    @ParameterizedTest
    @ValueSource(strings = {"john", "johnny doe"})
    void givenValidName_whenCallingCreateCustomer_thenNewCustomerCreated(String newCustomerName) {
        // given

        //when
        var newCustomer = customerService.createNewCustomer(newCustomerName);

        //then
        assertNotNull(newCustomer);
        assertEquals(newCustomerName, newCustomer.getCustomerName());
    }

    @ParameterizedTest
    @ValueSource(strings = {"john33", "doe!#$%&/()=?»}"})
    void givenInvalidName_whenCallingCreateCustomer_thenInvalidParametersException(String newCustomerName) {
        // given

        //when
        var exception = assertThrows(InvalidNameProvidedException.class, () -> customerService.createNewCustomer(newCustomerName));

        //then
        assertEquals("Invalid name provided.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2})
    void givenValidCustomerId_whenCallingGetCustomerById_thenReturnsCustomer(int customerIdToGet) {
        // given

        //when
        var customer = customerService.getCustomerById(customerIdToGet);

        //then
        assertNotNull(customer);
        assertEquals(customerIdToGet, customer.getCustomerId());
    }

    @ParameterizedTest
    @ValueSource(ints = {1001,2321})
    void givenInvalidCustomerId_whenCallingGetCustomerById_thenProvidedCustomerIdNotFoundException(int customerIdToGet) {
        // given

        //when
        var exception = assertThrows(CustomerIdNotFoundException.class, () -> customerService.getCustomerById(customerIdToGet));

        //then
        assertEquals("Customer with ID: " + customerIdToGet + " not found.", exception.getMessage());
    }

}
