package com.datamember.datamember.service;

import com.datamember.datamember.model.Member;
import com.datamember.datamember.repository.MemberRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private MemberRepository memberRepo;

    public MemberService(MemberRepository initialRepo) {
        this.memberRepo = initialRepo; 
    }

    public List<Member> showAllMembers() {
        return memberRepo.findAll();
    }

    public void createMember(Member newMember) {
        memberRepo.save(newMember);
    }

    public Member getByIdMember(Integer id) {
        Optional<Member> aMember = memberRepo.findById(id);
        if(aMember.isPresent()) {
            return aMember.get();
        }
        return null;
    }

    public void updateMember(Member newMember) {
        memberRepo.save(newMember);
    }

    public void deleteByID(Integer id) {
        memberRepo.deleteById(id);
    }
}
