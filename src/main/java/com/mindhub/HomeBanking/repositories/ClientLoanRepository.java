package com.mindhub.HomeBanking.repositories;

import com.mindhub.HomeBanking.models.ClientLoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientLoanRepository extends JpaRepository <ClientLoanEntity, Long> {
}
