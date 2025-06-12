package com.example.orderalerthub.exception;

import com.example.orderalerthub.common.dto.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackages = "com.example.orderalerthub")
public class GlobalExceptionHandler {

  /**
   * 커스텀 예외 처리
   *
   * @param e CustomException
   * @return response entity
   */
  @ExceptionHandler(CustomException.class)
  public ResponseEntity<CommonResponse<?>> handleCustomException(CustomException e) {
    printRestControllerException(e);
    CommonResponse<?> errorResponse =
        new CommonResponse<>(e.getErrorCode(), e.getErrorMessage(), null);
    return ResponseEntity.status(e.getErrorHttpStatus()).body(errorResponse);
  }

  /**
   * 요청 데이터 예외 처리
   *
   * @param e MethodArgumentNotValidException
   * @return response entity
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<CommonResponse<?>> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException e) {
    printRestControllerException(e);
    ErrorCode errorCode = ErrorCode.BAD_REQUEST;
    CommonResponse<?> errorResponse =
        new CommonResponse<>(errorCode.getResultCode(), errorCode.getMessage(), null);
    return ResponseEntity.status(errorCode.getHttpStatus()).body(errorResponse);
  }

  /**
   * 바인딩 에외 처리
   *
   * @param e BindException
   * @return response entity
   */
  @ExceptionHandler(BindException.class)
  public ResponseEntity<CommonResponse<?>> handleBindException(BindException e) {
    printRestControllerException(e);
    ErrorCode errorCode = ErrorCode.BAD_REQUEST;
    CommonResponse<?> errorResponse =
        new CommonResponse<>(errorCode.getResultCode(), errorCode.getMessage(), null);
    return ResponseEntity.status(errorCode.getHttpStatus()).body(errorResponse);
  }

  /**
   * 요청 데이터 예외 처리
   *
   * @param e HttpMessageNotReadableException
   * @return response entity
   */
  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<CommonResponse<?>> handleHttpMessageNotReadableException(
      HttpMessageNotReadableException e) {
    printRestControllerException(e);
    ErrorCode errorCode = ErrorCode.BAD_REQUEST;
    CommonResponse<?> errorResponse =
        new CommonResponse<>(errorCode.getResultCode(), errorCode.getMessage(), null);
    return ResponseEntity.status(errorCode.getHttpStatus()).body(errorResponse);
  }

  /**
   * 기타 예외 처리
   *
   * @param e Exception
   * @return response entity
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<CommonResponse<?>> handleGlobalException(Exception e) {
    printRestControllerException(e);
    ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
    CommonResponse<?> errorResponse =
        new CommonResponse<>(errorCode.getResultCode(), errorCode.getMessage(), null);
    return ResponseEntity.status(errorCode.getHttpStatus()).body(errorResponse);
  }

  /** 공통 예외 로그 출력 */
  private void printRestControllerException(Exception e) {
    log.error("Exception Occurred ", e);
  }
}
