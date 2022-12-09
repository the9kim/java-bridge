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
        BridgeGame bridgeGame = crossABridge(bridge, new BridgeGame());
        OutputView.printResult(bridgeGame);
    }

    private List<String> generateBridge() {
        List<String> bridge = inputController.createBridge();
        return bridge;
    }

    private BridgeGame crossABridge(List<String> bridge, BridgeGame bridgeGame) {
        do {
            inputController.movePlayer(bridgeGame);
            bridgeGame.checkMovingResult(bridge);
            OutputView.printMap(bridgeGame);
        } while (bridgeGame.getPlayerRoute().size() < bridge.size() && Result.isIsSuccessOrFailure());
        checkRetry(bridge, bridgeGame);
        return bridgeGame;
    }

    private void checkRetry(List<String> bridge, BridgeGame bridgeGame) {
        if (!Result.isIsSuccessOrFailure() && InputController.checkRetry(bridgeGame)) {
            crossABridge(bridge, bridgeGame);
        }
    }
}
