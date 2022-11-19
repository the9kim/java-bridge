package bridge.controller;

import bridge.domain.Movement;
import bridge.util.MessageUtil;
import bridge.util.ParserUtil;
import bridge.util.ValidationUtil;
import bridge.view.InputView;

public class InputController {

    public int getBridgeSize() {
        while(true) {
            try {
                return readAndParseBridgeSizeInput();
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int readAndParseBridgeSizeInput() {
        MessageUtil.bridgeSizeInputMsg();
        String bridgeSizeInput = InputView.readBridgeSize();
        ParserUtil.parseBridgeSize(bridgeSizeInput);
        int bridgeSize = Integer.parseInt(bridgeSizeInput);
        return bridgeSize;
    }

    public Movement getMovement() {
        while(true) {
            try {
                return readAndParseMovementInput();
            } catch(IllegalArgumentException e2) {
                System.out.println(e2.getMessage());
            }
        }
    }

    public Movement readAndParseMovementInput() {
        MessageUtil.movementInputMsg();
        String movementInput = InputView.readMoving();
        ParserUtil.parseMovement(movementInput);
        Movement movement = getMovement(movementInput);
        return movement;
    }



}
