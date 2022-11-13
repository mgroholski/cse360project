//package com.squad.project.spring.Repositories;
//
//import org.springframework.data.jpa.repository.JpaRepository;
////import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//import java.util.Optional;
//import java.util.List;
//import com.squad.project.spring.Classes.*;
//
//@Repository
//public interface PizzaRepository extends JpaRepository<Pizza, Long>
//{
//    //@Query("SELECT p from PIZZA p where p.id = :id")
//    Optional<Pizza> findById(Long id);
//
//
//    @Query(value = "UPDATE PIZZA p SET p.type = :type, p.piztTops =  :piztTops, cost = :cost WHERE p.id = :id RETURNING *", nativeQuery = true)
//    Optional<Pizza> updatePizza(@Param("type") String pizType, @Param("piztTops") String[] piztTops, @Param("cost") double cost);
//}