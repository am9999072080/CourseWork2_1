package ru.skypro.coursework2_1.service;

import ru.skypro.coursework2_1.model.Question;

import java.util.Collection;
public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
