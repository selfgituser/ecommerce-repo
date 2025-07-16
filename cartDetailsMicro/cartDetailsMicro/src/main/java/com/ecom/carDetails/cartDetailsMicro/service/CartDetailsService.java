package com.ecom.carDetails.cartDetailsMicro.service;

import com.ecom.carDetails.cartDetailsMicro.entity.Carts;
import com.ecom.carDetails.cartDetailsMicro.respository.CartDetailsRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CartDetailsService {

    @Autowired
    CartDetailsRespository cartDetailsRespository;

    public Carts saveCart(Carts cart){
      return cartDetailsRespository.save(cart);
    }


    public Carts getCartById(Integer id) {
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
    }


}
