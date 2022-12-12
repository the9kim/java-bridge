package bridge.view;

import camp.nextstep.edu.missionutils.Console

import java.text.Format;
import java.util.regex.Pattern;

public class InputView {

    public static int readBridgeSize() {
        String bridgeSize = Console.readLine();
        validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private static void validateBridgeSize(String bridgeSize) {
        String format = "\\d+";

        if (Pattern.matches(format, bridgeSize)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이 입력값이 양식에 맞지 않습니다.");
        }
    }
}
