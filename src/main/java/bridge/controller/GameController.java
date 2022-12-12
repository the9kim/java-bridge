package bridge.controller;

import java.util.List;

public class GameController {

    InputController inputController;

    public GameController(InputController inputController) {
        this.inputController = inputController;
    }

    public void run() {
        List<String> bridge = generateBridge();
    }

    private List<String> generateBridge() {
        List<String> bridge = inputController.generateBridge();
    }
}
