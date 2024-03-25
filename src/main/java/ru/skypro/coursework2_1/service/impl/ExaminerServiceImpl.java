package ru.skypro.coursework2_1.service.impl;

import ru.skypro.coursework2_1.exteptions.IncorrectQuestionAmountException;
import ru.skypro.coursework2_1.model.Question;
import ru.skypro.coursework2_1.service.ExaminerService;
import ru.skypro.coursework2_1.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {

        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0 || amount > questionService.getAll().size()) {
            throw new IncorrectQuestionAmountException();
        }
        Set<Question> questions2 = new HashSet<>();
        while (questions2.size() < amount) {
            questions2.add(questionService.getRandomQuestion());
        }
        return questions2;
    }
}
