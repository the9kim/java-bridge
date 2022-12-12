package bridge.controller;

import bridge.BridgeGame;
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
        BridgeGame bridgeGame = acrossABridge(new Result());

    }

    private List<String> generateBridge() {
        List<String> bridge = inputController.generateBridge();
        return bridge;
    }

    private BridgeGame acrossABridge(Result result) {
        BridgeGame bridgeGame = new BridgeGame();
        InputController.acrossABridge(bridgeGame);
        return bridgeGame;
    }

}
