package com.quiz.quizApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
public interface QuizDB extends JpaRepository<Question, Number> {
    public List<Question> findAll();
    void deleteById(Number id);

//    List<String> findDistinctType();

    @Query("SELECT DISTINCT q.type FROM Question q")
    List<String> findDistinctTypes();

//    List<String> findDistinctQuestion();
}

//to use another table of database
//@Repository
//public interface table2 extends JpaRepository<Question, Long> {
//    public List<Question> findAll();
//}