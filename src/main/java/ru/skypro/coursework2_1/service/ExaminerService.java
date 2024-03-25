package ru.skypro.coursework2_1.service;

import ru.skypro.coursework2_1.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);

}
