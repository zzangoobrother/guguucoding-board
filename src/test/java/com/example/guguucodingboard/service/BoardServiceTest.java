package com.example.guguucodingboard.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.guguucodingboard.dto.BoardDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardServiceTest {

  @Autowired
  private BoardService boardService;

  @Test
  void testRegister() {
    BoardDTO dto = BoardDTO.builder()
        .title("Test.")
        .content("Test...")
        .writerEmail("user55@aaa.com")
        .build();

    Long bno = boardService.register(dto);
  }
}