package com.example.gugucodingmovieboard.dto;

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
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

  private Long reviewnum;

  private Long mno;

  private Long mid;

  private String nickname;

  private String email;

  private int grade;

  private String text;

  private LocalDateTime regDate, modDate;
}
