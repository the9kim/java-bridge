package bridge.controller;

import bridge.BridgeGame;
import bridge.InputView;
import bridge.OutputView;
import bridge.domain.Bridge;
import bridge.domain.Result;

public class GameController {

    InputController inputController = new InputController();

    public void run() {
        Bridge bridge = generateBride();
        acrossABridge(bridge);
    }

    private Bridge generateBride() {
        Bridge bridge = inputController.createBridge(InputView.readBridgeSize());
        return bridge;
    }

    private void acrossABridge(Bridge bridge) {
        BridgeGame bridgeGame = new BridgeGame();
        do {
            inputController.movePlayer(bridgeGame, InputView.readMoving());
            Result result = bridgeGame.updateResult(bridge);
            OutputView.printMap(bridgeGame, result);
        } while (bridgeGame.checkAnswer());
        if (inputController.checkRetry(bridgeGame, InputView.readGameCommand())) {
            acrossABridge(bridge);
        }
    }
}
