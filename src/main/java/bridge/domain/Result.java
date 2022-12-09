package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private static List<Answer> movingResult = new ArrayList<>();
    private static int trialNumber;
    private static boolean isSuccessOrFailure;

    public static void updateResult(Answer answer) {
        addResult(answer);
        updateTrialNumber(answer);
        updateSuccess(answer);
        }


    private static void addResult(Answer answer) {
        if (answer.isAnswer() == false) {
            trialNumber++;
        }
    }

    private static void updateTrialNumber(Answer answer) {
        if (!answer.isAnswer()) {
            trialNumber++;
        }
    }
    private static void updateSuccess(Answer answer) {
        if (answer.isAnswer()) {
            isSuccessOrFailure = true;
        }
        isSuccessOrFailure = false;
    }

}
