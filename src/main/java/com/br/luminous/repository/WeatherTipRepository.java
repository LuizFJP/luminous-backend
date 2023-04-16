package com.br.luminous.repository;

import com.br.luminous.entity.WeatherTips;
import com.br.luminous.enums.ClimateType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeatherTipRepository extends JpaRepository<WeatherTips, Long> {
    public List<WeatherTips> findAllWeatherTipsByClimate(ClimateType climate);
}
