package com.learn.fullstackapplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.fullstackapplication.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{
	

}
