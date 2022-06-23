package com.microservices.microservice2purchase.repository;

import com.microservices.microservice2purchase.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>
{
    List<Purchase> findAllByuserId(Long userID);

}
