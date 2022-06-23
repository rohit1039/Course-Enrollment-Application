package com.microservices.microservice2purchase.service;

import com.microservices.microservice2purchase.entity.Purchase;

import java.util.List;

public interface PurchaseService
{

    Purchase savePurchase(Purchase purchase);

    List<Purchase> findAllPurchasesOfUser(Long userID);
}
