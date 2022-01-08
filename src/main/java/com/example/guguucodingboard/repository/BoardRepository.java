package com.example.guguucodingboard.repository;

import com.example.guguucodingboard.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
