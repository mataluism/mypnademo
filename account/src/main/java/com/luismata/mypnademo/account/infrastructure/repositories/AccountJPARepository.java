package com.luismata.mypnademo.account.infrastructure.repositories;

import com.luismata.mypnademo.account.core.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountJPARepository extends JpaRepository<Account, Integer> {
}
