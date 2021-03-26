package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.beans.SecurityQuestion;
import com.project.beans.User;
import com.project.dto.SecurityQuestionData;

public interface SecurityQuestionRepository extends JpaRepository<SecurityQuestion, Integer> {

	
}
