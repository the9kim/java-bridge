package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int readBridgeSize() {
        System.out.println("다리 길이를 입력해주세요.");
        String bridgeSizeInput = Console.readLine();
        isDigit(bridgeSizeInput);
        return Integer.parseInt(bridgeSizeInput);
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

    private static void isDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 입력값이 숫자가 아닙니다.");
            }
        }
    }
}
