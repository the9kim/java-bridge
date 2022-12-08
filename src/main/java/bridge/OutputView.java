package bridge;

import bridge.domain.Answer;
import bridge.domain.Movement;
import bridge.domain.Result;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String UPPER_PRINT_LEVEL = "U";
    private static final String LOWER_PRINT_LEVEL = "D";
    private static final String OPENING_BRACKET = "[";
    private static final String CLOSING_BRACKET = "]";
    private static final String BLANK = " ";
    private static final String DIVIDER = "|";


    public static void printMap(BridgeGame bridgeGame, Result result) {
        StringBuilder upperString = addStrings(UPPER_PRINT_LEVEL, bridgeGame, result);
        StringBuilder lowerString = addStrings(LOWER_PRINT_LEVEL, bridgeGame, result);
        System.out.println(upperString);
        System.out.println(lowerString);
    }

    private static StringBuilder addStrings(String printLevel, BridgeGame bridgeGame, Result result) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(OPENING_BRACKET + BLANK);
        for (int i = 0; i < bridgeGame.getPlayer().size(); i++) {
            stringBuilder.append(addAnswerIndicator(printLevel, bridgeGame.getPlayer().get(i), result.getRoute().get(i)));
            stringBuilder.append(addDivider(i, bridgeGame));
        }
        stringBuilder.append(BLANK + CLOSING_BRACKET);
        return stringBuilder;
    }

    private static String addAnswerIndicator(String printLevel, Movement movement, Answer answer) {
        if (movement.getDirection().equals(printLevel)) {
            return answer.getIndicator();
        }
        return BLANK;
    }

    private static String addDivider(int i, BridgeGame bridgeGame) {
        if (i == bridgeGame.getPlayer().size() - 1) {
            return "";
        }
        return BLANK + DIVIDER + BLANK;
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame, bridgeGame.getResult());
        System.out.printf("게임 성공 여부: %s\n", bridgeGame.getResult().getResultComment());
        System.out.printf("총 시도한 횟수: %d\n", bridgeGame.getResult().getTrialNumber());
    }
}
