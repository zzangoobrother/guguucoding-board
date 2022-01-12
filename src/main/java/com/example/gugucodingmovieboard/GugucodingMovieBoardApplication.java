package com.example.gugucodingmovieboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GugucodingMovieBoardApplication {

  public static void main(String[] args) {
    SpringApplication.run(GugucodingMovieBoardApplication.class, args);
  }
}
