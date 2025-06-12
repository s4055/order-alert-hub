package com.example.orderalerthub.domain.alert.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SlackAlertHandler implements AlertHandler {

  @Override
  public String getType() {
    return "slack";
  }

  @Override
  public void send() {
    log.info("=============== 슬랙 전송 ===============");
  }
}
