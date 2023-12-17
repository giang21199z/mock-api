package com.giangnd5.mockapi.controller;

import com.giangnd5.mockapi.response.BaseRes;
import com.giangnd5.mockapi.response.OcrRes;
import com.giangnd5.mockapi.service.MockService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/ocr")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MockController {

  final MockService mockService;

  @PostMapping
  public BaseRes<?> ocr(@RequestParam("imageFile") MultipartFile imageFile, @RequestParam("type") String type) {
    return mockService.ocr(imageFile, type);
  }
}
