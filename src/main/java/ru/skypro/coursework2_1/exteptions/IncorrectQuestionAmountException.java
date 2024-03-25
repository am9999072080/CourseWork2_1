package ru.skypro.coursework2_1.exteptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectQuestionAmountException extends RuntimeException {
    public IncorrectQuestionAmountException() {

        super("НЕПРАВИЛЬНЫЙ ЗАПРОС ");
    }
}
