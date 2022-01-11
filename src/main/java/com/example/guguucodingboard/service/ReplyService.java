package com.example.guguucodingboard.service;

import com.example.guguucodingboard.dto.ReplyDTO;
import com.example.guguucodingboard.entity.Board;
import com.example.guguucodingboard.entity.Reply;
import java.util.List;

public interface ReplyService {

  Long register(ReplyDTO replyDTO);

  List<ReplyDTO> getList(Long bno);

  void modify(ReplyDTO replyDTO);

  void remove(Long rno);

  default Reply dtoToEntity(ReplyDTO replyDTO) {
    Board board = Board.builder().bno(replyDTO.getBno()).build();

    return Reply.builder()
        .rno(replyDTO.getRno())
        .text(replyDTO.getText())
        .board(board)
        .build();
  }

  default ReplyDTO entityToDTO(Reply reply) {

    return ReplyDTO.builder()
        .rno(reply.getRno())
        .text(reply.getText())
        .replyer(reply.getReplyer())
        .regDate(reply.getRegDate())
        .modDate(reply.getModDate())
        .build();
  }
}
