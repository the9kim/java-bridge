package bridge;

import bridge.domain.Result;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {


    private static final String OPENING_BRACKET = "[";
    private static final String CLOSING_BRACKET = "]";
    private static final String BLANK = " ";
    private static final String DIVIDER = "|";
    private static final String UPPER_DIRECTION = "U";
    private static final String LOWER_DIRECTION = "D";

    public static void printMap(BridgeGame bridgeGame) {
        StringBuilder upperStringBuilder = makeUpperLine(new StringBuilder(), bridgeGame);
        StringBuilder lowerStringBuilder = makeLowerLine(new StringBuilder(), bridgeGame);
        System.out.println(upperStringBuilder);
        System.out.println(lowerStringBuilder);
    }

    private static StringBuilder makeUpperLine(StringBuilder stringBuilder, BridgeGame bridgeGame) {
        stringBuilder.append(OPENING_BRACKET+BLANK);
        for (int i = 0; i < Result.getMovingResult().size(); i++) {
            stringBuilder.append(addAnswerIndicator(UPPER_DIRECTION, i, bridgeGame));
            stringBuilder.append(addDivider(i));
        }
        stringBuilder.append(BLANK+CLOSING_BRACKET);
        return stringBuilder;
    }

    private static StringBuilder makeLowerLine(StringBuilder stringBuilder, BridgeGame bridgeGame) {
        stringBuilder.append(OPENING_BRACKET+BLANK);
        for (int i = 0; i < Result.getMovingResult().size(); i++) {
            stringBuilder.append(addAnswerIndicator(LOWER_DIRECTION, i, bridgeGame));
            stringBuilder.append(addDivider(i));
        }
        stringBuilder.append(BLANK+CLOSING_BRACKET);
        return stringBuilder;
    }
    private static String addAnswerIndicator(String direction, int index, BridgeGame bridgeGame) {
        if (direction.equals(bridgeGame.getPlayerRoute().get(index))) {
            return Result.getMovingResult().get(index).getIndicator();
        }
        return BLANK;
    }

    private static String addDivider(int index) {
        if (index == Result.getMovingResult().size()-1) {
            return "";
        }
        return BLANK+DIVIDER+BLANK;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
