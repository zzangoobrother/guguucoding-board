package com.example.guguucodingboard.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.guguucodingboard.dto.BoardDTO;
import com.example.guguucodingboard.dto.PageRequestDTO;
import com.example.guguucodingboard.dto.PageResultDTO;
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

  @Test
  void testList() {
    PageRequestDTO pageRequestDTO = new PageRequestDTO();
    PageResultDTO<BoardDTO, Object[]> result = boardService.getList(pageRequestDTO);

    for (BoardDTO boardDTO : result.getDtoList()) {
      System.out.println(boardDTO);
    }
  }

  @Test
  void testGet() {
    Long bno = 100L;
    BoardDTO boardDTO = boardService.get(bno);
    System.out.println(boardDTO);
  }

  @Test
  void testRemove() {
    Long bno = 1L;
    boardService.removeWithReplies(bno);
  }
}