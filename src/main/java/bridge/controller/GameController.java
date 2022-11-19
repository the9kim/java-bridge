package bridge.controller;

import java.util.List;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.Movement;
import bridge.domain.Player;
import bridge.util.MessageUtil;

public class GameController {

    InputController inputController;

    public GameController(InputController inputController) {
        this.inputController =inputController;
    }

    public void run() {
        Bridge bridge = createBridge();
        Player player = setPlayer();
        crossABridge(bridge, player);
    }

    private Bridge createBridge() {
        int bridgeSizeInput = inputController.getBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSizeInput);
        return new Bridge(bridge);
    }

    private Player setPlayer() {
        return new Player();
    }

    private void crossABridge(Bridge bridge, Player player) {
        BridgeGame bridgeGame = new BridgeGame(bridge, player);

        Movement movementInput = inputController.getMovement();
        player.updateMovement(movementInput);
        bridgeGame.move(player.getDistance());

    }
}
