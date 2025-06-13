package com.example.orderalerthub.domain.alert.handler;

import com.example.orderalerthub.domain.alert.AlertTarget;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KakaoAlertHandler implements AlertHandler {

  @Override
  public AlertTarget getType() {
    return AlertTarget.KAKAO;
  }

  @Override
  public void send(String description) {
    log.info("=============== 카카오 전송 => {} ===============", description);
  }
}
