package com.squad.project.spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

import com.squad.project.spring.Classes.*;

public interface StudentRepository extends JpaRepository<Student, Long>
{ }