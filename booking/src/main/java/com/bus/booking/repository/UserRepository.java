package com.bus.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bus.booking.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);

	@Modifying
	@Query("update User u set u.firstName = ?1, u.lastName = ?2, u.email = ?3, u.gender = ?4, u.phoneNumber = ?5,"
			+ "u.city = ?6, u.state = ?7 where u.id = ?8")	
	void updateUserDetails(String firstName, String lastName, String email, String gender,
			Long phoneNumber, String city, String state, Long id);
	
}
