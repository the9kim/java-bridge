package bridge.controller;

import bridge.BridgeGame;
import bridge.OutputView;
import bridge.domain.Result;

import java.util.List;

public class GameController {

    InputController inputController;

    public GameController(InputController inputController) {
        this.inputController = inputController;
    }

    public void run() {
        List<String> bridge = generateBridge();
        System.out.println(bridge);
        crossABridge(bridge, new BridgeGame());
    }

    private List<String> generateBridge() {
        List<String> bridge = inputController.createBridge();
        return bridge;
    }

    private void crossABridge(List<String> bridge, BridgeGame bridgeGame) {
        do {
            inputController.movePlayer(bridgeGame);
            bridgeGame.checkMovingResult(bridge);
            OutputView.printMap(bridgeGame);
        } while (bridgeGame.getPlayerRoute().size() < bridge.size() && Result.isIsSuccessOrFailure());
        if (!Result.isIsSuccessOrFailure() && InputController.checkRetry(bridgeGame)) {
            crossABridge(bridge, bridgeGame);
        }
    }
}
