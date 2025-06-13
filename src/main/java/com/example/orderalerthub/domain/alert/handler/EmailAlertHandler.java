package com.example.orderalerthub.domain.alert.handler;

import com.example.orderalerthub.domain.alert.AlertTarget;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailAlertHandler implements AlertHandler {

  @Override
  public AlertTarget getType() {
    return AlertTarget.EMAIL;
  }

  @Override
  public void send(String description) {
    log.info("=============== 이메일 전송 => {} ===============", description);
  }
}
