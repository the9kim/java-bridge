package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.InputView;

import java.util.List;

public class InputController {
    public List<String> createBridge() {
        while (true) {
            try {
                BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
                return bridgeMaker.makeBridge(InputView.readBridgeSize());
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

    public static boolean checkRetry(BridgeGame bridgeGame) {
        while (true) {
            try {
                return bridgeGame.retry(InputView.readGameCommand());
            } catch (IllegalArgumentException e3) {
                System.out.println(e3.getMessage());
            }
        }
    }
}
