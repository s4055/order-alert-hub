package com.example.orderalerthub.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
  OK("0000", "성공", HttpStatus.OK),
  BAD_REQUEST("0001", "잘못된 요청 데이터", HttpStatus.BAD_REQUEST),
  INTERNAL_SERVER_ERROR("9999", "서버 에러", HttpStatus.INTERNAL_SERVER_ERROR),
  ;

  private final String resultCode;
  private final String message;
  private final HttpStatus httpStatus;
}
