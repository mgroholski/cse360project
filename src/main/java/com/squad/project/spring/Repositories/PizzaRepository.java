package com.squad.project.spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;
import com.squad.project.spring.Classes.*;

public interface PizzaRepository extends JpaRepository<Pizza, Long>
{
}