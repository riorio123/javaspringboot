package com.datamember.datamember.repository;

import com.datamember.datamember.model.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends CrudRepository<Member, Integer> {
    List<Member> findAll();
    Optional<Member> findById(int id);
}
