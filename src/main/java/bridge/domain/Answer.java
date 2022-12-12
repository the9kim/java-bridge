package bridge.domain;

import java.util.Arrays;

public enum Answer {
    CORRECT(true, "O"),
    WRONG(false, "X");

    private boolean isAnswer;
    private String indicator;

    Answer(boolean isAnswer, String indicator) {
        this.isAnswer = isAnswer;
        this.indicator = indicator;
    }

    public static Answer findBy(boolean isAnswer) {
        return Arrays.stream(Answer.values())
                .filter(answer -> answer.isAnswer == isAnswer)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public String getIndicator() {
        return indicator;
    }
}
