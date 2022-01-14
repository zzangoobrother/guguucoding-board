package com.example.gugucodingmovieboard.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.gugucodingmovieboard.entity.Member;
import java.util.stream.IntStream;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
class MemberRepositoryTest {

  @Autowired
  private MemberRepository memberRepository;

  @Autowired
  private ReviewRepository reviewRepository;

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

  @Test
  @Transactional
  @Commit
  void testDeleteMember(){
    Long mid = 1L;

    Member member = Member.builder().mid(mid).build();

    reviewRepository.deleteByMember(member);
    memberRepository.deleteById(mid);
  }
}