package com.example.guguucodingboard.repository;

import com.example.guguucodingboard.entity.Board;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Long> {

  @Query("select b, w from Board b left join b.writer w where b.bno =:bno")
  Object getBoardWithWriter(@Param("bno") Long bno);

  @Query("select b, r from Board b left join Reply r on r.board = b where b.bno = :bno")
  List<Object[]> getBoardWithReply(@Param("bno") Long bno);
}
