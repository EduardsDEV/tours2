package com.example.demo.repos;

import com.example.demo.accounts.Account;
import com.example.demo.models.users.Guest;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by edwar on 11/29/2017.
 */
public interface GuestRepository extends CrudRepository<Guest, Long> {
    Guest getGuestById(long id);
    Guest getGuestByAccount(Account account);
}
