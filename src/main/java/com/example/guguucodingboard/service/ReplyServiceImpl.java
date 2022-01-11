package com.example.guguucodingboard.service;

import com.example.guguucodingboard.dto.ReplyDTO;
import com.example.guguucodingboard.entity.Board;
import com.example.guguucodingboard.entity.Reply;
import com.example.guguucodingboard.repository.ReplyRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {

  private final ReplyRepository replyRepository;

  public ReplyServiceImpl(ReplyRepository replyRepository) {
    this.replyRepository = replyRepository;
  }

  @Override
  public Long register(ReplyDTO replyDTO) {
    Reply reply = dtoToEntity(replyDTO);
    replyRepository.save(reply);

    return reply.getRno();
  }

  @Override
  public List<ReplyDTO> getList(Long bno) {
    List<Reply> result = replyRepository
        .getRepliesByBoardOrderByRno(Board.builder().bno(bno).build());

    return result.stream().map(this::entityToDTO).collect(Collectors.toList());
  }

  @Override
  public void modify(ReplyDTO replyDTO) {
    Reply reply = dtoToEntity(replyDTO);
    replyRepository.save(reply);
  }

  @Override
  public void remove(Long rno) {
    replyRepository.deleteById(rno);
  }
}
