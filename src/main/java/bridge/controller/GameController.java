package bridge.controller;

import bridge.BridgeGame;

import java.util.List;

public class GameController {

    InputController inputController;

    public GameController(InputController inputController) {
        this.inputController = inputController;
    }

    public void run() {
        List<String> bridge = generateBridge();
        crossABridge(bridge, new BridgeGame());
    }

    private List<String> generateBridge() {
        List<String> bridge = inputController.createBridge();
        return bridge;
    }

    private void crossABridge(List<String> bridge, BridgeGame bridgeGame) {
        do {
            inputController.movePlayer(bridgeGame);
            boolean result = bridgeGame.checkMovingResult(bridge);

        } while ();

    }
}
