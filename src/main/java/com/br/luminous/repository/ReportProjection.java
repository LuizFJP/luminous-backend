package com.br.luminous.repository;

import java.time.LocalDateTime;
public interface ReportProjection extends TrackProjection{
    LocalDateTime getPeriod();
    String getName();
}
