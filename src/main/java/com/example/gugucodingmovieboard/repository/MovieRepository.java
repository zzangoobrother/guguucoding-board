package com.example.gugucodingmovieboard.repository;

import com.example.gugucodingmovieboard.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
