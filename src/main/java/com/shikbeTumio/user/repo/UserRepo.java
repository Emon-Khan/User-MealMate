package com.shikbeTumio.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shikbeTumio.user.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
