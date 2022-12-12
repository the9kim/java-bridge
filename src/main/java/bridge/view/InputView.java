package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import java.text.Format;
import java.util.regex.Pattern;

public class InputView {

    public static int readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");
        String bridgeSize = Console.readLine();
        validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String direction = Console.readLine();
        validateDirection(direction);
        return direction;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private static void validateBridgeSize(String bridgeSize) {
        String format = "\\d+";

        if (!Pattern.matches(format, bridgeSize)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이 입력값이 양식에 맞지 않습니다.");
        }
    }

    private static void validateDirection(String direction) {
        String format = "[UD]";
        if (!Pattern.matches(format, direction)) {
            throw new IllegalArgumentException("[ERROR] 방향 입력값이 양식에 맞지 않습니다.");
        }
    }
}
