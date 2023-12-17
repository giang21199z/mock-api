package com.giangnd5.mockapi.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OcrBackRes implements OcrRes{
  String identification;
  String issueDate;
  String issuePlace;
  String signer;
  String MRZ1;
  String MRZ2;
  String MRZ3;
}
