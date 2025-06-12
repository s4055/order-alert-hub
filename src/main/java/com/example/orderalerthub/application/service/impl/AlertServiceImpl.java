package com.example.orderalerthub.application.service.impl;

import com.example.orderalerthub.api.dto.request.AlertRequest;
import com.example.orderalerthub.api.dto.response.AlertResponse;
import com.example.orderalerthub.application.service.AlertService;
import com.example.orderalerthub.common.dto.CommonResponse;
import com.example.orderalerthub.domain.model.OrderMessage;
import com.example.orderalerthub.exception.ErrorCode;
import com.example.orderalerthub.infrastructure.redis.RedisPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AlertServiceImpl implements AlertService {

  private final RedisPublisher redisPublisher;
  private final ObjectMapper objectMapper;

  @Override
  public CommonResponse<AlertResponse> process(AlertRequest request)
      throws JsonProcessingException {
    OrderMessage msg =
        new OrderMessage(request.getOrderCode(), request.getStatus(), request.getTarget());
    redisPublisher.publish("order", objectMapper.writeValueAsString(msg));
    return new CommonResponse<>(ErrorCode.OK.getResultCode(), ErrorCode.OK.getMessage(), null);
  }
}
