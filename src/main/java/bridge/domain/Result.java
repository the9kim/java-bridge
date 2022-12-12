package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private static int trialNumber = 1;
    private static List<Answer> result = new ArrayList<>();

    public static void updateResult(Answer answer) {
        result.add(answer);
    }

    public static void resetResult() {
        result.clear();
    }


    public static List<Answer> getResult() {
        return result;
    }

    public static void updateTrialNumber() {
        trialNumber += 1;
    }
}
