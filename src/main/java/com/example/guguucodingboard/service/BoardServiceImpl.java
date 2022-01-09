package com.example.guguucodingboard.service;

import com.example.guguucodingboard.dto.BoardDTO;
import com.example.guguucodingboard.dto.PageRequestDTO;
import com.example.guguucodingboard.dto.PageResultDTO;
import com.example.guguucodingboard.entity.Board;
import com.example.guguucodingboard.entity.Member;
import com.example.guguucodingboard.repository.BoardRepository;
import java.util.function.Function;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
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

  @Override
  public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
    log.info(pageRequestDTO);
    Function<Object[], BoardDTO> fn = (en -> entityToDTO((Board) en[0], (Member) en[1], (Long) en[2]));

    Page<Object[]> result = boardRepository.getBoardWithReplyCount(pageRequestDTO.getPageable(Sort.by("bno").descending()));
    return new PageResultDTO<>(result, fn);
  }
}
