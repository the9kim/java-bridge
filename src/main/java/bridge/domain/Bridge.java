package bridge.domain;

import java.util.List;

public class Bridge {

    List<String> randomNumber;

    private Bridge(List<String> randomNumbers) {
        this.randomNumber = randomNumbers;
    }

    public static Bridge of(List<String> randomNumber) {
        return new Bridge(randomNumber);
    }
}
