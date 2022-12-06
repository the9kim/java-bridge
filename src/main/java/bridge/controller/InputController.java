package bridge.controller;

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

}
