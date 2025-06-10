package com.example.orderalerthub.controller;

import com.example.orderalerthub.service.HubService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HubController {

  private final HubService hubService;

  @PostMapping("/fail/hub/{orderCode}")
  public void failHub(@PathVariable String orderCode) throws JsonProcessingException {
    hubService.failHub(orderCode);
  }
}
