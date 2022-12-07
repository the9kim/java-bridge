package bridge.domain;

import java.util.Arrays;

public enum Answer {
    CORRECT(true, "O"),
    WRONG(false, "X");

    boolean check;
    String indicator;

    Answer(boolean check, String indicator) {
        this.check = check;
        this.indicator = indicator;
    }

    public static Answer findBy(boolean check) {
        return Arrays.stream(Answer.values())
                .filter(answer -> answer.check == check)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 연산자를 찾을 수 없습니다."));
    }

    public boolean isCheck() {
        return check;
    }

    public String getIndicator() {


        return indicator;
    }
}
