package com.example.gugucodingmovieboard.controller;

import com.example.gugucodingmovieboard.dto.UploadResultDTO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Log4j2
public class UploadController {

  @Value("${com.example.upload.path}")
  private String uploadPath;

  @PostMapping("/uploadAjax")
  public ResponseEntity<List<UploadResultDTO>> uploadFile(MultipartFile[] uploadFiles) {
    List<UploadResultDTO> resultDTOList = new ArrayList<>();

    for (MultipartFile uploadFile : uploadFiles) {
      if (!uploadFile.getContentType().startsWith("image")) {
        log.warn("this file is not image type");
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
      }

      String originalName = uploadFile.getOriginalFilename();
      String fileName = originalName.substring(originalName.lastIndexOf("\\") + 1);
      log.info("fileName : " + fileName);

      String folderPath = makeFolder();
      String uuid = UUID.randomUUID().toString();
      String saveName = uploadPath + File.separator + folderPath + File.separator + uuid + "_" + fileName;
      Path savePath = Paths.get(saveName);

      try {
        uploadFile.transferTo(savePath);
        resultDTOList.add(new UploadResultDTO(fileName, uuid, folderPath));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return new ResponseEntity<>(resultDTOList, HttpStatus.OK);
  }

  private String makeFolder() {
    String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    String folderPath = str.replace("/", File.separator);

    File uploadPathFolder = new File(uploadPath, folderPath);
    if (!uploadPathFolder.exists()) {
      uploadPathFolder.mkdirs();
    }

    return folderPath;
  }
}
