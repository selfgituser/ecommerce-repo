package com.ecom.carDetails.cartDetailsMicro.controller;

import com.ecom.carDetails.cartDetailsMicro.entity.Carts;
import com.ecom.carDetails.cartDetailsMicro.entity.cartItems;
import com.ecom.carDetails.cartDetailsMicro.service.CartDetailsService;
import com.ecom.carDetails.cartDetailsMicro.service.CartItemDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartitems")
public class CartItemsDetailsController
{

    @Autowired
    CartItemDetailsService cartItemDetailsService;

    @PostMapping("/save")
    public cartItems saveCartItems(@RequestBody  cartItems cartItems) {

    return cartItemDetailsService.saveCart(cartItems);

    }

    @GetMapping("/{userId}")
    public List<cartItems> getCartItemsByUserId(@PathVariable Integer userId) {
        System.out.println("In User service method");

        return cartItemDetailsService.getCartItemsByUserId(userId);
    }



   /* @GetMapping("/{id}")
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
    }*/
}
