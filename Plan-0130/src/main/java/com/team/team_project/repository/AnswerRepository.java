package com.team.team_project.repository;

import com.team.team_project.entity.Answer;
import com.team.team_project.entity.Question;
import com.team.team_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer,Long> {

    @Query(value="select a.qno from Answer a where a.answer = :answer")
    Question getQnoByUseContext(@Param("answer") String answer);

    @Query(value="select a.code from Answer a where a.qno = :qno")
    User getCodeByUseQno(@Param("qno") Question qno);

}
