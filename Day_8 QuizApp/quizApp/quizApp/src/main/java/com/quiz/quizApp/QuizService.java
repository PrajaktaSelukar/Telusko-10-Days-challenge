package com.quiz.quizApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class QuizService {
    @Autowired
    QuizDB db;

    public List<Question> getAllQuizData(){
        return db.findAll();
    }
    public void deleteById(Number id){
        db.deleteById(id);
    }
    public List<Question> createQuizList(List<Question> questionList) {
        for (Question q:questionList){
            db.save(q);
        }
        return null;
    }
    public void createQuiz(Question question) {
            db.save(question);
    }
    public void updateById(Question question) {
        db.save(question);
    }
    public List<Question> getQuiz(){
        return null;
    }

    public List<String> findDistinctType(String columnName) {
        switch (columnName) {
//            case "question":
//                return db.findDistinctQuestion();
//                return null;
            case "type":
                return db.findDistinctTypes();
            // Add more cases for other column names if needed
            default:
                throw new IllegalArgumentException("Invalid column name: " + columnName);
        }
    }

    public List<Question> findQuizList(String columnName) {
        List<Question> allQuizData = getAllQuizData();
        List<Question> filteredRows = new ArrayList<>();

        for (Question row : allQuizData) {
            System.out.println(row);
            if (row.getType().equals(columnName)) {
                filteredRows.add(row);
            }
        }

        Collections.shuffle(filteredRows);

        return filteredRows;
    }
}

