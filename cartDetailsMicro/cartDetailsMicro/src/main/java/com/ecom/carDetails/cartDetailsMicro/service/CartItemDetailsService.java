package com.ecom.carDetails.cartDetailsMicro.service;

import com.ecom.carDetails.cartDetailsMicro.entity.Carts;
import com.ecom.carDetails.cartDetailsMicro.entity.cartItems;
import com.ecom.carDetails.cartDetailsMicro.kafkaservices.CartItemsProducerService;
import com.ecom.carDetails.cartDetailsMicro.respository.CartDetailsRespository;
import com.ecom.carDetails.cartDetailsMicro.respository.CartItemDetailsRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CartItemDetailsService {

    @Autowired
    CartItemDetailsRespository cartItemDetailsRespository;

    private final CartItemsProducerService cartItemsProducerService;

    @Autowired
    public CartItemDetailsService(CartItemsProducerService cartItemsProducerService) {
        this.cartItemsProducerService = cartItemsProducerService;
    }

    public cartItems saveCart(cartItems cartItems){
      return cartItemDetailsRespository.save(cartItems);
    }

    public List<cartItems> getCartItemsByUserId(Integer userId) {
     List<cartItems> items = cartItemDetailsRespository.findByCartUserId(userId);

        cartItemsProducerService.sendCartItem(items);
        return items;
    }

    /*public Carts getCartById(Integer id) {
        return cartDetailsRespository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Ivalid User Id");
        });
    }

    public  Carts updateUserById(Integer id, Carts cartDetails) {
        Carts carts =   cartDetailsRespository.findById(id).orElseThrow(()-> {
            return new RuntimeException("Ivalid User Id");
        });

        carts.setUser(cartDetails.getUser());
        carts.setItems(cartDetails.getItems());
        carts.setStatus(cartDetails.getStatus());
        carts.setUpdatedAt(new Date());
        cartDetailsRespository.save(carts);
        return carts;
    }

    public void deleteById(Integer id) {
    cartDetailsRespository.deleteById(id);
    }*/


}
