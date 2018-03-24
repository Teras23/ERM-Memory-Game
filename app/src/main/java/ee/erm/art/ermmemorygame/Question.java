package ee.erm.art.ermmemorygame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by teras on 24.03.18.
 */

public class Question {
    private String fileName;
    private MLString questionText;
    private MLString description;
    private List<MLString> answers;
    private Integer correctAnswer;

    public Question() {
        this.fileName = "default_picture.png";
        this.questionText = new MLString();
        this.description = new MLString();
        this.answers = new ArrayList<>();
        this.correctAnswer = 0;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setCorrectAnswer(Integer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void addAnswer(MLString answer) {
        answers.add(answer);
    }

    public MLString getQuestionText() {
        return questionText;
    }

    public void setQuestionText(MLString questionText) {
        this.questionText = questionText;
    }

    public MLString getDescription() {
        return description;
    }

    public void setDescription(MLString description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Question{" +
                "fileName='" + fileName + '\'' +
                ", questionText=" + questionText +
                ", description=" + description +
                ", answers=" + answers +
                ", correctAnswer=" + correctAnswer +
                '}';
    }
}
