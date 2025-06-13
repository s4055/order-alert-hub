package com.example.orderalerthub.domain.alert.handler;

import com.example.orderalerthub.domain.alert.AlertTarget;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SlackAlertHandler implements AlertHandler {

  @Override
  public AlertTarget getType() {
    return AlertTarget.SLACK;
  }

  @Override
  public void send() {
    log.info("=============== 슬랙 전송 ===============");
  }
}
