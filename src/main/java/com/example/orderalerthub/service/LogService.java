package com.example.orderalerthub.service;

import com.example.orderalerthub.dto.OrderFailedMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LogService {

  public void saveLog(OrderFailedMessage msg) {
    log.info("log => {}", msg.toString());
  }
}
