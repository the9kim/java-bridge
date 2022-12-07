package bridge.domain;

import java.util.Arrays;

public enum Movement {
    UP("U", 1),
    DOWN("D", 0);

    private final String direction;
    private final int randomNumber;

    Movement(String direction, int randomNumber) {
        this.direction = direction;
        this.randomNumber = randomNumber;
    }

    public static Movement findBy(String direction) {
        return Arrays.stream(Movement.values())
                .filter(movement -> movement.direction.equals(direction))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 연산자를 찾을 수 없습니다."));
    }


    public static String getDirectionByRandomNumber(int randomNumber) {
        for (Movement movement : Movement.values()) {
            if (movement.randomNumber == randomNumber) {
                return movement.direction;
            }
        }
        return null;
    }
}
