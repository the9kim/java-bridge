package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeMakerTest {

    @DisplayName("3미만, 20초과 숫자를 입력하여 다리를 생성할 경우 예외가 발생한다.")
    @ValueSource(ints = {0, 1, 2, 21, 22})
    @ParameterizedTest
    void makeBridgeWithWrongRangeInput(int input) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        assertThatThrownBy(() -> {
            bridgeMaker.makeBridge(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 다리 길이 값을 입력할 경우 정상적으로 다리가 생성된다")
    @Test
    void makeBridge() {
        int bridgeSize = 3;
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        assertThat(bridge).containsAnyOf("U", "D");
        System.out.println(bridge);
    }
}