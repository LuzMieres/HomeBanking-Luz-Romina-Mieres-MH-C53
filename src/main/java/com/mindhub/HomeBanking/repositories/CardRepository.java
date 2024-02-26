package com.mindhub.HomeBanking.repositories;

import com.mindhub.HomeBanking.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}