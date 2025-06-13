package com.example.orderalerthub.domain.model;

import com.example.orderalerthub.domain.alert.AlertStatus;
import com.example.orderalerthub.domain.alert.AlertTarget;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderMessage {
  private AlertStatus status;
  private List<AlertTarget> target;
  private String orderCode; // 주문번호
}
