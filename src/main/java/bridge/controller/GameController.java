package bridge.controller;

import bridge.InputView;
import bridge.domain.Bridge;

public class GameController {

    InputController inputController = new InputController();

    public void run() {
        Bridge bridge = generateBride();
    }

    private Bridge generateBride() {
        Bridge bridge = inputController.createBridge(InputView.readBridgeSize());
        return null;
    }
}
