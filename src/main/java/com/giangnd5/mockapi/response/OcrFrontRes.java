package com.giangnd5.mockapi.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OcrFrontRes implements OcrRes {
  String id;
  String name;
  String dob;
  String gender;
  String nationality;
  String origin;
  String residence;
  String expiry;
}
