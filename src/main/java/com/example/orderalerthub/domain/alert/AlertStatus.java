package com.example.orderalerthub.domain.alert;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AlertStatus {
  ORDER_RECEIVED("order_received", "주문접수"),
  ORDER_COMPLETED("order_completed", "주문완료"),
  PAYMENT_COMPLETED("payment_completed", "결제완료"),
  PAYMENT_CANCELED("payment_canceled", "결제취소"),
  ORDER_CANCELED("order_canceled", "주문취소");

  private final String code;
  private final String desc;
}
