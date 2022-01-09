package com.example.guguucodingboard.service;

import com.example.guguucodingboard.dto.BoardDTO;
import com.example.guguucodingboard.entity.Board;
import com.example.guguucodingboard.entity.Member;

public interface BoardService {

  Long register(BoardDTO boardDTO);

  default Board dtoToEntity(BoardDTO boardDTO) {
    Member member = Member.builder().email(boardDTO.getWriterEmail()).build();

    Board board = Board.builder()
        .bno(boardDTO.getBno())
        .title(boardDTO.getTitle())
        .content(boardDTO.getContent())
        .writer(member)
        .build();

    return board;
  }
}
