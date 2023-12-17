package com.giangnd5.mockapi.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseRes<T> {
  String code;
  String message;
  T data;

  public static <T> BaseRes<T> ok(T data) {
    BaseRes<T> baseRes = new BaseRes<>();
    baseRes.code = "00";
    baseRes.data = data;
    baseRes.message = "success";
    return baseRes;
  }

  public static <T> BaseRes<T> error(String code, String message) {
    BaseRes<T> baseRes = new BaseRes<>();
    baseRes.code = code;
    baseRes.data = null;
    baseRes.message = message;
    return baseRes;
  }
}
