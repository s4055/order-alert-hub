package com.example.orderalerthub.domain.alert.handler;

import com.example.orderalerthub.domain.alert.AlertTarget;

public interface AlertHandler {
  AlertTarget getType();

  void send();
}
