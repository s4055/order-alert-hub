package com.example.orderalerthub.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface HubService {
  void failHub(String orderCode) throws JsonProcessingException;
}
