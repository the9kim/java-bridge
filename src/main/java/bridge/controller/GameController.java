package bridge.controller;

import bridge.BridgeGame;
import bridge.OutputView;
import bridge.domain.Bridge;
import bridge.domain.Result;

public class GameController {

    InputController inputController = new InputController();

    public void run() {
        Bridge bridge = generateBride();
        BridgeGame bridgeGame = acrossABridge(bridge, new BridgeGame());
        OutputView.printResult(bridgeGame);
    }

    private Bridge generateBride() {
        Bridge bridge = inputController.createBridge();
        return bridge;
    }

    private BridgeGame acrossABridge(Bridge bridge, BridgeGame bridgeGame) {
        do {
            inputController.movePlayer(bridgeGame);
            Result result = bridgeGame.updateResult(bridge);
            OutputView.printMap(bridgeGame, result);
        } while (bridgeGame.checkAnswer() && bridgeGame.getGameRound() < bridge.getBridgeSize());
        checkRetrial(bridge, bridgeGame);
        return bridgeGame;
    }

    private void checkRetrial(Bridge bridge, BridgeGame bridgeGame) {
        if (!bridgeGame.checkAnswer() && inputController.checkRetry(bridgeGame)) {
            acrossABridge(bridge, bridgeGame);
        }
    }
}
