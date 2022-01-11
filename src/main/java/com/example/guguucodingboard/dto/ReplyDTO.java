package com.example.guguucodingboard.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReplyDTO {

  private Long rno;

  private String text;

  private String replyer;

  private Long bno;

  private LocalDateTime regDate, modDate;
}
