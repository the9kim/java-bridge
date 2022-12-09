package bridge.controller;

import java.util.List;

public class GameController {

    InputController inputController;

    public GameController(InputController inputController) {
        this.inputController = inputController;
    }

    public void run() {
        List<String> bridge = generateBridge();
        crossABridge(bridge);
    }

    private List<String> generateBridge() {
        List<String> bridge = inputController.createBridge();
        return bridge;
    }

    private void crossABridge(List<String> bridge) {
        inputController.movePlayer();
    }
}
