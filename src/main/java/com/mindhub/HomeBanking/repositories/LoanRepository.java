package com.mindhub.HomeBanking.repositories;

import com.mindhub.HomeBanking.models.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository <LoanEntity, Long> {
}
