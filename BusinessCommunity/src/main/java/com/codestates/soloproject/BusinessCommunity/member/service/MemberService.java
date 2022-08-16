package com.codestates.soloproject.BusinessCommunity.member.service;

import com.codestates.soloproject.BusinessCommunity.member.entity.Member;
import com.codestates.soloproject.BusinessCommunity.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

//    public Member createMember(Member member) {
//        return memberRepository.save(member);
//    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public List<Member> findMembersByQuery(String location, String type) {
        return memberRepository.findAllByLocationAndSector(location, type);
    }
}
