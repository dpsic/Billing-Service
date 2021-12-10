package com.example.billingservice.web;

import com.example.billingservice.entities.Bill;
import com.example.billingservice.feign.CustomerRestClient;
import com.example.billingservice.feign.ProductItemRestClient;
import com.example.billingservice.repository.BillRepo;
import com.example.billingservice.repository.ProductItemRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingRestController{
    private BillRepo billRepo;
    private ProductItemRepo productItemRepo;
    private CustomerRestClient customerRestClient;
    private ProductItemRestClient productItemRestClient;

    public BillingRestController(BillRepo billRepo, ProductItemRepo productItemRepo, CustomerRestClient customerRestClient, ProductItemRestClient productItemRestClient) {
        this.billRepo = billRepo;
        this.productItemRepo = productItemRepo;
        this.customerRestClient = customerRestClient;
        this.productItemRestClient = productItemRestClient;
    }
@GetMapping(path="/fullBill/{id}")
    public Bill getBill(@PathVariable(name="id") Long id)
{
    Bill bill =billRepo.findById(id).get();
    return bill;
}


}
