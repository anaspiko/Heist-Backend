package com.task.heistback.repository;

import com.task.heistback.model.Heist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeistRepository extends JpaRepository<Heist, Long> {}
