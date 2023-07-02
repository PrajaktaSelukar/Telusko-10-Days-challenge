package com.quiz.quizApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:9806")
public class QuizController {
    @Autowired
    QuizService service;
    Map<String, String> hashMap = new HashMap<>();
    @GetMapping("/get/allquestions")
    public List<Question> getAllQuizData(){
        return service.getAllQuizData();
    }

    @PostMapping("/save/questions")
    public void createQuizList(@RequestBody List<Question> quizList){
        service.createQuizList(quizList);
//        return null;
    }
    @PostMapping("/save/question")
    public HashMap createQuiz(@RequestBody Question quizObj){
        service.createQuiz(quizObj);
        String data = quizObj.toString();
        hashMap.put("Result","Saved successfully");
        hashMap.put("Data",data);
        return (HashMap) hashMap;
    }
    @GetMapping("/get/quiz")
    public List<Question> getQuiz(){
        return service.getQuiz();
    }
    @DeleteMapping("/delete/question")
    public HashMap deleteById(@RequestBody Long id){
        service.deleteById(id);
        Map<String, String> reshashMap = new HashMap<>();
        reshashMap.put("result","successfully deleted");
        return (HashMap) reshashMap;
    }
    @PostMapping("/update/question")
    public String updateById(@RequestBody Question question){
        service.updateById(question);
        return "successfully updated";
    }

    @GetMapping("/distinctTypes/{columnName}")
    public List<String> getDistinctValues(@PathVariable String columnName) {
        return service.findDistinctType(columnName);
    }
    @GetMapping("/listOfQuizQuestions/{columnName}")
    public List<Question> listOfQuizQuestions(@PathVariable String columnName) {
        return service.findQuizList(columnName);
    }

}
