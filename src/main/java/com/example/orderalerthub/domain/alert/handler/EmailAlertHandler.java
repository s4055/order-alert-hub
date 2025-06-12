package com.example.orderalerthub.domain.alert.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailAlertHandler implements AlertHandler {

  @Override
  public String getType() {
    return "email";
  }

  @Override
  public void send() {
    log.info("=============== 이메일 전송 ===============");
  }
}
