package com.demo.csp.repository;

import com.demo.csp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    Account getByUserId(Long userId);
}
