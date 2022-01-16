package com.example.gugucodingmovieboard.controller;

import com.example.gugucodingmovieboard.dto.ReviewDTO;
import com.example.gugucodingmovieboard.service.ReviewService;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
@Log4j2
public class ReviewController {

  private final ReviewService reviewService;

  public ReviewController(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @GetMapping("/{mno}/all")
  public ResponseEntity<List<ReviewDTO>> getList(@PathVariable("mno") Long mno) {
    log.info("-----------------list------------------");
    log.info("MNO : " + mno);
    List<ReviewDTO> reviewDTOList = reviewService.getListOfMovie(mno);
    return new ResponseEntity<>(reviewDTOList, HttpStatus.OK);
  }

  @PostMapping("/{mno}")
  public ResponseEntity<Long> addReview(@RequestBody ReviewDTO reviewDTO) {
    log.info("-----------------add MovieReview------------------");
    log.info("reviewDTO : " + reviewDTO);
    Long reviewnum = reviewService.register(reviewDTO);
    return new ResponseEntity<>(reviewnum, HttpStatus.OK);
  }

  @PutMapping("/{mno}/{reviewnum}")
  public ResponseEntity<Long> modifyReview(@PathVariable("reviewnum") Long reviewnum, @RequestBody ReviewDTO reviewDTO) {
    log.info("-----------------modify MovieReview------------------");
    log.info("reviewDTO : " + reviewDTO);
    reviewService.modify(reviewDTO);
    return new ResponseEntity<>(reviewnum, HttpStatus.OK);
  }

  @DeleteMapping("/{mno}/{reviewnum}")
  public ResponseEntity<Long> removeReview(@PathVariable("reviewnum") Long reviewnum) {
    log.info("-----------------modify removeReview------------------");
    log.info("reviewnum : " + reviewnum);
    reviewService.remove(reviewnum);
    return new ResponseEntity<>(reviewnum, HttpStatus.OK);
  }
}
