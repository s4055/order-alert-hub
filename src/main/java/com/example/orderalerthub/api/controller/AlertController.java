package com.example.orderalerthub.api.controller;

import com.example.orderalerthub.api.dto.request.AlertRequest;
import com.example.orderalerthub.api.dto.response.AlertResponse;
import com.example.orderalerthub.application.service.AlertService;
import com.example.orderalerthub.common.dto.CommonResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/alert")
public class AlertController {

  private final AlertService alertService;

  @PostMapping
  public ResponseEntity<CommonResponse<AlertResponse>> handleAlert(
      @RequestBody AlertRequest request) throws JsonProcessingException {
    CommonResponse<AlertResponse> response = alertService.process(request);
    return ResponseEntity.ok().body(response);
  }
}
