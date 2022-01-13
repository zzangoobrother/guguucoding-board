package com.example.gugucodingmovieboard.repository;

import com.example.gugucodingmovieboard.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
