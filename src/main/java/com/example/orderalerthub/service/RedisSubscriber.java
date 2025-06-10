package com.example.orderalerthub.service;

import com.example.orderalerthub.dto.OrderFailedMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisSubscriber {

  private final AlertService alertService;
  private final SlackService slackService;
  private final LogService logService;
  private final ObjectMapper objectMapper;

  public void onMessage(String message, String channel) throws JsonProcessingException {
    OrderFailedMessage msg = objectMapper.readValue(message, OrderFailedMessage.class);
    alertService.sendAlert(msg);
    slackService.sendSlack(msg);
    logService.saveLog(msg);
  }
}
