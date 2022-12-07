package bridge;

import bridge.domain.Movement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeGameTest {

    @DisplayName("이동할 방향을 잘못 입력하면 예외가 발생한다")
    @Test
    void moveWithWrongDirection() {
        BridgeGame bridgeGame = new BridgeGame();
        String input = "S";

        assertThatThrownBy(() -> {
            bridgeGame.move(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동 방향을 올바르게 입력하면 플레이어 이동방향이 올바로 업데이트 된다.")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void move(String input) {
        BridgeGame bridgeGame = new BridgeGame();

        bridgeGame.move(input);

        assertThat(bridgeGame.getPlayer()).containsAnyOf(Movement.UP, Movement.DOWN);
    }

}