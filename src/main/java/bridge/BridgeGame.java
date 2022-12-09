package bridge;

import bridge.domain.Result;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private Result result = new Result();
    private List<String> playerRoute = new ArrayList<>();

    public void move(String movingInput) {
        validateMovingInput(movingInput);
        playerRoute.add(movingInput);
    }

    public boolean checkMovingResult(List<String> bridge) {
        int index = getRouteIndex();
        boolean result = compareBridgeAndPlayer(bridge, index);
        return result;
    }

    public void retry() {
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
}
