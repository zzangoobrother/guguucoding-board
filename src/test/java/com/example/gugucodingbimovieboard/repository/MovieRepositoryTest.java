package com.example.gugucodingbimovieboard.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.gugucodingbimovieboard.entity.Movie;
import com.example.gugucodingbimovieboard.entity.Poster;
import java.util.Arrays;
import java.util.stream.IntStream;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;

@SpringBootTest
class MovieRepositoryTest {

  @Autowired
  private MovieRepository movieRepository;

  @Test
  void testInsert() {
    System.out.println("testInsert.......................");

    Movie movie = Movie.builder().title("공부합시다").build();
    movie.addPoster(Poster.builder().fname("공부합시다.jpg").build());
    movie.addPoster(Poster.builder().fname("공부합시다2.jpg").build());

    movieRepository.save(movie);
    System.out.println(movie.getMno());
  }

  @Test
  @Transactional
  @Commit
  void testAddPoster() {
    Movie movie = movieRepository.findById(1L).orElseThrow(IllegalArgumentException::new);
    movie.addPoster(Poster.builder().fname("공보합시당3.jpg").build());
    movieRepository.save(movie);
  }

  @Test
  @Transactional
  @Commit
  void testRemovePoster() {
    Movie movie = movieRepository.findById(1L).orElseThrow(IllegalArgumentException::new);
    movie.removePoster(2L);
    movieRepository.save(movie);
  }

  @Test
  void insertMovies() {
    IntStream.rangeClosed(10, 100).forEach(i -> {
      Movie movie = Movie.builder().title("세계명작" + i).build();
      movie.addPoster(Poster.builder().fname("세계명작" + i + "포스터1.jpg").build());
      movie.addPoster(Poster.builder().fname("세계명작" + i + "포스터2.jpg").build());

      movieRepository.save(movie);
    });
  }

  @Test
  void testPaging1() {
    Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());

    Page<Movie> result = movieRepository.findAll(pageable);

    result.getContent().forEach(m -> {
      System.out.println(m.getMno());
      System.out.println(m.getTitle());
      System.out.println(m.getPosterList().size());
      System.out.println("-----------------------------------");
    });
  }

  @Test
  void testPaging2() {
    Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());

    Page<Movie> result = movieRepository.findAll2(pageable);

    result.getContent().forEach(m -> {
      System.out.println(m.getMno());
      System.out.println(m.getTitle());
      System.out.println(m.getPosterList());
      System.out.println("-----------------------------------");
    });
  }

  @Test
  void testPaging3() {
    Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());

    Page<Object[]> result = movieRepository.findAll3(pageable);

    result.getContent().forEach(arr -> {
      System.out.println(Arrays.toString(arr));
      System.out.println("-----------------------------------");
    });
  }
}