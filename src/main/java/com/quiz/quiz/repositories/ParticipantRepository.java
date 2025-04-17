package com.quiz.quiz.repositories;

import com.quiz.quiz.models.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    Participant findByUsername(String username);
}
