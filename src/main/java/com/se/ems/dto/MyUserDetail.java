package com.se.ems.dto;

import com.se.ems.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MyUserDetail implements UserDetails {

      User user;
      public MyUserDetail(User user) {
          this.user = user;
      }
      @Override
      public Collection<? extends GrantedAuthority> getAuthorities() {
          return List.of(new SimpleGrantedAuthority("USER"));
      }

      @Override
      public String getPassword() {
          return user.getPassword();
      }

      @Override
      public String getUsername() {
          return user.getEmail();
      }

      @Override
      public boolean isAccountNonExpired() {
          return UserDetails.super.isAccountNonExpired();
      }

      @Override
      public boolean isAccountNonLocked() {
          return UserDetails.super.isAccountNonLocked();
      }

      @Override
      public boolean isCredentialsNonExpired() {
          return UserDetails.super.isCredentialsNonExpired();
      }

      @Override
      public boolean isEnabled() {
          return UserDetails.super.isEnabled();
      }
  }