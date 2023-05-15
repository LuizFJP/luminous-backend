package com.br.luminous.repository;

import com.br.luminous.entity.WeatherTip;
import com.br.luminous.enums.ClimateType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeatherTipRepository extends JpaRepository<WeatherTip, Long> {
    public List<WeatherTip> findAllWeatherTipsByClimate(ClimateType climate);
}
