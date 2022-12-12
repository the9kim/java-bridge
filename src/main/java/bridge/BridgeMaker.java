package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final String LOWER_DIRECTION = "D";
    private static final String UPPER_DIRECTION = "U";

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private final List<String> bridge = new ArrayList<>();

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        validateSize(size);
        for (int i = 0; i < size; i++) {
            int randomNumber = bridgeNumberGenerator.generate();
            String direction = convertNumberToDirection(randomNumber);
            bridge.add(direction);
        }
        return bridge;
    }

    private void validateSize(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 3이상 20이하 숫자만 입력 가능합니다.");
        }
    }

    private String convertNumberToDirection(int randomNumber) {
        if (randomNumber == 0) {
            return LOWER_DIRECTION;
        }
        return UPPER_DIRECTION;
    }
}
