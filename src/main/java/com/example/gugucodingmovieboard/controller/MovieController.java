package com.example.gugucodingmovieboard.controller;

import com.example.gugucodingmovieboard.dto.MovieDTO;
import com.example.gugucodingmovieboard.service.MovieService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/movie")
@Log4j2
public class MovieController {

  private final MovieService movieService;

  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @GetMapping("/register")
  public void register() {

  }

  @PostMapping("/register")
  public String register(MovieDTO movieDTO, RedirectAttributes redirectAttributes) {
    log.info("movieDTO : " + movieDTO);
    Long mno = movieService.register(movieDTO);
    redirectAttributes.addFlashAttribute("msg", mno);

    return "redirect:/movie/list";
  }
}