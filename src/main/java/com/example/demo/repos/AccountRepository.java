package com.example.demo.repos;

import com.example.demo.accounts.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by edwar on 11/22/2017.
 */
public interface AccountRepository extends CrudRepository<Account, Integer> {
    Account findByUsername(String username);
}
