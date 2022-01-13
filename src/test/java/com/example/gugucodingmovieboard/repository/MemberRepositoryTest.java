package com.example.gugucodingmovieboard.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.gugucodingmovieboard.entity.Member;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberRepositoryTest {

  @Autowired
  private MemberRepository memberRepository;

  @Test
  void insertMembers() {
    IntStream.rangeClosed(1, 100).forEach(i -> {
      Member member = Member.builder()
          .email("r" + i + "@zerock.org")
          .pw("1111")
          .nickname("reviewer" + i)
          .build();

      memberRepository.save(member);
    });
  }
}