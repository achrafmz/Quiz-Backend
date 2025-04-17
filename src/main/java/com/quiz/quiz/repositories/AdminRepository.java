package com.quiz.quiz.repositories;

import com.quiz.quiz.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
