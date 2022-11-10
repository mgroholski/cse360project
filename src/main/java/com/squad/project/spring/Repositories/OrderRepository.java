package com.squad.project.spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import lombok.Data;
import java.util.Optional;

import com.squad.project.spring.Classes.*;

public interface OrderRepository extends JpaRepository<Order, Long>  
{
    //TODO: Create order
    //TODO: Update order
}