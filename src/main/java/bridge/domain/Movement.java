package bridge.domain;

public enum Movement {
    UP("U", 1),
    DOWN("D", 0);

    String direction;
    int randomNumber;

    Movement(String direction, int randomNumber) {
        this.direction = direction;
        this.randomNumber = randomNumber;
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
