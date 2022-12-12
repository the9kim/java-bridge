package bridge;

import bridge.controller.GameController;
import bridge.controller.InputController;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController(new InputController());
        gameController.run();
    }
}
