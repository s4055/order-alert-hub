package com.example.orderalerthub.domain.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderMessage {
  private String status; // 주문접수, 주문완료, 결제완료, 결제취소, 주문취소
  private String orderCode; // 주문번호
  private List<String> target; // 카카오, 이메일, 슬랙
}
