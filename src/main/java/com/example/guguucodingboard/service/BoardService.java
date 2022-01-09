package com.example.guguucodingboard.service;

import com.example.guguucodingboard.dto.BoardDTO;
import com.example.guguucodingboard.dto.PageRequestDTO;
import com.example.guguucodingboard.dto.PageResultDTO;
import com.example.guguucodingboard.entity.Board;
import com.example.guguucodingboard.entity.Member;

public interface BoardService {

  Long register(BoardDTO boardDTO);

  PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);

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

  default BoardDTO entityToDTO(Board board, Member member, Long replyCount) {
    BoardDTO boardDTO = BoardDTO.builder()
        .bno(board.getBno())
        .title(board.getTitle())
        .content(board.getContent())
        .regDate(board.getRegDate())
        .modDate(board.getModDate())
        .writerEmail(member.getEmail())
        .writerName(member.getName())
        .replyCount(replyCount.intValue())
        .build();

    return boardDTO;
  }
}
