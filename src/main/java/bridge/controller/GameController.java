package bridge.controller;

import bridge.BridgeGame;
import bridge.domain.Answer;
import bridge.domain.Result;
import bridge.view.OutputView;

import java.util.List;

public class GameController {

    InputController inputController;

    public GameController(InputController inputController) {
        this.inputController = inputController;
    }

    public void run() {
        List<String> bridge = generateBridge();
        System.out.println(bridge);
        BridgeGame bridgeGame = acrossABridge(bridge);
        System.out.println(bridgeGame.getRoute());

    }

    private List<String> generateBridge() {
        List<String> bridge = inputController.generateBridge();
        return bridge;
    }

    private BridgeGame acrossABridge(List<String> bridge) {
        BridgeGame bridgeGame = new BridgeGame();
        do {
            String direction = InputController.acrossABridge(bridgeGame);
            bridgeGame.checkResult(bridge, direction);
            OutputView.printMap(bridgeGame);
        } while (bridgeGame.getRoute().size() < bridge.size() && !Result.getResult().contains(Answer.WRONG));
        checkRetry(bridge, bridgeGame);
        return bridgeGame;
    }

    private void checkRetry(List<String> bridge, BridgeGame bridgeGame) {
        if (Result.getResult().contains(Answer.WRONG) && inputController.checkRetry()) {
            bridgeGame.retry();
            acrossABridge(bridge);
        }
    }

}
