package com.example.gugucodingmovieboard.service;

import com.example.gugucodingmovieboard.dto.ReviewDTO;
import com.example.gugucodingmovieboard.entity.Movie;
import com.example.gugucodingmovieboard.entity.Review;
import com.example.gugucodingmovieboard.repository.ReviewRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReviewServiceImpl implements ReviewService {

  private final ReviewRepository reviewRepository;

  public ReviewServiceImpl(ReviewRepository reviewRepository) {
    this.reviewRepository = reviewRepository;
  }

  @Override
  public List<ReviewDTO> getListOfMovie(Long mno) {
    Movie movie = Movie.builder().mno(mno).build();
    List<Review> result = reviewRepository.findByMovie(movie);

    return result.stream().map(this::entityToDto).collect(Collectors.toList());
  }

  @Override
  public Long register(ReviewDTO reviewDTO) {
    Review review = dtoToEntity(reviewDTO);
    reviewRepository.save(review);
    return review.getReviewnum();
  }

  @Override
  public void modify(ReviewDTO reviewDTO) {
    Optional<Review> result = reviewRepository.findById(reviewDTO.getReviewnum());

    if (result.isPresent()) {
      Review review = result.get();
      review.changeGrade(reviewDTO.getGrade());
      review.changeText(reviewDTO.getText());

      reviewRepository.save(review);
    }
  }

  @Override
  public void remove(Long reviewnum) {
    reviewRepository.deleteById(reviewnum);
  }
}
