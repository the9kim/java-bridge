package bridge;

import bridge.domain.Answer;
import bridge.domain.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    List<String> route = new ArrayList<>();
    public String move(String direction) {
        route.add(direction);
        return direction;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        Result.resetResult();
        Result.updateTrialNumber();
    }

    public void checkResult(List<String> bridge, String direction) {
        int roundIndex = route.lastIndexOf(direction);
        if (!direction.equals(bridge.get(roundIndex))) {
            Result.updateResult(Answer.findBy(false));
            return;
        }
        Result.updateResult(Answer.findBy(true));
    }

    public List<String> getRoute() {
        return route;
    }
}
