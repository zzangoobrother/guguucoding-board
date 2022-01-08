package com.example.guguucodingboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GuguucodingBoardApplication {

  public static void main(String[] args) {
    SpringApplication.run(GuguucodingBoardApplication.class, args);
  }

}
