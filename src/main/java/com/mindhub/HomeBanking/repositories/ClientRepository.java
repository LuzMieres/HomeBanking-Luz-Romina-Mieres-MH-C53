package com.mindhub.HomeBanking.repositories;

import com.mindhub.HomeBanking.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository <Client, Long> {

}