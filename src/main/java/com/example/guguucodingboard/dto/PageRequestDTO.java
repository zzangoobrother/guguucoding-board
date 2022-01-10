package com.example.guguucodingboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PageRequestDTO {

  private int page;
  private int size;
  private String type;
  private String keyword;

  public PageRequestDTO() {
    this.page = 1;
    this.size = 10;
  }

  public Pageable getPageable(Sort sort) {
    return PageRequest.of(page - 1, size, sort);
  }
}
