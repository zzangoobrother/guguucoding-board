package com.example.gugucodingmovieboard.service;

import com.example.gugucodingmovieboard.controller.MovieController;
import com.example.gugucodingmovieboard.dto.MovieDTO;
import com.example.gugucodingmovieboard.dto.PageRequestDTO;
import com.example.gugucodingmovieboard.dto.PageResultDTO;
import com.example.gugucodingmovieboard.entity.Movie;
import com.example.gugucodingmovieboard.entity.MovieImage;
import com.example.gugucodingmovieboard.repository.MovieImageRepository;
import com.example.gugucodingmovieboard.repository.MovieRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import javax.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MovieServiceImpl implements MovieService {

  private final MovieRepository movieRepository;
  private final MovieImageRepository movieImageRepository;

  public MovieServiceImpl(MovieRepository movieRepository, MovieImageRepository movieImageRepository) {
    this.movieRepository = movieRepository;
    this.movieImageRepository = movieImageRepository;
  }

  @Override
  @Transactional
  public Long register(MovieDTO movieDTO) {
    Map<String, Object> entityMap = dtoToEntity(movieDTO);
    Movie movie = (Movie) entityMap.get("movie");
    List<MovieImage> movieImageList = (List<MovieImage>) entityMap.get("imgList");

    movieRepository.save(movie);
    movieImageList.forEach(movieImageRepository::save);

    return movie.getMno();
  }

  @Override
  public PageResultDTO<MovieDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
    Pageable pageable = pageRequestDTO.getPageable(Sort.by("mno").descending());
    Page<Object[]> result = movieRepository.getListPage(pageable);

    Function<Object[], MovieDTO> fn = (arr -> entitiesToDTO((Movie) arr[0], (List<MovieImage>) (Arrays.asList((MovieImage) arr[1])), (Double) arr[2], (Long) arr[3]));

    return new PageResultDTO<>(result, fn);
  }

  @Override
  public MovieDTO getMovie(Long mno) {
    List<Object[]> result = movieRepository.getMovieWithAll(mno);

    Movie movie = (Movie) result.get(0)[0];
    List<MovieImage> movieImageList = new ArrayList<>();
    result.forEach(arr -> {
      MovieImage movieImage= (MovieImage) arr[1];
      movieImageList.add(movieImage);
    });

    Double avg = (Double) result.get(0)[2];
    Long reviewCnt = (Long) result.get(0)[3];

    return entitiesToDTO(movie, movieImageList, avg, reviewCnt);
  }
}
