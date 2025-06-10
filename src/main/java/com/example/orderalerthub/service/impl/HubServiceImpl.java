package com.example.orderalerthub.service.impl;

import com.example.orderalerthub.dto.OrderFailedMessage;
import com.example.orderalerthub.service.HubService;
import com.example.orderalerthub.service.RedisPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class HubServiceImpl implements HubService {

  private final RedisPublisher redisPublisher;
  private final ObjectMapper objectMapper;

  @Override
  public void failHub(String orderCode) throws JsonProcessingException {
    OrderFailedMessage msg = new OrderFailedMessage(orderCode, "결제 오류", LocalDateTime.now());
    redisPublisher.publish("order", objectMapper.writeValueAsString(msg));
  }
}
