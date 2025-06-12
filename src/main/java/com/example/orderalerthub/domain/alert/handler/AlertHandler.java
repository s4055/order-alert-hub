package com.example.orderalerthub.domain.alert.handler;

public interface AlertHandler {
  String getType();

  void send();
}
