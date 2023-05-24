package com.br.luminous.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiResponse<T> {
    @JsonProperty("data")
    private T data;
    @JsonProperty("errorMessage")
    private String errorMessage;
    @JsonProperty("successMessage")
    private String successMessage;
}
