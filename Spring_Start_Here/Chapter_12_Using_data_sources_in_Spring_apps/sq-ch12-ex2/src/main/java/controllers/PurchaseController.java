package controllers;

import models.Purchase;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;
import repositories.PurchaseRepository;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseRepository purchaseRepository){
        this.purchaseRepository = purchaseRepository;
    }

    @PostMapping
    public void sendPurchase(
        @RequestBody Purchase purchase
    ){
        purchaseRepository.storePurchase(purchase);
    }

    @GetMapping
    public List<Purchase> findAllPurchase(){
        return purchaseRepository.findAllPurchases();
    }

}
