package com.example.orderalerthub.application.service;

import com.example.orderalerthub.api.dto.request.AlertRequest;
import com.example.orderalerthub.api.dto.response.AlertResponse;
import com.example.orderalerthub.common.dto.CommonResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface AlertService {
  CommonResponse<AlertResponse> process(AlertRequest request) throws JsonProcessingException;
}
