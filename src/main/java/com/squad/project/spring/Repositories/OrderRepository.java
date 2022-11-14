package com.squad.project.spring.Repositories;

//import org.springframework.data.jpa.repository.query.Modifying;
import com.squad.project.spring.Enum.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;


import com.squad.project.spring.Classes.*;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long>{
    @Query("SELECT o FROM Order o WHERE o.orderStatus = ?1")
    List<Order> getAllByStatus(OrderStatus order);
}