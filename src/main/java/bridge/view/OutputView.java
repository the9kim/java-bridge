package bridge.view;

import bridge.BridgeGame;
import bridge.domain.Result;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String OPENING_BRACKET = "[";
    private static final String CLOSING_BRACKET = "]";
    private static final String DIVIDER = "|";
    private static final String BLANK = " ";
    private static final String UPPER_DIRECTION = "U";
    private static final String LOWER_DIRECTION = "D";



    public static void printMap(BridgeGame bridgeGame) {
        StringBuilder upperMap = addUpperMap(new StringBuilder(), bridgeGame);
        StringBuilder lowerMap = addLowerMap(new StringBuilder(), bridgeGame);
        System.out.println(upperMap);
        System.out.println(lowerMap);
    }

    private static StringBuilder addUpperMap(StringBuilder stringBuilder, BridgeGame bridgeGame) {
        stringBuilder.append(OPENING_BRACKET + BLANK);
        for (int i = 0; i < Result.getResult().size(); i++) {
            stringBuilder.append(addIndicator(bridgeGame, UPPER_DIRECTION, i));
            stringBuilder.append(addDivider(i));
        }
        stringBuilder.append(BLANK + CLOSING_BRACKET);
        return stringBuilder;
    }

    private static StringBuilder addLowerMap(StringBuilder stringBuilder, BridgeGame bridgeGame) {
        stringBuilder.append(OPENING_BRACKET + BLANK);
        for (int i = 0; i < Result.getResult().size(); i++) {
            stringBuilder.append(addIndicator(bridgeGame, LOWER_DIRECTION, i));
            stringBuilder.append(addDivider(i));
        }
        stringBuilder.append(BLANK + CLOSING_BRACKET);
        return stringBuilder;
    }

    private static String addIndicator(BridgeGame bridgeGame, String direction, int index) {
        if (bridgeGame.getRoute().get(index).equals(direction)) {
            return Result.getResult().get(index).getIndicator();
        }
        return BLANK;
    }

    private static String addDivider(int index) {
        if (index < Result.getResult().size()-1) {
            return BLANK + DIVIDER + BLANK;
        }
        return "";
    }



    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
