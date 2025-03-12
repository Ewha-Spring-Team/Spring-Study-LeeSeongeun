package com.example.firstproject.repository;

import com.example.firstproject.entity.Member; // 잊지 말기!
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {

}
