package com.mindhub.HomeBanking.repositories;

import com.mindhub.HomeBanking.models.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository <CardEntity, Long> {
}
