package com.library.order.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.order.Entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
    
}
