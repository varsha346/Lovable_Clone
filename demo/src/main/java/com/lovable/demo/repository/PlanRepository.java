package com.lovable.demo.repository;

import com.lovable.demo.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PlanRepository extends JpaRepository<Plan,Long> {

    Optional<Plan> findByrazorPriceId(String id);
}

