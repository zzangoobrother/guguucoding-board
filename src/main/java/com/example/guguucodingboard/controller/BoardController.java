package com.example.guguucodingboard.controller;

import com.example.guguucodingboard.dto.PageRequestDTO;
import com.example.guguucodingboard.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@Log4j2
public class BoardController {

  private final BoardService boardService;

  public BoardController(BoardService boardService) {
    this.boardService = boardService;
  }

  @GetMapping("/list")
  public void list(PageRequestDTO pageRequestDTO, Model model) {
    log.info("list................" + pageRequestDTO);
    model.addAttribute("result", boardService.getList(pageRequestDTO));
  }
}
