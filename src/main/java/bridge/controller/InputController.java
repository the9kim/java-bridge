package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.InputView;
import bridge.domain.Bridge;

public class InputController {

    public Bridge createBridge() {
        while (true) {
            try {
                BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
                return Bridge.of(bridgeMaker.makeBridge(InputView.readBridgeSize()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void movePlayer(BridgeGame bridgeGame) {
        while (true) {
            try {
                bridgeGame.move(InputView.readMoving());
                return;
            } catch (IllegalArgumentException e2) {
                System.out.println(e2.getMessage());
            }
        }
    }


    public boolean checkRetry(BridgeGame bridgeGame) {
        while (true) {
            try {
                return bridgeGame.retry(InputView.readGameCommand());
            } catch (IllegalArgumentException e3) {
                System.out.println(e3.getMessage());
            }
        }
    }
}
