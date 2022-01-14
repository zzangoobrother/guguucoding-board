package com.example.gugucodingmovieboard.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Log4j2
public class UploadController {

  @Value("${com.example.upload.path}")
  private String uploadPath;

  @PostMapping("/uploadAjax")
  public void uploadFile(MultipartFile[] uploadFiles) {
    for (MultipartFile uploadFile : uploadFiles) {
      String originalName = uploadFile.getOriginalFilename();
      String fileName = originalName.substring(originalName.lastIndexOf("\\") + 1);

      log.info("fileName : " + fileName);
    }
  }
}
