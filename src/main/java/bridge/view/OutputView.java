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
        System.out.println(lowerMap+"\n");
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

    public static void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame);
        System.out.printf("게임 성공 여부: %s\n", Result.getSuccessOrFailure());
        System.out.printf("총 시도한 횟수: %d", Result.getTrialNumber());
    }
}
