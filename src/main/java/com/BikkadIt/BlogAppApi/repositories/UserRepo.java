package com.BikkadIt.BlogAppApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIt.BlogAppApi.entity.User;

public interface UserRepo extends JpaRepository<User,Integer>{

}
