package ru.skypro.coursework2_1.service.impl;

import ru.skypro.coursework2_1.exteptions.QuestionNotFoundException;
import ru.skypro.coursework2_1.model.Question;
import ru.skypro.coursework2_1.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override//Добавление
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override//Удаление
    public Question remove(Question question) {
        if (!questions.remove(question)) {
            throw new QuestionNotFoundException();
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {//возвращает ВЕСЬ список <Question> из созданного объекта HashSet
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        int questionIndex = random.nextInt(questions.size());

        return new ArrayList<Question>(questions).get(questionIndex);
    }
}
