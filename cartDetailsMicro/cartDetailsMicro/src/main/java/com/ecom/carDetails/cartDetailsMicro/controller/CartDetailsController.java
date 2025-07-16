package com.ecom.carDetails.cartDetailsMicro.controller;

import com.ecom.carDetails.cartDetailsMicro.entity.Carts;
import com.ecom.carDetails.cartDetailsMicro.service.CartDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartDetailsController
{

    @Autowired
    CartDetailsService cartDetailsService;

    @PostMapping("/save")
    public Carts saveCart(@RequestBody  Carts cart) {

    return cartDetailsService.saveCart(cart);

    }

    @GetMapping("/{id}")
    public Carts getCartById(@PathVariable Integer id){
     return cartDetailsService.getCartById(id);
    }

    @PutMapping("/{id}")
    public Carts updateUserById(@PathVariable Integer id , @RequestBody Carts cartDetails){

        return cartDetailsService.updateUserById(id,cartDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Integer id){

        cartDetailsService.deleteById(id);
    }
}
