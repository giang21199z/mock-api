package com.giangnd5.mockapi.service;

import com.giangnd5.mockapi.response.BaseRes;
import com.giangnd5.mockapi.response.OcrRes;
import org.springframework.web.multipart.MultipartFile;

public interface MockService {
  BaseRes<?> ocr(MultipartFile imageFile, String type);
}
