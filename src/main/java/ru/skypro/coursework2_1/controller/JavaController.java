package ru.skypro.coursework2_1.controller;

import ru.skypro.coursework2_1.model.Question;
import ru.skypro.coursework2_1.service.QuestionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping("/java")
public class JavaController {
    private final QuestionService questionService;

    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping("/add")
    public Question add(@RequestParam String question,
                        @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @RequestMapping("/remove")
    public Question remove(@RequestParam String question,
                           @RequestParam String answer) {
        return questionService.remove(new Question(question, answer));
    }

    @RequestMapping()
    public Collection<Question> getAll() {
        return questionService.getAll();
    }
}
