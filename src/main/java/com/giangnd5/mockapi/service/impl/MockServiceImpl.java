package com.giangnd5.mockapi.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.giangnd5.mockapi.response.BaseRes;
import com.giangnd5.mockapi.response.OcrBackRes;
import com.giangnd5.mockapi.response.OcrFrontRes;
import com.giangnd5.mockapi.response.OcrRes;
import com.giangnd5.mockapi.service.MockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class MockServiceImpl implements MockService {

  final ResourceLoader resourceLoader;

  @Override
  public BaseRes<?> ocr(MultipartFile imageFile, String type) {
    String path = "";
    if (type.equals("FRONT")) {
      path = "classpath:mock/ocr_front.json";
    } else if (type.equals("BACK")) {
      path = "classpath:mock/ocr_back.json";
    }
    try {
      Resource resource = resourceLoader.getResource(path);
      File file = resource.getFile();
      ObjectMapper objectMapper = new ObjectMapper();
      OcrRes res;
      if (type.equals("FRONT")) {
        res = objectMapper.readValue(file, OcrFrontRes.class);
      } else {
        res = objectMapper.readValue(file, OcrBackRes.class);
      }
      return BaseRes.ok(res);
    } catch (IOException e) {
      e.printStackTrace();
      return BaseRes.error("IMAGE_SMALL", "Hình ảnh quá bé");
    }
  }
}
