package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private List<Answer> route = new ArrayList<>();
    private int trialNumber = 1;
    private String resultComment;
    private final String SUCCESS_COMMENT = "성공";
    private final String FAILURE_COMMENT = "실패";

    public void setRoute(Answer answer) {
        route.add(answer);
        updateResultComment(answer);
    }

    private void updateResultComment(Answer answer) {
        if (answer.isCheck()) {
            resultComment = "성공";
            return;
        }
        resultComment = "실패";
    }

    public boolean checkSuccessOfFailure() {
        if (resultComment.equals("성공")) {
            return true;
        }
        return false;
    }

    public void updateTrialNumber() {
        trialNumber++;
    }

    public List<Answer> getRoute() {
        return route;
    }

    public String getResultComment() {
        return resultComment;
    }

    public int getTrialNumber() {
        return trialNumber;
    }

    public void resetRoute() {
        route.clear();
    }
}
