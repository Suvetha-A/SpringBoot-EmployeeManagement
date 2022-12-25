package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface emp_repo extends JpaRepository<Employee,Integer>{
	
	@Query(value = "SELECT * FROM employee e where e.employee_id = ?1", nativeQuery = true)
	 List<Employee> findById(int id);
	    
	 @Modifying
	 @Transactional 
	 @Query(value = "DELETE FROM employee WHERE employee_id = ?1 ", nativeQuery = true)
	 void deleteAllByIdInBatch(int id);
	 

}
