package bridge.domain;

public enum Answer {
    CORRECT(true, "O"),
    WRONG(false, "X");

    boolean isAnswer;
    String answerIndicator;

    Answer(boolean isAnswer, String answerIndicator) {
        this.isAnswer = isAnswer;
        this.answerIndicator = answerIndicator;
    }

}
