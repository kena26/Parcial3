package com.Parcial3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Parcial3.entity.Resena;



@Repository
public interface ResenaRepository extends JpaRepository<Resena, Long> {
    List<Resena> findAll();

}
