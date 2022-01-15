package com.example.gugucodingmovieboard.service;

import com.example.gugucodingmovieboard.dto.MovieDTO;
import com.example.gugucodingmovieboard.dto.MovieImageDTO;
import com.example.gugucodingmovieboard.dto.PageRequestDTO;
import com.example.gugucodingmovieboard.dto.PageResultDTO;
import com.example.gugucodingmovieboard.entity.Movie;
import com.example.gugucodingmovieboard.entity.MovieImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface MovieService {

  Long register(MovieDTO movieDTO);

  PageResultDTO<MovieDTO, Object[]> getList(PageRequestDTO pageRequestDTO);

  default Map<String, Object> dtoToEntity(MovieDTO movieDTO) {
    Map<String, Object> entityMap = new HashMap<>();

    Movie movie = Movie.builder()
        .mno(movieDTO.getMno())
        .title(movieDTO.getTitle())
        .build();

    entityMap.put("movie", movie);

    List<MovieImageDTO> imageDTOList = movieDTO.getImageDTOList();
    if (imageDTOList != null && imageDTOList.size() > 0) {
      List<MovieImage> movieImageList = imageDTOList.stream().map(movieImageDTO -> {
        return MovieImage.builder()
            .path(movieImageDTO.getPath())
            .imgName(movieImageDTO.getImgName())
            .uuid(movieImageDTO.getUuid())
            .movie(movie)
            .build();
      }).collect(Collectors.toList());

      entityMap.put("imgList", movieImageList);
    }
    System.out.println(imageDTOList);
    return entityMap;
  }

  default MovieDTO entitiesToDTO(Movie movie, List<MovieImage> movieImages, Double avg, Long reviewCnt) {
    MovieDTO movieDTO = MovieDTO.builder()
        .mno(movie.getMno())
        .title(movie.getTitle())
        .regDate(movie.getRegDate())
        .modDate(movie.getModDate())
        .build();

    List<MovieImageDTO> movieImageDTOList = movieImages.stream().map(movieImage -> {
      return MovieImageDTO.builder()
          .imgName(movieImage.getImgName())
          .path(movieImage.getPath())
          .uuid(movieImage.getUuid())
          .build();
    }).collect(Collectors.toList());

    movieDTO.setImageDTOList(movieImageDTOList);
    movieDTO.setAvg(avg);
    movieDTO.setReviewCnt(reviewCnt.intValue());

    return movieDTO;
  }
}
