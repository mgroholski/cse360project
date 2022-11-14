package com.squad.project.spring.Repositories;

//import org.springframework.data.jpa.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;


import com.squad.project.spring.Classes.*;
public interface OrderRepository extends JpaRepository<Order, Long>
{
}