package bridge.controller;

import bridge.InputView;

import java.util.List;

public class InputController {
    public List<String> createBridge() {
        while(true) {
            try {
                InputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
