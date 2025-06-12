package com.example.orderalerthub.infrastructure.redis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class RedisPublisher {

  private final RedisTemplate<String, Object> redisTemplate;

  public void publish(String channel, String message) {
    redisTemplate.convertAndSend(channel, message);
  }
}
