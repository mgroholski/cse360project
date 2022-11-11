package com.squad.project.spring.Repositories;

import org.springframework.data.jpa.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import lombok.Data;
import java.util.Optional;

import com.squad.project.spring.Classes.*;

public interface OrderRepository extends JpaRepository<Order, Long>  
{
    @Query("SELECT o from ORDER o WHERE o.id = ?1")
    Order findById(Long id);
    //TODO: Update order
    @Modifying
    @Query("UPDATE ORDER o SET o.status = ?1 where o.id = ?2")
    String setStatusForOrder(String status, Long id);
}