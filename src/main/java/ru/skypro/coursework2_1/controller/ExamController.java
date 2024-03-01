package ru.skypro.coursework2_1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import ru.skypro.coursework2_1.model.Question;
import ru.skypro.coursework2_1.service.ExaminerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {

        this.examinerService = examinerService;
    }

    @ApiResponse(responseCode = "400", description = "!Запрос некорректный!")
    @Operation(summary = "Получения question & answer по amount")
    @GetMapping(path = "/get{amount}")

    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}