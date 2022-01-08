package com.example.guguucodingboard.repository;

import com.example.guguucodingboard.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

}
