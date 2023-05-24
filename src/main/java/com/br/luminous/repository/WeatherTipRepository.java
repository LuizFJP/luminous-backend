package com.br.luminous.repository;

import com.br.luminous.entity.User;
import com.br.luminous.entity.WeatherTip;
import com.br.luminous.enums.ClimateType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface WeatherTipRepository extends JpaRepository<WeatherTip, Long> {
    public List<WeatherTip> findAllWeatherTipsByClimate(ClimateType climate);
    public Optional<List<WeatherTip>> findAllByUsers(User user);

    public List<WeatherTip> findByClimateAndIdNotIn(ClimateType climateTypee, Collection<Long> ids);
}
