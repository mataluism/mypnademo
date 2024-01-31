package com.luismata.mypnademo.customer.infrastructure.repositories;

import com.luismata.mypnademo.customer.core.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJPARepository extends JpaRepository<Customer, Integer> {
}
