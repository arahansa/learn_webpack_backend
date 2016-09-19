package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jarvis on 2016. 9. 19..
 */
@lombok.Data
@Entity
public class Member {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  private String username;

  private String email;

  private String password;

}
