package com.example.guguucodingboard.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.guguucodingboard.entity.Board;
import com.example.guguucodingboard.entity.Member;
import java.util.Optional;
import java.util.stream.IntStream;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardRepositoryTest {

  @Autowired
  private BoardRepository boardRepository;

  @Test
  void insertBoard() {
    IntStream.rangeClosed(1, 100).forEach(i -> {
      Member member = Member.builder().email("user" + i + "@aaa.com").build();

      Board board = Board.builder()
          .title("Title..." + i)
          .content("Content...." + i)
          .writer(member)
          .build();

      boardRepository.save(board);
    });
  }

  @Test
  @Transactional
  void testRead1() {
    Optional<Board> result = boardRepository.findById(100L);
    Board board = result.get();
    System.out.println(board);
    System.out.println(board.getWriter());
  }
}