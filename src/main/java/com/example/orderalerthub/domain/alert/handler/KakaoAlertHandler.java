package com.example.orderalerthub.domain.alert.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KakaoAlertHandler implements AlertHandler {

  @Override
  public String getType() {
    return "kakao";
  }

  @Override
  public void send() {
    log.info("=============== 카카오 전송 ===============");
  }
}
