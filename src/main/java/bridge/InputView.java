package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int readBridgeSize() {
        System.out.println("다리 길이를 입력해주세요.");
        String bridgeSizeInput = Console.readLine();
        isDigit(bridgeSizeInput);
        isBlank(bridgeSizeInput);
        return Integer.parseInt(bridgeSizeInput);
    }

    public static String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        return input;
    }


    public static String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = Console.readLine();
        return input;
    }

    private static void isDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 입력값이 숫자가 아닙니다.");
            }
        }
    }

    private static void isBlank(String bridgeSizeInput) {
        if (bridgeSizeInput.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다.");
        }
    }
}
