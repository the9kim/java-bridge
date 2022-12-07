package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;

public class InputController {

    public Bridge createBridge(int readBridgeSize) {
        while (true) {
            try {
                BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
                Bridge.of(bridgeMaker.makeBridge(readBridgeSize));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public BridgeGame movePlayer(BridgeGame bridgeGame, String movingInput) {
        while (true) {
            try {
                bridgeGame.move(movingInput);
            } catch (IllegalArgumentException e2) {
                System.out.println(e2.getMessage());
            }
        }
    }


    public boolean checkRetry(BridgeGame bridgeGame, String gameCommand) {
        while (true) {
            try {
               return bridgeGame.retry(gameCommand);
            } catch (IllegalArgumentException e3) {
                System.out.println(e3.getMessage());
            }
        }
    }
}
