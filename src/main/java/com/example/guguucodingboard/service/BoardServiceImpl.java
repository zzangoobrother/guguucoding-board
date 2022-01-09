package com.example.guguucodingboard.service;

import com.example.guguucodingboard.dto.BoardDTO;
import com.example.guguucodingboard.entity.Board;
import com.example.guguucodingboard.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class BoardServiceImpl implements BoardService {

  private final BoardRepository boardRepository;

  public BoardServiceImpl(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }

  @Override
  public Long register(BoardDTO boardDTO) {
    log.info(boardDTO);

    Board board = dtoToEntity(boardDTO);
    boardRepository.save(board);
    return board.getBno();
  }
}
