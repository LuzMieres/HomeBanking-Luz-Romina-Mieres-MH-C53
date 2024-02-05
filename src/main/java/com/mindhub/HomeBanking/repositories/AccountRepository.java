package com.mindhub.HomeBanking.repositories;

import com.mindhub.HomeBanking.client.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
