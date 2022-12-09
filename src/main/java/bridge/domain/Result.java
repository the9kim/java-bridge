package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private static List<Answer> movingResult = new ArrayList<>();
    private static int trialNumber = 1;
    private static boolean isSuccessOrFailure;

    public static void updateResult(Answer answer) {
        addResult(answer);
        updateSuccess(answer);
    }


    private static void addResult(Answer answer) {
        movingResult.add(answer);
    }

    public static void updateTrialNumber() {
        trialNumber++;
    }

    private static void updateSuccess(Answer answer) {
        if (answer.isAnswer()) {
            isSuccessOrFailure = true;
            return;
        }
        isSuccessOrFailure = false;
    }

    public static boolean isIsSuccessOrFailure() {
        return isSuccessOrFailure;
    }

    public static List<Answer> getMovingResult() {
        return movingResult;
    }

    public static void resultMovingResult() {
        movingResult.clear();
    }

    public static int getTrialNumber() {
        return trialNumber;
    }
}
