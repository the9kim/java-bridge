package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;

import java.util.List;

public class InputController {

    public List<String> generateBridge() {
        while (true) {
            try {
                BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
                return bridgeMaker.makeBridge(InputView.readBridgeSize());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void acrossABridge(BridgeGame bridgeGame) {
        while (true) {
            try {
                String input = InputView.readMoving();
            } catch (IllegalArgumentException e2) {
                System.out.println(e2.getMessage());
            }
        }
    }
}
