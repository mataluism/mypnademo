package com.luismata.mypnademo.account.core.services;

import com.luismata.mypnademo.account.core.ports.outgoing.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class AccountServiceTests {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private AccountRepository accountRepository;

//    @ParameterizedTest
//    @ValueSource(ints = {1,2})
//    void givenValidCustomerId_whenCallingCreateAccount_thenNewAccountCreated(int accountOwnerCustomerId) {
//        // given
//        var testCustomer = new Customer("testName");
//        var getCustomerByIdEndpoint = "http://localhost:8080/customer/get-customer-by-id?customerIdToGet={customerId}";
//
//        //when
//        Mockito.when(restTemplate.getForObject(getCustomerByIdEndpoint, Customer.class, accountOwnerCustomerId)).thenReturn(testCustomer);
//        var newAccount = accountService.createNewAccount(accountOwnerCustomerId);
//
//        // then
//        assertNotNull(newAccount);
//        Assertions.assertEquals(accountOwnerCustomerId, newAccount.getAccountOwnerCustomerId());
//    }

//    @ParameterizedTest
//    @ValueSource(ints = {1001,2321})
//    void givenInvalidCustomerId_whenCallingCreateAccount_thenProvidedCustomerIdNotFoundException(int customerIdToGet) {
//        // given
//
//        //when
//        var exception = assertThrows(ProvidedCustomerIdNotFoundException.class, () -> accountService.createNewAccount(customerIdToGet));
//
//        //then
//        assertEquals( "Invalid customer id provided.", exception.getMessage());
//    }

//    @ParameterizedTest
//    @CsvSource({"1, 10000", "2, 20000", "3, 50"})
//    void givenValidAmountAndValidAccountId_whenCallingDepositAmount_thenTransactionCreated(int accountId, double amount) {
//        // given
//        var accountBalance = accountService.getAccountBalance(accountId);
//
//        // when
//        accountService.depositAmountIntoAccount(accountId, amount);
//
//        // then
//        var transactionsFromAccount = transactionService.getTransactionsFromAccount(accountId);
//        assertNotNull(transactionsFromAccount.get(transactionsFromAccount.size() - 1));
//        assertEquals(accountBalance + amount, accountService.getAccountBalance(accountId));
//    }
//
//    @ParameterizedTest
//    @CsvSource({"1, -10000", "2, -20000", "3, -50"})
//    void givenInvalidAmountAndValidAccountId_whenCallingDepositAmount_thenInvalidAmountException(int accountId, double amount) {
//        // given
//
//        // when
//
//        // then
//    }
//
//    @ParameterizedTest
//    @CsvSource({"a, 10000", "2.5, 20000", "-3, 50"})
//    void givenValidAmountAndInvalidAccountId_whenCallingDepositAmount_thenInvalidAmountException(int accountId, double amount) {
//        // given
//
//        // when
//
//        // then
//    }

}
