package com.example.gugucodingmovieboard.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
public class MovieDTO {

  private Long mno;

  private String title;

  @Builder.Default
  private List<MovieImageDTO> imageDTOList = new ArrayList<>();

  private double avg;

  private int reviewCnt;

  private LocalDateTime regDate;

  private LocalDateTime modDate;
}
