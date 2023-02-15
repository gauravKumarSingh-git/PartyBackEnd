package com.party.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.party.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

}
