package bridge.controller;

import java.util.List;

public class GameController {

    InputController inputController;

    public GameController(InputController inputController) {
        this.inputController = inputController;
    }

    public void run() {
        List<String> bridge = generateBridge();
        System.out.println(bridge);
    }

    private List<String> generateBridge() {
        List<String> bridge = inputController.generateBridge();
        return bridge;
    }
}
