package com.mindhub.HomeBanking.repositories;

import com.mindhub.HomeBanking.models.ClientLoan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientLoanRepository extends JpaRepository <ClientLoan, Long> {
}
