package com.example.orderalerthub.api.dto.request;

import com.example.orderalerthub.domain.alert.AlertStatus;
import com.example.orderalerthub.domain.alert.AlertTarget;
import java.util.List;
import lombok.Getter;

@Getter
public class AlertRequest {
  private AlertStatus status;
  private List<AlertTarget> target;
  private String orderCode; // 주문번호
}
