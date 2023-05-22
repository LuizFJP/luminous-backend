package com.br.luminous.service;

import com.br.luminous.models.ApiResponse;
import org.springframework.stereotype.Service;

@Service
public class ApiResponseService {
    public <T> ApiResponse<T> createErrorResponse(String errorMessage) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setErrorMessage(errorMessage);
        return response;
    }
    public <T> ApiResponse<T> createSuccessResponse(T data, String successMessage) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setData(data);
        response.setSuccessMessage(successMessage);
        return response;
    }
}
