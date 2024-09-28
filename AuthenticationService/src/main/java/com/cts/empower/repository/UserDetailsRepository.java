package com.cts.empower.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.empower.Entity.UserDetailsInfo;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetailsInfo, Long> {

	public UserDetailsInfo findByEmailAndPassword(String email,String password);


}
