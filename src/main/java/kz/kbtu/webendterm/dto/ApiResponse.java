package kz.kbtu.webendterm.dto;

import org.springframework.http.HttpStatus;

public class ApiResponse<T> {

  private HttpStatus status;

  private T response;

  public ApiResponse(HttpStatus status, T response) {
    this.status = status;
    this.response = response;
  }

  public ApiResponse(HttpStatus status) {
    this.status = status;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public ApiResponse<T> setStatus(HttpStatus status) {
    this.status = status;
    return this;
  }

  public T getResponse() {
    return response;
  }

  public void setResponse(T response) {
    this.response = response;
  }
}
