package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.WeightEntity;

@Repository
public interface WeightRepository extends JpaRepository<WeightEntity, Long> {
	
}
