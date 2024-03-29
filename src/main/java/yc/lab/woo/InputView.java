//package yc.lab.woo;
//
//
//public class InputView {
//
//    public static int readBridgeSize() {
//        String size = Console.readLine();
//        try {
//            InputViewValidator.validate(size);
//        } catch (IllegalArgumentException e) {
//            OutputView.printExceptionMessage(e);
//            OutputView.printBridgeSize();
//            return readBridgeSize();
//        }
//        return Integer.parseInt(size);
//    }
//
//    public static String readMoving() {
//        String movingMark = Console.readLine();
//        try {
//            BridgeMark.validateInput(movingMark);
//        } catch (IllegalArgumentException | IllegalStateException e) {
//            OutputView.printExceptionMessage(e);
//            OutputView.printMove();
//            return readMoving();
//        }
//        return movingMark;
//    }
//
//    public static String readGameCommand() {
//        String command = Console.readLine();
//        try {
//            GameCommand.validateInput(command);
//        } catch (IllegalArgumentException e) {
//            OutputView.printExceptionMessage(e);
//            OutputView.printRestart();
//            return readGameCommand();
//        }
//        return command;
//    }
//}