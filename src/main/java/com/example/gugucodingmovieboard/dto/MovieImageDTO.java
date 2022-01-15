package com.example.gugucodingmovieboard.dto;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieImageDTO {

  private String uuid;

  private String imgName;

  private String path;

  public String getImageURL() {
    try {
      return URLEncoder.encode(path + "/" + uuid + "_" + imgName, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    return "";
  }

  public String getThumbnailURL() {
    try {
      return URLEncoder.encode(path + "/s_" + uuid + "_" + imgName, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    return "";
  }
}
