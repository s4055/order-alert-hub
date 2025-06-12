package com.example.orderalerthub.api.dto.request;

import java.util.List;
import lombok.Getter;

@Getter
public class AlertRequest {
  private String status; // 주문접수, 주문완료, 결제완료, 결제취소, 주문취소
  private List<String> target; // 카카오, 이메일, 슬랙
  private String orderCode; // 주문번호
}
