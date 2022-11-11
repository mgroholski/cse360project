package com.squad.project.spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

import com.squad.project.spring.Classes.*;


public interface PizzaRepository extends JpaRepository<Pizza, Long>
{
    @Query("SELECT p from PIZZA p where p.id = ?1")
    Pizza findById(Long id);

    @Modifying
    @Query("UPDATE PIZZA p set p.piztTops = ?1 where p.id = ?2")
    List<String> setPizzaTopsFor(List<String> pizTopList, Long id);
}