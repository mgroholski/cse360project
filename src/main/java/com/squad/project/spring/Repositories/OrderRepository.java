package com.squad.project.spring.Repositories;

//import org.springframework.data.jpa.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;


import com.squad.project.spring.Classes.*;
public interface OrderRepository extends JpaRepository<Order, Long>
{
//    @Query("SELECT o FROM ORDER o WHERE o.id = :id")
//    Optional<Order> findOrdersById(@Param("id") Long id);
//    //TODO: Update order
//
//    @Query("UPDATE ORDER o SET o.status = ?1 where o.id = ?2")
//    String setStatusForOrder(String status, Long id);
}