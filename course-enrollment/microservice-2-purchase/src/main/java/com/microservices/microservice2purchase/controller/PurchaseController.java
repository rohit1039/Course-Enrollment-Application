package com.microservices.microservice2purchase.controller;

import com.microservices.microservice2purchase.entity.Purchase;
import com.microservices.microservice2purchase.exception.PurchaseNotFoundException;
import com.microservices.microservice2purchase.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PurchaseController
{
    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/save/purchase")
    public ResponseEntity<?> savePurchase(@Valid @RequestBody Purchase purchase)
    {
        return new ResponseEntity<>(purchaseService.savePurchase(purchase), HttpStatus.CREATED);
    }

    @GetMapping("/get/purchase/{userId}")
    public ResponseEntity<?> getAllPurchaseOfUser(@PathVariable(name = "userId") Long userID)
    {
        List<Purchase> purchase = purchaseService.findAllPurchasesOfUser(userID);
        if(purchase.isEmpty())
        {
            throw new PurchaseNotFoundException("No purchase found!");
        }
        return ResponseEntity.ok(purchase);
    }

}
