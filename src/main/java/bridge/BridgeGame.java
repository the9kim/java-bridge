package bridge;

import bridge.domain.Answer;
import bridge.domain.Result;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private static final String RETRY_DECISION = "R";
    private List<String> playerRoute = new ArrayList<>();

    public void move(String movingInput) {
        validateMovingInput(movingInput);
        playerRoute.add(movingInput);
    }

    public void checkMovingResult(List<String> bridge) {
        int index = getRouteIndex();
        boolean result = compareBridgeAndPlayer(bridge, index);
        Result.updateResult(Answer.findBy(result));
    }

    public boolean retry(String retryCommand) {
        validateRetryCommand(retryCommand);
        if (retryCommand.equals(RETRY_DECISION)) {
            resetPlayerRoute();
            Result.resultMovingResult();
            Result.updateTrialNumber();
            return true;
        }
        return false;
    }

    private void validateMovingInput(String movingInput) {
        if (!movingInput.equals("U") && !movingInput.equals("D")) {
            throw new IllegalArgumentException("[ERROR] U 또는 D가 아닙니다.");
        }
    }

    private int getRouteIndex() {
        return playerRoute.size() - 1;
    }

    private boolean compareBridgeAndPlayer(List<String> bridge, int index) {
        if (bridge.get(index).equals(playerRoute.get(index))) {
            return true;
        }
        return false;
    }

    public List<String> getPlayerRoute() {
        return playerRoute;
    }

    private void validateRetryCommand(String retryCommand) {
        if (!retryCommand.equals("R") && !retryCommand.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q가 아닙니다");
        }
    }

    private void resetPlayerRoute() {
        playerRoute.clear();
    }
}
