package bridge.domain;

import java.util.Arrays;

public enum Answer {
    CORRECT(true, "O"),
    WRONG(false, "X");

    private boolean isAnswer;
    private String answerIndicator;

    Answer(boolean isAnswer, String answerIndicator) {
        this.isAnswer = isAnswer;
        this.answerIndicator = answerIndicator;
    }

    public static Answer findBy(boolean isAnswer) {
        return Arrays.stream(Answer.values())
                .filter(answer -> answer.isAnswer == isAnswer)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 올바르지 않은 인자입니다."));


    }

    public boolean isAnswer() {
        return isAnswer;
    }

    public String getIndicator() {
        return answerIndicator;
    }
}
