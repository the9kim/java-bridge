package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private static List<Answer> result = new ArrayList<>();


    public static void updateResult(Answer answer) {
        result.add(answer);
    }

    public static List<Answer> getResult() {
        return result;
    }
}
