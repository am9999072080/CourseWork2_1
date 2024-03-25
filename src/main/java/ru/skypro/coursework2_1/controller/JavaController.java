package ru.skypro.coursework2_1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;
import ru.skypro.coursework2_1.model.Question;
import ru.skypro.coursework2_1.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaController {
    private final QuestionService questionService;

    public JavaController(QuestionService questionService) {

        this.questionService = questionService;
    }

    @Operation(summary = "Добавления question & answer")
    @PostMapping("add")
    public Question add(@RequestParam String question,
                        @RequestParam String answer) {
        return questionService.add(question, answer);
    }


    @ApiResponse(responseCode = "404", description = "!НЕ НАЙДЕН!")
    @Operation(summary = "Удаления question & answer")
    @DeleteMapping("/remove")
    public Question remove(@RequestParam String question,
                           @RequestParam String answer) {
        return questionService.remove(new Question(question, answer));
    }


    @Operation(summary = "Получения всех question & answer")
    @GetMapping()
    public Collection<Question> getAll() {
        return questionService.getAll();
    }
}
