package com.definejae234.jpa.repository;

import com.definejae234.jpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository  extends JpaRepository<Member,Integer> {

}
