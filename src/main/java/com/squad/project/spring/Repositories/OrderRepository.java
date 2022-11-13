//package com.squad.project.spring.Repositories;
//
////import org.springframework.data.jpa.repository.query.Modifying;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//import lombok.Data;
//import java.util.List;
//import java.util.Optional;
//
//import com.squad.project.spring.Classes.*;
//@Repository
//public interface OrderRepository extends JpaRepository<Order, Long>
//{
//    @Query("SELECT o FROM ORDER o WHERE o.id = :id")
//    Optional<Order> findOrdersById(@Param("id") Long id);
//    //TODO: Update order
//
//    @Query("UPDATE ORDER o SET o.status = ?1 where o.id = ?2")
//    String setStatusForOrder(String status, Long id);
//}