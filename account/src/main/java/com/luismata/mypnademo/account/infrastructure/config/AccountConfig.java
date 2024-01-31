package com.luismata.mypnademo.account.infrastructure.config;

import com.luismata.mypnademo.account.core.ports.incoming.CreateNewAccount;
import com.luismata.mypnademo.account.core.ports.outgoing.AccountRepository;
import com.luismata.mypnademo.account.core.services.AccountService;
import com.luismata.mypnademo.account.infrastructure.adapters.AccountRepositoryAdapter;
import com.luismata.mypnademo.account.infrastructure.repositories.AccountJPARepository;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class AccountConfig {

    @Bean
    public CreateNewAccount createNewAccount(AccountRepository accountRepository, RestTemplate restTemplate) {
        return new AccountService(accountRepository, restTemplate);
    }

    @Bean
    public AccountRepository accountRepository(AccountJPARepository accountRepository){
        return new AccountRepositoryAdapter(accountRepository);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.ofMillis(3000))
                .setReadTimeout(Duration.ofMillis(3000))
                .build();
    }

}
