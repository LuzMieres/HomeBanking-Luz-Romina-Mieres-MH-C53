package com.mindhub.HomeBanking.repositories;

import com.mindhub.HomeBanking.models.PaymentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentsRepository extends JpaRepository <PaymentsEntity, Long>{

}
