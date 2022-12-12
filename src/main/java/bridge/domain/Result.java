package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private static final String SUCCESS_COMMENT = "성공";
    private static final String FAILURE_COMMENT = "실패";
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

    public static int getTrialNumber() {
        return trialNumber;
    }

    public static String getSuccessOrFailure() {
        if (result.contains(Answer.WRONG)) {
            return FAILURE_COMMENT;
        }
        return SUCCESS_COMMENT;
    }
}
