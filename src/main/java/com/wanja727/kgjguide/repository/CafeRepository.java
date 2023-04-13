package com.wanja727.kgjguide.repository;

import com.wanja727.kgjguide.entity.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CafeRepository extends JpaRepository<Cafe, String>, QuerydslPredicateExecutor<Cafe>, CafeRepositoryCustom {
}
