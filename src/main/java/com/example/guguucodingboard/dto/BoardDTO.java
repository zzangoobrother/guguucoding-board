package com.example.guguucodingboard.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

  private Long bno;

  private String title;

  private String content;

  private String writerEmail;

  private String writerName;

  private LocalDateTime regDate;

  private LocalDateTime modDate;

  private int replyCount;
}
