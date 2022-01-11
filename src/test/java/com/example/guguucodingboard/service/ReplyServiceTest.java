package com.example.guguucodingboard.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.guguucodingboard.dto.ReplyDTO;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReplyServiceTest {

  @Autowired
  private ReplyService replyService;

  @Test
  void testGetList() {
    Long bno = 100L;
    List<ReplyDTO> replyDTOList = replyService.getList(bno);
    replyDTOList.forEach(System.out::println);
  }
}