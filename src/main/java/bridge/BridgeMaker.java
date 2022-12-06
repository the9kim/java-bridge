package bridge;

import bridge.domain.Movement;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        validateSize(size);
        List<String> randomNumber = generateRandomNumber(size);
        return randomNumber;
    }

    private void validateSize(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 3이상 20이하의 숫자가 아닙니다");
        }
    }

    private List<String> generateRandomNumber(int size) {
        List<String> randomNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomNumber = bridgeNumberGenerator.generate();
            randomNumbers.add(Movement.getDirectionByRandomNumber(randomNumber));
        }
        return randomNumbers;
    }
}
