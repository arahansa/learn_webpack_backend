package com.example.controller;

import com.example.domain.Member;
import com.example.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jarvis on 2016. 9. 19..
 */
@Slf4j
@RestController
public class MemberController {


  @Autowired
  private MemberRepository memberRepository;

  @GetMapping({"/", "/list"})
  public List<Member> memberList(){
    return memberRepository.findAll();
  }

  @GetMapping("/signin")
  public ResponseEntity<Void> signin(String email, String password){
    final Long count = memberRepository.countByEmailAndPassword(email, password);
    log.debug("login count : {}", count);
    if(count==null|| count==0L){
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("/signup")
  public ResponseEntity<Member> signup(@RequestBody  Member member){
    Member savedMember = memberRepository.save(member);
    return new ResponseEntity<>(savedMember, HttpStatus.OK);
  }



}
