package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BuyNowController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/buynow")
    public String buyProduct(@RequestParam Long productID) {
        Optional<Product> optionalProduct = productRepository.findById(productID);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            if (product.getInv() > 0) {
                product.setInv(product.getInv() - 1);
                productRepository.save(product);
                return "redirect:/purchaseSuccess";
            }
        }

        return "redirect:/purchaseError";
    }

    @GetMapping("/purchaseSuccess")
    public String showPurchaseSuccessPage() {
        return "purchaseSuccess";
    }

    @GetMapping("/purchaseError")
    public String showPurchaseErrorPage() {
        return "purchaseError";
    }

}