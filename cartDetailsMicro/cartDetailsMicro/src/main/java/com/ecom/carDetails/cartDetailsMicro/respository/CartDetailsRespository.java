package com.ecom.carDetails.cartDetailsMicro.respository;

import com.ecom.carDetails.cartDetailsMicro.entity.Carts;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDetailsRespository extends JpaRepository<Carts, Integer> {

}
