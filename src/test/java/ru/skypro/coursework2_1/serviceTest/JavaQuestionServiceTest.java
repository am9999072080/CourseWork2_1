package ru.skypro.coursework2_1.serviceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.skypro.coursework2_1.exteptions.QuestionNotFoundException;
import ru.skypro.coursework2_1.model.Question;
import ru.skypro.coursework2_1.service.QuestionService;
import ru.skypro.coursework2_1.service.impl.JavaQuestionService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static ru.skypro.coursework2_1.serviceTest.QuestionConstants.*;

public class JavaQuestionServiceTest {
    private final QuestionService questionService = new JavaQuestionService();

    @BeforeEach
    public void beforeEach() {
        questionService.add(QUESTION_1);
        questionService.add(QUESTION_2);
        questionService.add(QUESTION_3);
    }

    @Test
    public void shouldAddQuestion() {
        int beforeCount = questionService.getAll().size();

        assertThat(questionService.add(QUESTION_4)).isEqualTo(QUESTION_4).isIn(questionService.getAll());

        assertThat(questionService.getAll()).hasSize(beforeCount + 1);
    }

    @Test
    public void shouldRemoveQuestion() {
        int beforeCount = questionService.getAll().size();

        assertThat(questionService.remove(QUESTION_1)).isEqualTo(QUESTION_1).isNotIn(questionService.getAll());

        assertThat(questionService.getAll()).hasSize(beforeCount - 1);
    }

    @Test
    public void shouldThrowQuestionNotFoundException() {
        assertThatExceptionOfType(QuestionNotFoundException.class).isThrownBy(() -> questionService.remove(new Question("INCORRECT", "INCORRECT")));
    }

    @Test
    public void shouldGetAllQuestions() {
        assertThat(questionService.getAll()).hasSize(3).containsExactlyInAnyOrder(QUESTION_1, QUESTION_2, QUESTION_3);
    }

    @Test
    public void shouldReturnRandomQuestion() {
        assertThat(questionService.getRandomQuestion()).isNotNull().isIn(questionService.getAll());
    }
}
