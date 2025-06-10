package com.example.orderalerthub.service;

import com.example.orderalerthub.dto.OrderFailedMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SlackService {

  public void sendSlack(OrderFailedMessage msg) {
    log.info("slack => {}", msg.toString());
  }
}
