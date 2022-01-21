package com.example.gugucodingbimovieboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GugucodingBiMovieBoardApplication {

  public static void main(String[] args) {
    SpringApplication.run(GugucodingBiMovieBoardApplication.class, args);
  }
}
