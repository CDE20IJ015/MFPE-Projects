package com.returnorder.portal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.returnorder.portal.model.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser, Integer>{
	
	@Query(value="select userid from myuser where user_name=?1", nativeQuery=true)
	public int getUserId(String username);

}
