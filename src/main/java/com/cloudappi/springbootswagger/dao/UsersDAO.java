package com.cloudappi.springbootswagger.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudappi.springbootswagger.entities.User;

public interface UsersDAO extends JpaRepository<User, Integer> {

}
