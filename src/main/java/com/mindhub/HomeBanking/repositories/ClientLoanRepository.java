package com.mindhub.HomeBanking.repositories;

import com.mindhub.HomeBanking.models.ClientLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientLoanRepository extends JpaRepository<ClientLoan, Long> {
}