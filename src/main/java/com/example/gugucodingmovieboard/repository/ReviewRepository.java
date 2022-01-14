package com.example.gugucodingmovieboard.repository;

import com.example.gugucodingmovieboard.entity.Member;
import com.example.gugucodingmovieboard.entity.Movie;
import com.example.gugucodingmovieboard.entity.Review;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review, Long> {

  @EntityGraph(attributePaths = {"member"}, type = EntityGraphType.FETCH)
  List<Review> findByMovie(Movie movie);

  @Modifying
  @Query("delete from Review r where r.member = :member")
  void deleteByMember(@Param("member") Member member);
}
