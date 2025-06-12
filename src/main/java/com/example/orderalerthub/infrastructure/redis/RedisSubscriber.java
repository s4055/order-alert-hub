package com.example.orderalerthub.infrastructure.redis;

import com.example.orderalerthub.domain.alert.handler.AlertHandler;
import com.example.orderalerthub.domain.model.OrderMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RedisSubscriber {

  private final ObjectMapper objectMapper;
  private final List<AlertHandler> handlers;

  public void onMessage(String message, String channel) throws JsonProcessingException {
    log.info("=============== 구독 {} ===============", channel);
    OrderMessage msg = objectMapper.readValue(message, OrderMessage.class);
    for (String target : msg.getTarget()) {
      AlertHandler handler =
          handlers.stream()
              .filter(h -> h.getType().equalsIgnoreCase(target))
              .findFirst()
              .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 알림 대상: " + target));

      handler.send();
    }
  }
}
