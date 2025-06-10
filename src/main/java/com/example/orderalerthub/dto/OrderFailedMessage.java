package com.example.orderalerthub.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderFailedMessage {
  private String orderCode;
  private String reason;
  private LocalDateTime failedAt;

  public String toString() {
    return String.format(
        "[orderCode => %s] [reason => %s] [failAt => %s]",
        this.orderCode, this.reason, this.failedAt.toString());
  }
}
