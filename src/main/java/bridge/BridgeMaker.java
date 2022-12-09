package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final String UPPER_DIRECTION = "U";
    private static final String LOWER_DIRECTION = "D";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        validate(size);
        for (int i = 0; i < size; i++) {
            int randomNumber = bridgeNumberGenerator.generate();
            bridge.add(convertNumToDirection(randomNumber));
        }
        return bridge;
    }

    private void validate(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 3이상 20이하 정수가 아닙니다.");
        }
    }

    private String convertNumToDirection(int randomNumber) {
        if (randomNumber == 1) {
            return UPPER_DIRECTION;
        }
        return LOWER_DIRECTION;
    }

}
