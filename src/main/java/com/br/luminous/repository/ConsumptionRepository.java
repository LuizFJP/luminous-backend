package com.br.luminous.repository;

import com.br.luminous.entity.Consumption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumptionRepository extends JpaRepository<Consumption, Long> {}
