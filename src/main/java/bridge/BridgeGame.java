package bridge;

import bridge.domain.Answer;
import bridge.domain.Bridge;
import bridge.domain.Movement;
import bridge.domain.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Result result = new Result();
    private List<Movement> player = new ArrayList<>();

    private static final String RETRY_CHOICE = "R";

    public void move(String movingInput) {
        validateDirection(movingInput);
        Movement movement = Movement.findBy(movingInput);
        player.add(movement);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String retryDecision) {
        validateRetryDecision(retryDecision);
        result.updateTrialNumber();
        if (retryDecision.equals(RETRY_CHOICE)) {
            return true;
        }
        return false;
    }

    private void validateDirection(String movingInput) {
        if (!movingInput.equals("U") && !movingInput.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 'U' 또는 'D'가 아닙니다.");
        }
    }

    private void validateRetryDecision(String retryDecision) {
        if (!retryDecision.equals("R") && !retryDecision.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q가 아닙니다.");
        }
    }

    public Result updateResult(Bridge bridge) {
        for (int i = 0; i < player.size(); i++) {
            boolean checkAnswer = compareBridgeWithPlayer(i, bridge);
            Answer answer = Answer.findBy(checkAnswer);
            result.setRoute(answer);
        }
        return result;
    }

    private boolean compareBridgeWithPlayer(int index, Bridge bridge) {
        if (player.get(index).getDirection().equals(bridge.getRandomNumber().get(index))) {
            return true;
        }
        return false;
    }

    public boolean checkAnswer() {
        return result.checkSuccessOfFailure();
    }

    public List<Movement> getPlayer() {
        return player;
    }
}
