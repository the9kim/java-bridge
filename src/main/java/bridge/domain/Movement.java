package bridge.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Movement {
    UP("U", 1),
    DOWN("D", 0);

    String direction;
    int randomDigit;

    Movement(String direction, int randomDigit) {
        this.direction = direction;
        this.randomDigit = randomDigit;
    }

    public String getDirection() {
        return direction;
    }

    public int getRandomDigit() {
        return randomDigit;
    }

    public static Movement getMovement(String direction) {
        Movement movement = Movement.findBy(direction);
        return movement;
    }

    private static Movement findBy(String direction) {
        for ( Movement movement : Movement.values()) {
            if (movement.direction.equals(direction)) {
                return movement;
            }
        }
        return null;
    }
    /*
    public static Movement getMovementFromDirection(String direction) {
        return Arrays.stream(values())
                .filter(Movement -> matchDirection(direction))
                .findFirst();
    }

    private boolean matchDirection(String direction) {
        return this.direction.equals(direction);

    }
    */
}
