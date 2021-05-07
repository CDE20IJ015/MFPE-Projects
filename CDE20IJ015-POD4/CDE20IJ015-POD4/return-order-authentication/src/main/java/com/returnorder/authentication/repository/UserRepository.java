package com.returnorder.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.returnorder.authentication.model.MyUser;

public interface UserRepository extends JpaRepository<MyUser,String > {

	public MyUser findByUsername(String username);

	@Query(value="select userid from myuser where username=?1",nativeQuery=true)
	public int getUserById(String username);

	

}
