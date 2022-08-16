package com.codestates.soloproject.BusinessCommunity.member.controller;


import com.codestates.soloproject.BusinessCommunity.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/v1/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
//    private final MemberMapper mapper;
//
//    @PostMapping
//    public ResponseEntity signUpMember(@RequestBody MemberRequestDto.createMember memberDto){
//        Member member = memberService.createMember(mapper.memberPostDtoToMember(memberDto));
//        return new ResponseEntity<>(new SingleResponseDto<>(mapper.memberToMemberInfo(member),"SUCCESS"), HttpStatus.CREATED);
//    }

    @GetMapping
    public ResponseEntity getMembers() {
        return new ResponseEntity<>(memberService.findMembers(), HttpStatus.OK);
    }

    @GetMapping("/company")
    public ResponseEntity getMember(@PathParam("location") String location,
                                    @PathParam("type") String type) {
        return new ResponseEntity<>(memberService.findMembersByQuery(location, type), HttpStatus.OK);
    }
}
