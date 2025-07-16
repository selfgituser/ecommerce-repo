package com.ecom.carDetails.cartDetailsMicro.respository;

import com.ecom.carDetails.cartDetailsMicro.entity.cartItems;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartItemDetailsRespository extends JpaRepository<cartItems, Integer> {
    /*@Query("SELECT ci FROM cartItems ci WHERE ci.cart.user.id = :userId")
    List<cartItems> findCartItemsByUserId(@Param("userId") Integer userId);*/

    List<cartItems> findByCartUserId(Integer userId);
}
