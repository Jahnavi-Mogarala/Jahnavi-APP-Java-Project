package com.jpquizbot.controller;

import com.jpquizbot.model.Question;
import com.jpquizbot.service.QuestionBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class QuizController {
    @Autowired
    private QuestionBank bank;

    // GET /api/questions?cat=python&num=15
    @GetMapping("/questions")
    public List<Question> questions(@RequestParam(required=false) String cat,
                                    @RequestParam(required=false, defaultValue="10") int num) {
        return bank.getQuestions(cat, num);
    }
}
