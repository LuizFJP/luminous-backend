package com.br.luminous.repository;

import com.br.luminous.entity.TariffFlag;
import com.br.luminous.enums.FlagType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TariffFlagRepository extends JpaRepository<TariffFlag, Long> {}
