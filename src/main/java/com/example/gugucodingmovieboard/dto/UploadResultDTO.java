package com.example.gugucodingmovieboard.dto;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class UploadResultDTO implements Serializable {

  private String fileName;
  private String uuid;
  private String folderPath;

  public String getImageURL() {
    try {
      return URLEncoder.encode(folderPath + "/" + uuid + "_" + fileName, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    return "";
  }
}
